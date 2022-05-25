package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

	static final public String MESSAGGIO_FINE = "Grazie di aver giocato!";
	public static final String NOME = "fine";	

	public ComandoFine() {
		super.setNome(NOME);
	}

	//	@Override
	//	public void esegui(Partita partita) {
	//			super.getIo().mostraMessaggio(MESSAGGIO_FINE);  // si desidera smettere
	//			partita.isFinita();
	//	}

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		super.getIo().mostraMessaggio(MESSAGGIO_FINE);  // si desidera smettere
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
	//		return NOME;
	//		
	//	}
	//
	//	@Override
	//	public String getParametro() {
	//		return "";
	//		
	//	}

}
