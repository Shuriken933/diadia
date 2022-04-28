package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando {
	
	static final public String MESSAGGIO_FINE = "Grazie di aver giocato!";
	public static final String NOME = "fine";	
	private IO io;

	@Override
	public void esegui(Partita partita) {
			this.io.mostraMessaggio(MESSAGGIO_FINE);  // si desidera smettere
			partita.isFinita();
	}

	@Override
	public void setParametro(String parametro) {
		// nessun parametro
	}

	@Override
	public void setIO(IO console) {
		this.io = console;
	}
	
	@Override
	public String getNome() {
		return NOME;
		
	}

	@Override
	public String getParametro() {
		return "";
		
	}

}
