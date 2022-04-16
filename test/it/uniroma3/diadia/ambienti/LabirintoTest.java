package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	
	protected Labirinto labirinto;
	
	//private Stanza stanzaVincente;
	
	//private static final String STANZA_VINCENTE = "Stanza vincente";

	@Before
	public void setUp() throws Exception {
		this.labirinto = new Labirinto();
		//this.stanzaVincente = new Stanza(STANZA_VINCENTE);
	}


	
	@Test
	public void testGetStanzaVincente_notNull() {
		assertNotNull(this.labirinto.getStanzaVincente());
	}
	
	@Test
	public void testGetStanzaIniziale_notNull() {
		assertNotNull(this.labirinto.getStanzaIniziale());
	}
	

}
