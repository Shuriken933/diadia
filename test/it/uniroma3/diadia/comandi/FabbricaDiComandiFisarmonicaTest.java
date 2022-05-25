package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonicaTest {

	private IO io;
	private FabbricaDiComandiFisarmonica fabbricaDiComandi;
	private AbstractComando comando;
	
	@Before
	public void setUp() throws Exception {
		this.fabbricaDiComandi = new FabbricaDiComandiFisarmonica();
	}

	
	
	@Test
	public void test_ComandoAiuto() {
		assertEquals("aiuto", this.fabbricaDiComandi.costruisciComando("aiuto", io).getNome());
	}
	
	@Test
	public void test_ComandoFine() {
		assertEquals("fine", this.fabbricaDiComandi.costruisciComando("fine", io).getNome());
	}
	
	@Test
	public void test_ComandoGuarda() {
		assertEquals("guarda", this.fabbricaDiComandi.costruisciComando("guarda", io).getNome());
	}
	
	@Test
	public void test_ComandoNonValido() {
		assertEquals("non_valido", this.fabbricaDiComandi.costruisciComando("un comando a caso", io).getNome());
	}
	
	/*
	 * comando VAI
	 */
	@Test
	public void test_ComandoVai() {
		assertEquals("vai", this.fabbricaDiComandi.costruisciComando("vai", io).getNome());
	}
	@Test
	public void test_ComandoVai_direzioneEsistente() {
		comando = this.fabbricaDiComandi.costruisciComando("vai sud", io);
		assertEquals("vai", comando.getNome());
		assertEquals("sud", comando.getParametro());
	}
	
	/*
	 * comando PRENDI
	 */
	@Test
	public void test_ComandoPrendi() {
		assertEquals("prendi", this.fabbricaDiComandi.costruisciComando("prendi", io).getNome());
	}
	@Test
	public void test_ComandoPrendi_conParametro() {
		comando = this.fabbricaDiComandi.costruisciComando("prendi attrezzo", io);
		assertEquals("prendi", comando.getNome());
		assertEquals("attrezzo", comando.getParametro());
	}
	
	/*
	 * comando POSA
	 */
	@Test
	public void test_ComandoPosa() {
		assertEquals("posa", this.fabbricaDiComandi.costruisciComando("posa", io).getNome());
	}
	@Test
	public void test_ComandoPosa_conParametro() {
		comando = this.fabbricaDiComandi.costruisciComando("posa attrezzo", io);
		assertEquals("posa", comando.getNome());
		assertEquals("attrezzo", comando.getParametro());
	}
	


}
