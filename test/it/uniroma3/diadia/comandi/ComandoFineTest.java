package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.IOSimulatorConList;
import it.uniroma3.diadia.fixture.Fixture;

public class ComandoFineTest {

//	@Test
//	public void testPartitaConComandoFine() {
//		String[] righeDaLeggere = {"fine"};
//		IOSimulator io = Fixture.creSimulazionePartitaEGioca(righeDaLeggere);
//		assertTrue(io.hasNextMessaggio());
//		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
//		assertTrue(io.hasNextMessaggio());
//		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
//	}
	
	@Test
	public void testPartitaConComandoFineConList() {
		List<String> righeDaLeggere = new ArrayList<>();
		righeDaLeggere.add(ComandoFine.NOME);
		IOSimulatorConList io = Fixture.creSimulazionePartitaEGiocaConList(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}

}
