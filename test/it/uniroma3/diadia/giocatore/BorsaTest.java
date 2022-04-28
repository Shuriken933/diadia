package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	private Borsa borsa;
	private static final String ATTREZZO = "AttrezzoSemplice";

	@Before
	public void setUp() throws Exception {
		this.borsa = new Borsa();
	}

	@Test
	public void testAddAttrezzo_singolo() {
		Attrezzo attrezzo = creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertEquals(attrezzo, this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testAddAttrezzo_troppoPesante() {
		Attrezzo attrezzoPesantissimo = new Attrezzo("attrezzoPesantissimo", Borsa.DEFAULT_PESO_MAX_BORSA+1);
		assertFalse(this.borsa.addAttrezzo(attrezzoPesantissimo));
	}
	
	@Test
	public void testGetAttrezzo_borsaVuota() {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testGetAttrezzo_inesistente() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertNull(this.borsa.getAttrezzo("inesistente"));
	}
	
	@Test
	public void testGetPeso_massimo() {
		assertEquals(Borsa.DEFAULT_PESO_MAX_BORSA, this.borsa.getPesoMax());
	}
	
	@Test
	public void testGetPeso_iniziale() {
		assertEquals(0, this.borsa.getPeso());
	}
	
	@Test
	public void testGetPeso_dopoAggiuntaAttrezzo() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertEquals(1, this.borsa.getPeso());
	}
	
	@Test
	public void testIsEmpty_quandoBorsaVuota() {
		assertTrue(this.borsa.isEmpty());
	}
	
	@Test
	public void testIsEmpty_quandoBorsaNonVuota() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertFalse(this.borsa.isEmpty());
	}
	
	@Test
	public void testHasAttrezzo_esistente() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertTrue(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testRemoveAttrezzo_borsaConAttrezzo() {
		creaAttrezzoEAggiungiBorsa(this.borsa, ATTREZZO, 1);
		this.borsa.removeAttrezzo(ATTREZZO);
		assertEquals(0, this.borsa.getPeso());
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testComparatorePeso() {
		creaAttrezzoEAggiungiBorsa(this.borsa, "ascia", 4);
		creaAttrezzoEAggiungiBorsa(this.borsa, "osso", 1);
		creaAttrezzoEAggiungiBorsa(this.borsa, "chiave", 3);
		
		List<Attrezzo> attrezziOrdinatiPerPeso = new ArrayList<Attrezzo>();
		attrezziOrdinatiPerPeso = this.borsa.getContenutoOrdinatoPerPeso();
		
		assertEquals("osso", attrezziOrdinatiPerPeso.get(0).getNome());
		assertEquals("chiave", attrezziOrdinatiPerPeso.get(1).getNome());
		assertEquals("ascia", attrezziOrdinatiPerPeso.get(2).getNome());
	}
	
	@Test
	public void testComparatoreNome_conPesiUguali() {
		creaAttrezzoEAggiungiBorsa(this.borsa, "chiave", 2);
		creaAttrezzoEAggiungiBorsa(this.borsa, "ascia", 2);
		creaAttrezzoEAggiungiBorsa(this.borsa, "osso", 2);
		
		List<Attrezzo> attrezziOrdinatiPerPeso = new ArrayList<Attrezzo>();
		attrezziOrdinatiPerPeso = this.borsa.getContenutoOrdinatoPerPeso();
		
		assertEquals("ascia", attrezziOrdinatiPerPeso.get(0).getNome());
		assertEquals("chiave", attrezziOrdinatiPerPeso.get(1).getNome());
		assertEquals("osso", attrezziOrdinatiPerPeso.get(2).getNome());
		
	}
	
	
	
	private Attrezzo creaAttrezzoEAggiungiBorsa(Borsa borsa2, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		borsa.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
