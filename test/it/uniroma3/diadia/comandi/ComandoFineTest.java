package it.uniroma3.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.IOSimulatorConList;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoFineTest {

	//Labirinto labirinto;

	@Test
	public void testPartitaConComandoFine() throws Exception {
		List<String> righeDaLeggere = new ArrayList<>();
		righeDaLeggere.add("fine");
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne","Biblioteca","ovest")
				.getLabirinto();
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(labirinto, righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}

	@Test
	public void testPartitaConComandoFineConList() {
		List<String> righeDaLeggere = new ArrayList<>();
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne","Biblioteca","ovest")
				.getLabirinto();
		righeDaLeggere.add(ComandoFine.NOME);
		IOSimulatorConList io = Fixture.creaSimulazionePartitaEGiocaConList(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}

}
