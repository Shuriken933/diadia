package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {
	
	private Attrezzo attrezzoDiTest;
	private StanzaMagica stanzaMagica;

	@Before
	public void setUp() throws Exception {
		attrezzoDiTest = new Attrezzo("attrezzoDiTest", 1);
		stanzaMagica = new StanzaMagica("stanzaDiTest", 1);
	}

	@Test
	public void test_effettoMagico() {
		this.stanzaMagica.addAttrezzo(attrezzoDiTest);
		this.stanzaMagica.removeAttrezzo(attrezzoDiTest);
		this.stanzaMagica.addAttrezzo(attrezzoDiTest);
		assertEquals(2, this.stanzaMagica.getContatoreAttrezziPosati());
		assertEquals(2, this.stanzaMagica.getAttrezzo("tseTiDozzertta").getPeso());
	}
	
	@Test
	public void test_nessunEffettoMagico() {
		this.stanzaMagica.addAttrezzo(attrezzoDiTest);
		assertEquals(1, this.stanzaMagica.getContatoreAttrezziPosati());
		assertEquals(1, this.stanzaMagica.getAttrezzo("attrezzoDiTest").getPeso());
	}

}
