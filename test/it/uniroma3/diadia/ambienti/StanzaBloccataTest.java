package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaAdiacente;

	@Before
	public void setUp() throws Exception {
		this.stanzaBloccata = new StanzaBloccata("stanza bloccata");
		this.stanzaAdiacente = new Stanza("stanza adiacente");
		this.stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
	}

	@Test
	public void test_direzioneBloccata() {
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void test_direzioneSbloccata() {
		Attrezzo attrezzoSbloccante = new Attrezzo("chiave", 1);
		this.stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals("stanza adiacente", this.stanzaBloccata.getStanzaAdiacente("nord").getNome());
	}
	
	@Test
	public void test_conAttrezzoSbagliato() {
		Attrezzo attrezzoSbloccante = new Attrezzo("manopola", 1);
		this.stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	

}
