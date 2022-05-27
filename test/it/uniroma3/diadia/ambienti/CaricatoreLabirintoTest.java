package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

public class CaricatoreLabirintoTest {
	
	private static final String LABIRINTO_MONOLOCALE
	= "Stanze:\n"
	+ "N10\n"
	+ "Estremi:\n"
	+ "N10\n"
	+ "Attrezzi:\n"
	+ "Osso 5 N10\n"
	+ "Uscite:\n";
	
	private static final String LABIRINTO_BILOCALE
	= "Stanze:\n"
	+ "N10\n"
	+ "Biblioteca:\n"
	+ "Estremi:\n"
	+ "N10\n"
	+ "Biblioteca\n"
	+ "Attrezzi:\n"
	+ "Osso 5 N10\n"
	+ "Uscite:\n"
	+ "N10 nord Biblioteca\n"
	+ "Biblioteca sud N10";

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void testCaricamento() throws FileNotFoundException, FormatoFileNonValidoException {
//		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(LABIRINTO_BILOCALE);
//		caricatore.carica();
//		Labirinto labiritno = caricatore.getLabirinto();
//		assertEquals("N10", labiritno.getStanzaIniziale().getNome());
//		assertEquals("Biblioteca", labiritno.getStanzaVincente().getNome());
//		assertEquals("Osso", labiritno.getStanzaIniziale().getAttrezzo("Osso").getNome());
//		assertEquals(5, labiritno.getStanzaIniziale().getAttrezzo("Osso").getPeso());
//	}
	
	@Test
	public void testCarica() throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(new StringReader(LABIRINTO_BILOCALE));
		caricatore.carica();
		Labirinto labiritno = caricatore.getLabirinto();
		assertEquals("N10", labiritno.getStanzaIniziale().getNome());
		assertEquals("Biblioteca", labiritno.getStanzaVincente().getNome());
		assertEquals("Osso", labiritno.getStanzaIniziale().getAttrezzo("Osso").getNome());
		assertEquals(5, labiritno.getStanzaIniziale().getAttrezzo("Osso").getPeso());
	}

}
