package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	protected Labirinto labirinto;
	
	//private Stanza stanzaVincente;
	private static final String STANZA_INIZIALE = "Stanza iniziale";
	private static final String STANZA_VINCENTE = "Stanza vincente";
	
	@Before
	public void setUp() throws Exception {
		this.labirinto = Labirinto.newBuilder()
				.addStanzaIniziale(STANZA_INIZIALE)
				.addStanzaVincente(STANZA_VINCENTE)
				.getLabirinto();
	}


	@Test
	public void testGetStanzaIniziale() {
		assertEquals(STANZA_INIZIALE, this.labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals(STANZA_VINCENTE, this.labirinto.getStanzaVincente().getNome());
	}
	
	
}
