package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class MagoTest {
	
	private Mago mago;
	private Attrezzo regalo;
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("LabCampusOne")
				.getLabirinto();
		this.regalo = new Attrezzo("chiave", 4);
		this.partita = new Partita(labirinto);
		this.mago = new Mago("mago", "presentazione", this.regalo);
	}

	@Test
	public void testAgisci() {
		this.mago.agisci(partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
	}
	
	@Test
	public void testRiceviRegalo() {
	this.mago.riceviRegalo(this.regalo, this.partita);
	assertEquals(2, this.regalo.getPeso());
	assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
	}

}
