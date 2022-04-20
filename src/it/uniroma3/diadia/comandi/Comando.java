package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public interface Comando {
	/**
	 * esecuzione del comando
	 */
	public void esegui(Partita partita);
	/**
	 * set parametro del comando
	 */
	void setParametro(String parametro);

	void setIO(IO console);
	
	String getNome();
	String getParametro();
}