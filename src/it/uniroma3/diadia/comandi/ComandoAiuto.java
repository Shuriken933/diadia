package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
		
	static final private String NOME = "aiuto";
	
	static final private String[] ELENCO_COMANDI = {"vai", "aiuto", "fine", "posa", "prendi", "guarda", "interagisci"};
	
	public ComandoAiuto(String[] elencoComandi) {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			super.getIo().mostraMessaggio(ELENCO_COMANDI[i]+" ");
	}

//	@Override
//	public void setParametro(String parametro) {
//		// nessun parametro
//
//	}
//
//	@Override
//	public void setIO(IO console) {
//		this.io = console;
//	}
//
//	@Override
//	public String getNome() {
//		return "aiuto";
//	}
//
//	@Override
//	public String getParametro() {
//		return "";
//		
//	}

}
