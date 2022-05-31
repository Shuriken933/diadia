package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LabirintoBuilderTest {
	
	Labirinto labirinto;
	private static final String STANZA_INIZIALE = "Stanza iniziale";
	private static final String STANZA_VINCENTE = "Stanza vincente";
	private static final String DIREZIONE = "ovest";
	private static final String NOME_ATTREZZO = "attrezzo";

	@Before
	public void setUp() throws Exception {
		this.labirinto = Labirinto.newBuilder()
				.addStanzaIniziale(STANZA_INIZIALE)
				.addStanzaVincente(STANZA_VINCENTE)
				.addAttrezzo(NOME_ATTREZZO, 1)
				.addAdiacenza(STANZA_INIZIALE,STANZA_VINCENTE,DIREZIONE)
				.getLabirinto();
	}

	@Test
	public void testAddAdiacenza() {
		assertEquals(STANZA_VINCENTE, this.labirinto.getStanzaIniziale().getStanzaAdiacente(Direzione.OVEST).getNome());
	}
	
	@Test
	public void testAddAttrezzo_sullUltimaStanza() {
		assertEquals(NOME_ATTREZZO, this.labirinto.getStanzaVincente().getAttrezzo(NOME_ATTREZZO).getNome());
	}

}
