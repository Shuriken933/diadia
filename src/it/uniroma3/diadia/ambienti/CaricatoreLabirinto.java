package it.uniroma3.diadia.ambienti;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaricatoreLabirinto {

	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
	private static final String STANZE_MARKER = "Stanze:";  
	
	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze buie */
    private static final String STANZEBUIE_MARKER = "Buie:";

    /* prefisso di una singola riga di testo contenente tutti i nomi delle stanze bloccate */
    private static final String STANZEBLOCCATE_MARKER = "Bloccate:";
    
    /* prefisso di una singola riga di testo contenente tutti i nomi delle stanze magiche */
	private static final String STANZEMAGICHE_MARKER = "Magiche:";

	/* prefisso di una singola riga contenente il nome della stanza iniziale */
	private static final String STANZA_INIZIALE_MARKER = "Inizio:";    

	/* prefisso della riga contenente il nome stanza vincente */
	private static final String STANZA_VINCENTE_MARKER = "Vincente:";  

	/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeAttrezzo> <peso> <nomeStanza> */
	private static final String ATTREZZI_MARKER = "Attrezzi:";

	/* prefisso della riga contenente le specifiche dei collegamenti tra stanza nel formato <nomeStanzaDa> <direzione> <nomeStanzaA> */
	private static final String USCITE_MARKER = "Uscite:";
	
	/* prefisso della riga contenente l'informazione che avvisa il gioco se quello è l'ultimo livello o no*/
    private static final String FINE_MARKER = "UltimoLivello:";

	/*
	 *  Esempio di un possibile file di specifica di un labirinto (vedi POO-26-eccezioni-file.pdf)

		Stanze: biblioteca, N10, N11
		Inizio: N10
		Vincente: N11
		Attrezzi: martello 10 biblioteca, pinza 2 N10
		Uscite: biblioteca nord N10, biblioteca sud N11

	 */
	
	private LineNumberReader reader;

    private Map<String, Stanza> nome2stanza = new HashMap<>();

    private Stanza stanzaIniziale;
    private Stanza stanzaVincente;
    private boolean ultimolivello = false;


    public CaricatoreLabirinto(int indicatoreDiLivello) throws FileNotFoundException {
        this(new FileReader("livelli" + File.separator + "Livello" + indicatoreDiLivello));
    }

    public CaricatoreLabirinto(Reader reader) {
        this.reader = new LineNumberReader(reader);
    }

    public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
        this(new FileReader(nomeFile));
    }

    public void carica() throws FormatoFileNonValidoException {
        try {
            this.leggiECreaStanze();
            this.leggiECreaStanzeBloccate();
            this.leggiECreaStanzeBuie();
            this.leggiECreaStanzeMagiche();
            this.leggiInizialeEvincente();
            this.leggiECollocaAttrezzi();
            this.leggiEImpostaUscite();
            this.setUltimoLivello();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

    }

    private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
        try {
            String riga = this.reader.readLine();
            check(riga.startsWith(marker), "era attesa una riga che cominciasse per " + marker);
            return riga.substring(marker.length()).trim();
        } catch (IOException e) {
            throw new FormatoFileNonValidoException(e.getMessage());
        }
    }

    private void leggiECreaStanze() throws FormatoFileNonValidoException {
        String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
        nomiStanze = nomiStanze.replaceAll(" ", "");
        for (String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
            Stanza stanza = new Stanza(nomeStanza);
            this.nome2stanza.put(nomeStanza, stanza);
        }
    }

    private void leggiECreaStanzeBuie() throws FormatoFileNonValidoException {
        String nomiStanzeBuie = this.leggiRigaCheCominciaPer(STANZEBUIE_MARKER);
        List<String> separaStringheAlleVirgole = separaStringheAlleVirgole(nomiStanzeBuie);
        for (String specificaStanza : separaStringheAlleVirgole) {
            String nomeStanza;
            String attrezzoLuminoso;
            try (Scanner scannerLinea = new Scanner(specificaStanza)) {
                check(scannerLinea.hasNext(), msgTerminazionePrecoce("il nome di una stanza."));
                nomeStanza = scannerLinea.next().trim();
                check(scannerLinea.hasNext(), msgTerminazionePrecoce("attrezzo che illumina la stanza " + nomeStanza + "."));
                attrezzoLuminoso = scannerLinea.next().trim();
            }
            StanzaBuia stanza = new StanzaBuia(nomeStanza, attrezzoLuminoso);
            this.nome2stanza.put(nomeStanza, stanza);
        }
    }

    private void leggiECreaStanzeBloccate() throws FormatoFileNonValidoException {
        String nomiStanzeBloccate = this.leggiRigaCheCominciaPer(STANZEBLOCCATE_MARKER);
        List<String> separaStringheAlleVirgole = separaStringheAlleVirgole(nomiStanzeBloccate);
        for (String specificaStanza : separaStringheAlleVirgole) {
            String nomeStanza;
            String direzioneBloccata;
            String attrezzoCheSblocca;
            try (Scanner scannerLinea = new Scanner(specificaStanza)) {
                check(scannerLinea.hasNext(), msgTerminazionePrecoce("il nome della stanza."));
                nomeStanza = scannerLinea.next().trim();
                check(scannerLinea.hasNext(), msgTerminazionePrecoce("la direzione bloccata della stanza " + nomeStanza + "."));
                direzioneBloccata = scannerLinea.next().trim();
                check(scannerLinea.hasNext(), msgTerminazionePrecoce("l'attrezzo che sblocca " + nomeStanza + "."));
                attrezzoCheSblocca = scannerLinea.next().trim();
            }
            StanzaBloccata stanza = new StanzaBloccata(nomeStanza, attrezzoCheSblocca, /*direzioneBloccata*/ Direzione.valueOf(direzioneBloccata));
            this.nome2stanza.put(nomeStanza, stanza);

        }
    }
    
    private void leggiECreaStanzeMagiche() throws FormatoFileNonValidoException {
		String nomiStanzeMagiche = this.leggiRigaCheCominciaPer(STANZEMAGICHE_MARKER);
		for(String nomeStanza : separaStringheAlleVirgole(nomiStanzeMagiche)) {
			Stanza stanzaMagica = new StanzaMagica(nomeStanza);
			this.nome2stanza.put(nomeStanza, stanzaMagica);
		}
	}

    private List<String> separaStringheAlleVirgole(String string) {
        List<String> result = new LinkedList<>();
        Scanner scannerDiParole = new Scanner(string);
        scannerDiParole.useDelimiter(",");
        while (scannerDiParole.hasNext()) {
            result.add(scannerDiParole.next().trim());
        }
        return result;
    }


    private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
        String nomeStanzaIniziale;
        nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);
        check(this.isStanzaValida(nomeStanzaIniziale), nomeStanzaIniziale + " non definita");
        String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);
        check(this.isStanzaValida(nomeStanzaVincente), nomeStanzaVincente + " non definita");
        this.stanzaIniziale = this.nome2stanza.get(nomeStanzaIniziale);
        this.stanzaVincente = this.nome2stanza.get(nomeStanzaVincente);
    }

    private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
        String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);

        for (String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
            String nomeAttrezzo;
            String pesoAttrezzo;
            String nomeStanza;
            try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
                check(scannerLinea.hasNext(), msgTerminazionePrecoce("il nome di un attrezzo."));
                nomeAttrezzo = scannerLinea.next().trim();
                check(scannerLinea.hasNext(), msgTerminazionePrecoce("il peso dell'attrezzo " + nomeAttrezzo + "."));
                pesoAttrezzo = scannerLinea.next().trim();
                check(scannerLinea.hasNext(), msgTerminazionePrecoce("il nome della stanza in cui collocare l'attrezzo " + nomeAttrezzo + "."));
                nomeStanza = scannerLinea.next().trim();
            }
            posaAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
        }
    }

    private void posaAttrezzo(String nomeAttrezzo, String pesoAttrezzo, String nomeStanza) throws FormatoFileNonValidoException {
        int peso;
        try {
            peso = Integer.parseInt(pesoAttrezzo);
            Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
            check(isStanzaValida(nomeStanza), "Attrezzo " + nomeAttrezzo + " non collocabile: stanza " + nomeStanza + " inesistente");
            this.nome2stanza.get(nomeStanza).addAttrezzo(attrezzo);
        } catch (NumberFormatException e) {
            check(false, "Peso attrezzo " + nomeAttrezzo + " non valido");
        }
    }


    private boolean isStanzaValida(String nomeStanza) {
        return this.nome2stanza.containsKey(nomeStanza);
    }

    private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
        String stringaUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);

        List<String> list = separaStringheAlleVirgole(stringaUscite);
        for (String specificheUscite : list) {
            try (Scanner scannerDiLinea = new Scanner(specificheUscite)) {
                while (scannerDiLinea.hasNext()) {
                    check(scannerDiLinea.hasNext(), msgTerminazionePrecoce("le uscite di una stanza."));
                    String stanzaPartenza = scannerDiLinea.next().trim();
                    check(scannerDiLinea.hasNext(), msgTerminazionePrecoce("la direzione di una uscita della stanza " + stanzaPartenza));
                    String dir = scannerDiLinea.next().trim();
                    check(scannerDiLinea.hasNext(), msgTerminazionePrecoce("la destinazione di una uscita della stanza " + stanzaPartenza + " nella direzione " + dir));
                    String stanzaDestinazione = scannerDiLinea.next().trim();

                    impostaUscita(stanzaPartenza, dir, stanzaDestinazione);
                    impostaUscita(stanzaDestinazione, getDirezioneOpposta(dir), stanzaPartenza);
                }
            }
        }


    }

    private String msgTerminazionePrecoce(String msg) {
        return "Terminazione precoce del file prima di leggere " + msg;
    }

    private void impostaUscita(String stanzaDa, String dir, String nomeA) throws FormatoFileNonValidoException {
        check(isStanzaValida(stanzaDa), "Stanza di partenza sconosciuta " + dir);
        check(isStanzaValida(nomeA), "Stanza di destinazione sconosciuta " + dir);
        Stanza partenzaDa = this.nome2stanza.get(stanzaDa);
        Stanza arrivoA = this.nome2stanza.get(nomeA);
        partenzaDa.impostaStanzaAdiacente(Direzione.valueOf(dir), arrivoA);
    }


    private void check(boolean condizioneCheDeveEsseraVera, String messaggioErrore) throws FormatoFileNonValidoException {
        if (!condizioneCheDeveEsseraVera)
            throw new FormatoFileNonValidoException("Formato file non valido [" + this.reader.getLineNumber() + "] " + messaggioErrore);
    }

    private String getDirezioneOpposta(String direzione) {
        switch (direzione) {
            case "nord":
                return "sud";
            case "sud":
                return "nord";
            case "est":
                return "ovest";
            case "ovest":
                return "est";
            default:
                return null;
        }
    }

    public void setUltimoLivello() throws FormatoFileNonValidoException {
        String riga = this.leggiRigaCheCominciaPer(FINE_MARKER);
        this.ultimolivello = Boolean.parseBoolean(riga);
    }

    public boolean getUltimoLivello() {
        return this.ultimolivello;
    }

    public Stanza getStanzaIniziale() {
        return this.stanzaIniziale;
    }

    public Stanza getStanzaVincente() {
        return this.stanzaVincente;
    }
}
