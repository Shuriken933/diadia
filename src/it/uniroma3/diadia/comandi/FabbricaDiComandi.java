package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;

public interface FabbricaDiComandi {
	
	public AbstractComando costruisciComando(String istruzione, IO io);
}

