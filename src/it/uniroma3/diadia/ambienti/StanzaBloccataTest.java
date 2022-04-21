package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaAdiacente;
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.stanzaBloccata = new StanzaBloccata("stanza bloccata");
		this.stanzaAdiacente = new Stanza("stanza adiacente");
		this.stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
		this.partita.setStanzaCorrente(stanzaBloccata);
	}

	@Test
	public void test_direzioneBloccata() {
		assertEquals(null, this.stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void test_direzioneSbloccata() {
		Attrezzo attrezzoSbloccante = new Attrezzo("chiave", 1);
		this.stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals("stanza adiacente", this.stanzaBloccata.getStanzaAdiacente("nord").getNome());
	}
	
	

}
