package it.uniroma3.diadia;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	
	private Partita partita;
	private Labirinto labirinto;

	@Before
	public void setUp() throws Exception {
		this.labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("stanzaIniziale")
				.getLabirinto();
		this.partita = new Partita(labirinto);
	}
	
	
	@Test
	public void testIsFinita() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testVintaSeStanzaCorrenteVincente() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testNonVintaSeStanzaCorrenteNonVincente() {
		this.partita.setStanzaCorrente(new Stanza("NonVincente"));
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testNonVintaInizioPartita() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testFinitaSeVinta() {
		this.partita.setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinitaSeSettato() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testFinitaSeCfuFiniti() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testNonFinitaInizioPartita() {
		assertFalse(this.partita.isFinita());
	}

}
