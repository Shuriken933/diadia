package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {

	private IO io;
	private String nome;
	private String parametro;

	public abstract void esegui(Partita partita);

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	public String getParametro() {
		return this.parametro;		
	}

	public void setIO(IO console) {
		this.io = console;
	}

	public IO getIo() {
		return this.io;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
