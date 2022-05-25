package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {
	
	private static final String ATTREZZO = "attrezzoDiTest";
	private IO io;
	
	private AbstractComando comandoDaEseguire;
	private Partita partita;
	private String istruzione;
	private Attrezzo attrezzoDaPrendere;
	private Labirinto labirinto;
	
	@Before
	public void setUp() throws Exception {
		this.io = new IOConsole();
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("stanzaIniziale")
				.getLabirinto();
		this.partita = new Partita(labirinto);
		this.attrezzoDaPrendere = new Attrezzo("attrezzoDaPrendere", 1);
		this.partita.getStanzaCorrente().addAttrezzo(attrezzoDaPrendere);
	}

	@Test
	public void testPrendi() {
		inputDellUtente("prendi attrezzoDaPrendere");
		comandoDaEseguire.esegui(this.partita);
		assertEquals("attrezzoDaPrendere", this.partita.getGiocatore().getBorsa().getAttrezzo(attrezzoDaPrendere.getNome()).getNome());
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("attrezzoDaPosare"));
	}
	
	@Test
	public void testPrendi_oggettoCheNonEsiste() {
		inputDellUtente("prendi attrezzoNonEsistente");
		comandoDaEseguire.esegui(this.partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("attrezzoNonEsistente"));
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("attrezzoNonEsistente"));
	}
	
	@Test
	public void testPrendi_borsaPiena() {
		for(int i=0; i<Borsa.DEFAULT_PESO_MAX_BORSA;i++) {
			Attrezzo attrezzoSemplice = new Attrezzo(ATTREZZO+i, 1);
			this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoSemplice);
		}
		inputDellUtente("prendi attrezzoDaPrendere");
		comandoDaEseguire.esegui(this.partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("attrezzoDaPrendere"));
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("attrezzoDaPrendere"));
	}
	
	
	/*
	 * metodo che simula l'input dell'utente
	 */
	private void inputDellUtente(String ordine) {
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		istruzione = ordine;
		comandoDaEseguire = factory.costruisciComando(istruzione, io);
	}

}
