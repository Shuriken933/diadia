package it.uniroma3.diadia.ambienti;


import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private static final String ATTREZZO = "attrezzoDiTest";
	private static final String STANZA = "StanzaTest";
	private static final String STANZA_ADIACENTE = "StanzaAdiacente";
	private static final String NORD = "nord";
	
	protected Stanza stanza;
	
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() {
		this.stanza = new Stanza(STANZA);
		this.attrezzo = new Attrezzo(ATTREZZO, 5);
	}

	@Test
	public void testImpostaStanzaAdiacente_SINGOLA() {
		//this.stanza1.impostaStanzaAdiacente(NORD, stanza2);
		Stanza adiacente = creaStanzaEImpostaAdiacente(this.stanza, STANZA, Direzione.NORD);
		assertEquals(adiacente, this.stanza.getStanzaAdiacente(Direzione.NORD));
	}
	
	@Test
	public void testCambiaStanzaAdiacente() {
		creaStanzaEImpostaAdiacente(this.stanza, STANZA, Direzione.NORD);
		Stanza nuova = creaStanzaEImpostaAdiacente(this.stanza, "Nuova Adiacente", Direzione.NORD);
		assertEquals(nuova, this.stanza.getStanzaAdiacente(Direzione.NORD));
	}
	
	@Test
	public void testGetStanzaAdiacente_NonEsistente() {
		assertNull(this.stanza.getStanzaAdiacente(Direzione.NORD));
	}
	
	@Test
	public void testGetStanzaAdiacente_Esistente() {
		Stanza adiacente = creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, Direzione.NORD);
		assertEquals(adiacente, this.stanza.getStanzaAdiacente(Direzione.NORD));
	}
	
	
	@Test
	public void testAddAttrezzo_oltreIlMassimo() {
		for(int i = 0; i < Stanza.NUMERO_MASSIMO_ATTREZZI; i++) {
			Attrezzo attrezzoSemplice = new Attrezzo(ATTREZZO+i, 1);
			assertTrue(this.stanza.addAttrezzo(attrezzoSemplice));
		}
		Attrezzo attrezzoDiTroppo = new Attrezzo(ATTREZZO+Stanza.NUMERO_MASSIMO_ATTREZZI, 1);
		assertFalse(this.stanza.addAttrezzo(attrezzoDiTroppo));
	}
	
	@Test
	public void  testGetStanzaAdiacente_direzioneNonValida() {
		creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, Direzione.NORD);
		assertNull(this.stanza.getStanzaAdiacente(Direzione.EST));
	}
	
	@Test
	public void testGetDirezioni_vuoto() {
		assertArrayEquals(new String[0], this.stanza.getDirezioni().toArray());
	}
	
	@Test
	public void testGetDirezioni_singleton() {
		creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, Direzione.NORD);
		Direzione[] direzioni = new Direzione[1];
		direzioni[0] = Direzione.NORD;
		assertArrayEquals(direzioni, this.stanza.getDirezioni().toArray());
	}
	
	@Test
	public void testAddAttrezzo_singolo() {
		Attrezzo attrezzoSemplice = new Attrezzo(ATTREZZO,1);
		this.stanza.addAttrezzo(attrezzoSemplice);
		assertEquals(attrezzoSemplice, this.stanza.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testAddAttrezzi_oltreIlMassimo() {
		for (int i = 0; i < Stanza.NUMERO_MASSIMO_ATTREZZI; i++) {
			Attrezzo attrezzoSemplice = new Attrezzo(ATTREZZO+i, 1);
			assertTrue(this.stanza.addAttrezzo(attrezzoSemplice));
		}
		Attrezzo attrezzoDiTroppo = new Attrezzo(ATTREZZO+Stanza.NUMERO_MASSIMO_ATTREZZI, 1);
		assertFalse(this.stanza.addAttrezzo(attrezzoDiTroppo));
	}
	
	@Test
	public void testHasAttrezzo_singolo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 1);
		this.stanza.addAttrezzo(attrezzo);
		assertTrue(this.stanza.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testHasAttrezzo_stanzaVuota() {
		assertFalse(this.stanza.hasAttrezzo(ATTREZZO));
	}
	


	/*metodo di appoggio*/
	
	private void assertNotContains(Set<String> set, Direzione direzioneNuova) {
		boolean contiene = false;
		for(String direzione: set) {
			if (direzione != null && direzione.equals(direzioneNuova.name())) {
				contiene = true;
			}
		}
		assertFalse(contiene);
	}
	
	private Stanza creaStanzaEImpostaAdiacente(Stanza stanzaDiPartenza, String nomeStanzaAdiacente, Direzione direzione) {
		Stanza stanzaAdiacente = new Stanza(nomeStanzaAdiacente);
		stanzaDiPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return stanzaAdiacente;
	}

}
