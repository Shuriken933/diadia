package it.uniroma3.diadia.ambienti;

/**
 * Questa classe modella un labirinto
 *
 * @author studenti
 * @see Stanza
 * @version 0.3
 */


public class Labirinto {
	
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
    
    public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

}
