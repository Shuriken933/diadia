package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoRegala extends AbstractComando {

	private static final String NOME = "regala";
	private static final String MESSAGGIO_BORSA_VUOTA = "Mi dispiace ma non hai attrezzi nella borsa!";

	public ComandoRegala( ) {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {

	}

}


