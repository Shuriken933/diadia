package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

//	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi"};

	private Partita partita;
	private IO io;

	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io = new IOConsole();
	}

	public void gioca() {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {
			io.mostraMessaggio("");
			istruzione = this.io.leggiRiga();
			io.mostraMessaggio("");
		}while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */

	private boolean processaIstruzione(String istruzione) {

		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();

		comandoDaEseguire = factory.costruisciComando(istruzione, io);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			System.out.println("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			System.out.println("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}
	//	private boolean processaIstruzione(String istruzione) {
	//		Comando comandoDaEseguire = new Comando(istruzione);
	//
	//		if(comandoDaEseguire.getNome() == null) {
	//			io.mostraMessaggio("Devi inserire un comando");
	//			return false;
	//		}
	//
	//		else if (comandoDaEseguire.getNome().equals("fine")) {
	//			this.fine(); 
	//			return true;
	//		} else if (comandoDaEseguire.getNome().equals("vai")) {
	//			this.vai(comandoDaEseguire.getParametro());
	//			//this.partita.getGiocatore().decrementaCfu();
	//		}
	//
	//		else if (comandoDaEseguire.getNome().equals("aiuto")) {
	//			this.aiuto();
	//		}
	//
	//		else if (comandoDaEseguire.getNome().equals("prendi")) {
	//			this.prendi(comandoDaEseguire.getParametro());
	//		}
	//
	//		else if (comandoDaEseguire.getNome().equals("posa")) {
	//			this.posa(comandoDaEseguire.getParametro());
	//		}
	//
	//		else {
	//			io.mostraMessaggio("Comando sconosciuto");
	//		}
	//
	//		if (this.partita.vinta()) {
	//			io.mostraMessaggio("Hai vinto!");
	//			return true;
	//		} else
	//			return false;
	//	}   


	// implementazioni dei comandi dell'utente:

	/**
	 * Posa un oggetto se la stanza ha ancora spazio
	 */
//	private void posa(String nomeAttrezzo) {
//		if(!this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
//			io.mostraMessaggio("Attrezzo "+nomeAttrezzo+" non presente nella borsa!");
//			return;
//		}
//		this.partita.getStanzaCorrente().addAttrezzo(this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo));
//		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
//		io.mostraMessaggio("Attrezzo "+nomeAttrezzo+" posato!");
//	}

	/**
	 * Prendi un oggetto se la tua borsa non è piena
	 */
//	private void prendi(String nomeAttrezzo) {
//		if(!this.partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
//			io.mostraMessaggio("Attrezzo "+nomeAttrezzo+" non presente!");
//			return;
//		}
//		Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
//		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
//		this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
//		io.mostraMessaggio("Attrezzo "+nomeAttrezzo+" preso!");
//	}

	/**
	 * Stampa informazioni di aiuto.
	 */
//	private void aiuto() {
//		for(int i=0; i< elencoComandi.length; i++) 
//			io.mostraMessaggio(elencoComandi[i]+" ");
//	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
//	private void vai(String direzione) {
//		if(direzione==null)
//			io.mostraMessaggio("Dove vuoi andare ?");
//		Stanza prossimaStanza = null;
//		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
//		if (prossimaStanza == null)
//			io.mostraMessaggio("Direzione inesistente");
//		else {
//			this.partita.setStanzaCorrente(prossimaStanza);
//			int cfu = this.partita.getGiocatore().getCfu();
//			this.partita.getGiocatore().setCfu(cfu--);
//		}
//		io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
//	}

	/**
	 * Comando "Fine".
	 */
//	private void fine() {
//		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
//	}

	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}