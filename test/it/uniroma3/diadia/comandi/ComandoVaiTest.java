package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoVaiTest {
	
	private static final String NOME_STANZA_PARTENZA = "partenza";
	private static final String NORD = "nord";
	private Partita partita; 
	private AbstractComando comandoVai;
	private Stanza partenza;
	private Labirinto labirinto;
	
	@Before
	public void setUp() {
		this.comandoVai = new ComandoVai();
		this.comandoVai.setIO(new IOConsole());
		this.labirinto = new LabirintoBuilder()
				.addStanzaIniziale("stanzaIniziale")
				.getLabirinto();
		this.partita = new Partita(labirinto);
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
		this.partenza.impostaStanzaAdiacente(Direzione.NORD, destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(this.partita);
		assertEquals("destinazione", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVaiStanzaPresenteInDirezioneSbagliata() {
		Stanza destinazione = new Stanza("destinazione");
		this.partenza.impostaStanzaAdiacente(Direzione.SUD, destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(this.partita);
		assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testPartitaConComandoVai() throws Exception {
		List<String> righeDaLeggere = new ArrayList<>();
		righeDaLeggere.add("vai sud");
		righeDaLeggere.add("fine");
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne","Biblioteca","ovest")
				.getLabirinto();
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(labirinto, righeDaLeggere);
		
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertContains("Biblioteca", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertTrue(interaRiga.contains(expected));
	}

}
