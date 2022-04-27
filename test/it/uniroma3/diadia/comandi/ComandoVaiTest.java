package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoVaiTest {
	
	private static final String NOME_STANZA_PARTENZA = "partenza";
	private static final String NORD = "nord";
	private Partita partita; 
	private Comando comandoVai;
	private Stanza partenza;
	
	@Before
	public void setUp() {
		this.comandoVai = new ComandoVai();
		this.comandoVai.setIO(new IOConsole());
		this.partita = new Partita();
		this.partenza = new Stanza(NOME_STANZA_PARTENZA);
		this.partita.setStanzaCorrente(this.partenza);
	}

	@Test
	public void testVaiStanzaNonPresente() {
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(this.partita);
		assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVaiStanzaPresente() {
		Stanza destinazione = new Stanza("destinazione");
		this.partenza.impostaStanzaAdiacente(NORD, destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(this.partita);
		assertEquals("destinazione", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVaiStanzaPresenteInDirezioneSbagliata() {
		Stanza destinazione = new Stanza("destinazione");
		this.partenza.impostaStanzaAdiacente("sud", destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(this.partita);
		assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testPartitaConComandoVai() {
		String[] righeDaLeggere = {"vai sud", "fine"};
		IOSimulator io = Fixture.creSimulazionePartitaEGioca(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Aula N10", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertTrue(interaRiga.contains(expected));
	}

}
