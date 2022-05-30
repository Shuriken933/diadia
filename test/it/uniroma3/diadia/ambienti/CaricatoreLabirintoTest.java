package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

public class CaricatoreLabirintoTest {



	private static final StringReader STRING_MONOLOCALE = new StringReader(
			"Stanze: biblioteca\n" +
			"Bloccate:\n" +
			"Buie:\n" +
			"Magiche:\n" +
			"Inizio: biblioteca\n" +
			"Vincente: biblioteca\n" +
			"Attrezzi: martello 10 biblioteca\n" +
			"Uscite: \n" +
			"UltimoLivello: false");

	private static final StringReader STRING_BILOCALE = new StringReader(
			"Stanze: biblioteca, N10\n" +
			"Bloccate:\n" +
			"Buie:\n" +
			"Magiche:\n" +
			"Inizio: N10\n" +
			"Vincente: biblioteca\n" +
			"Attrezzi: martello 10 biblioteca, pinza 2 N10\n" +
			"Uscite: biblioteca sud N10\n" +
			"UltimoLivello: false");

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testCarica_Monolocale() throws Exception {
		CaricatoreLabirinto monolocale = new CaricatoreLabirinto(STRING_MONOLOCALE);
		monolocale.carica();
		assertEquals("biblioteca", monolocale.getStanzaIniziale().getNome());
	}

	@Test
	public void testCarica_Bilocale() throws Exception {

		CaricatoreLabirinto bilocale = new CaricatoreLabirinto(STRING_BILOCALE);
		bilocale.carica();
		assertEquals("N10", bilocale.getStanzaIniziale().getNome());
		assertEquals("biblioteca", bilocale.getStanzaIniziale().getStanzaAdiacente(Direzione.NORD).getNome());
	}

}
