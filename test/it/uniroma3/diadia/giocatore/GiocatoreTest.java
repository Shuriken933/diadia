package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
	
	protected Giocatore giocatore;

	@Before
	public void setUp() throws Exception {
		this.giocatore = new Giocatore();
	}

	@Test
	public void testGetCfu() {
		assertEquals(Giocatore.CFU_INIZIALI, this.giocatore.getCfu());
	}
	
	@Test
	public void testSetCfu() {
		this.giocatore.setCfu(2);
		assertEquals(2, this.giocatore.getCfu());
	}

}
