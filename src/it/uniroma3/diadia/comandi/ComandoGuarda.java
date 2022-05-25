package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	
	private static final String NOME = "guarda";

	public ComandoGuarda() {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		super.getIo().mostraMessaggio("Ti trovi in: " + partita.getStanzaCorrente().toString());
		super.getIo().mostraMessaggio("Ti sono rimasti " + partita.getGiocatore().getCfu() + "cfu");
		super.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}

//	@Override
//	public void setParametro(String parametro) {
//		// nessun parametro
//	}
//
//	@Override
//	public void setIO(IO console) {
//		this.io = console;
//	}
//	
//	@Override
//	public String getNome() {
//		return "guarda";
//		
//	}
//
//	@Override
//	public String getParametro() {
//		return "";
//		
//	}

}
