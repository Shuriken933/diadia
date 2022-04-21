package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia stanzaBuia;
	private Attrezzo attrezzo;

	@Before
	public void setUp(){
		this.stanzaBuia = new StanzaBuia("stanza", "lanterna");
	}

	@Test
	public void testGetDescrizione_stanzaSenzaAttrezzoLuminoso() {
		assertEquals("Qui c'� un buio pesto!", this.stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetDescrizione_stanzaConAttrezzoLuminoso() {
		this.attrezzo = new Attrezzo("lanterna", 1);
		this.stanzaBuia.addAttrezzo(attrezzo);
		assertNotEquals("Qui c'� un buio pesto!", this.stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetDescrizione_stanzaConAttrezzoNonLuminoso() {
		this.attrezzo = new Attrezzo("attrezzo", 1);
		this.stanzaBuia.addAttrezzo(attrezzo);
		assertEquals("Qui c'� un buio pesto!", this.stanzaBuia.getDescrizione());
	}

}