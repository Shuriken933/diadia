package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	
	private StanzaBloccata stanzaBloccata;
	private Stanza stanzaAdiacente;

	@Before
	public void setUp() throws Exception {
		this.stanzaBloccata = new StanzaBloccata("stanza bloccata", "chiave", Direzione.NORD);
		this.stanzaAdiacente = new Stanza("stanza adiacente");
		this.stanzaBloccata.impostaStanzaAdiacente(Direzione.NORD, stanzaAdiacente);
	}

	@Test
	public void test_direzioneBloccata() {
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente(Direzione.NORD));
	}
	
	@Test
	public void test_direzioneSbloccata() {
		Attrezzo attrezzoSbloccante = new Attrezzo("chiave", 1);
		this.stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals("stanza adiacente", this.stanzaBloccata.getStanzaAdiacente(Direzione.NORD).getNome());
	}
	
	@Test
	public void test_conAttrezzoSbagliato() {
		Attrezzo attrezzoSbloccante = new Attrezzo("manopola", 1);
		this.stanzaBloccata.addAttrezzo(attrezzoSbloccante);
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente(Direzione.NORD));
	}
	
	

}
