package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando {

	private static final String NOME = "regala";
	private static final String MESSAGGIO_BORSA_VUOTA = "Mi dispiace ma non hai attrezzi nella borsa!";

	public ComandoRegala( ) {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(super.getParametro())) {
			super.getIo().mostraMessaggio("Attrezzo "+super.getParametro()+" non presente nella borsa!");
			return;
		}
		
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(super.getParametro());
		if (personaggio!=null) {
			personaggio.riceviRegalo(attrezzo, partita);
			return;
		}
		else {
			super.getIo().mostraMessaggio("Non c'è nessuno :-(");
		}
	}

}


