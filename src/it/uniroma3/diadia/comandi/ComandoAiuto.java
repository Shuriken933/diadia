package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi"};

	/**
	 * Stampa informazioni di aiuto.
	 */
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) {
			System.out.println(elencoComandi[i]+" ");
			// io.mostraMessaggio(elencoComandi[i]+" ");
		}
	}

	@Override
	public void setParametro(String parametro) {

	}

}
