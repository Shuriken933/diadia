package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {
	
	private IO io;

	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Ti trovi in: " + partita.getStanzaCorrente().toString());
		this.io.mostraMessaggio("Ti sono rimasti " + partita.getGiocatore().getCfu() + "cfu");
		this.io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
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
		return "guarda";
		
	}

	@Override
	public String getParametro() {
		return "";
		
	}

}
