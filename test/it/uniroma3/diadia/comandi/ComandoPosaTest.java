package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPosaTest {
	
	private static final String ATTREZZO = "attrezzoDiTest";
	
	Comando comandoDaEseguire;
	ComandoPosa comandoPosa;
	Partita partita;
	String istruzione;
	Attrezzo attrezzoDaPosare;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.attrezzoDaPosare = new Attrezzo("attrezzoDaPosare", 5);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPosare);
	}
	
	@Test
	public void testPosa() {
		inputDellUtente("posa attrezzoDaPosare");
		comandoDaEseguire.esegui(this.partita);
		assertEquals(attrezzoDaPosare, this.partita.getStanzaCorrente().getAttrezzo("attrezzoDaPosare"));
	}
	
	@Test
	public void testPosa_oggettoNonPossedutoDaGiocatore() {
		inputDellUtente("posa attrezzoNonPosseduto");
		comandoDaEseguire.esegui(this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("attrezzoNonPosseduto"));
	}
	
	@Test
	public void testPosa_stanzaPiena() {
		
		for(int i=0; i<Stanza.NUMERO_MASSIMO_ATTREZZI;i++) {
			Attrezzo attrezzoSemplice = new Attrezzo(ATTREZZO+i, 1);
			this.partita.getStanzaCorrente().addAttrezzo(attrezzoSemplice);
		}
		inputDellUtente("posa attrezzoDaPosare");
		comandoDaEseguire.esegui(this.partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("attrezzoDaPosare"));
	}
	
	
	/*
	 * metodo che simula l'input dell'utente
	 */
	private void inputDellUtente(String ordine) {
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		istruzione = ordine;
		comandoDaEseguire = factory.costruisciComando(istruzione);
	}


}
