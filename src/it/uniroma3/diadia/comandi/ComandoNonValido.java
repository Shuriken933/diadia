package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {
	
	
	private static final String NOME = "non_valido";
	

	public ComandoNonValido() {
		super.setNome(NOME);
	}	

	@Override
	public void esegui(Partita partita) {
		super.getIo().mostraMessaggio("comando non valido!");
	}

//	@Override
//	public void setParametro(String parametro) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void setIO(IO console) {
//		this.io = console;
//	}
//	
//	@Override
//	public String getNome() {
//		return "comando non valido";
//		
//	}
//
//	@Override
//	public String getParametro() {
//		return "";
//		
//	}

}
