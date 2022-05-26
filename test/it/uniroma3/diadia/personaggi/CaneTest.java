package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaneTest {
	
	private Partita partita;
	private Cane cane;
	private Attrezzo regalo;
	private Attrezzo ciboPreferito;

	@Before
	public void setUp() throws Exception {
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.getLabirinto();
		this.partita = new Partita(labirinto);
		this.regalo= new Attrezzo("chiave", 2);
		this.ciboPreferito = new Attrezzo("osso", 4);
		this.cane = new Cane("cane", "presentazione", this.regalo, this.ciboPreferito.getNome());
	}

	@Test
	public void testAgsci() {
		this.partita.setCfu(5);
		this.cane.agisci(this.partita);
		assertEquals(4, this.partita.getCfu());
	}
	
	@Test
	public void testRiceviRegalo_CiboPreferito() {
		this.cane.riceviRegalo(this.ciboPreferito, this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
	}	
	
	@Test
	public void testRiceviRegalo_CiboNonPreferito() {
		this.partita.setCfu(5);
		Attrezzo CiboSbagliato = new Attrezzo("mela", 3);
		this.cane.riceviRegalo(CiboSbagliato, partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo(CiboSbagliato.getNome()));
		assertEquals(4, this.partita.getCfu());
	}

}
