package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPosa extends AbstractComando {

	private static final String NOME = "posa";
//	private String nomeAttrezzo;

	public ComandoPosa() {
		super.setNome(NOME);
	}	
	
	@Override
	public void esegui(Partita partita) {

		if(!partita.getGiocatore().getBorsa().hasAttrezzo(super.getParametro())) {
			super.getIo().mostraMessaggio("Attrezzo "+super.getParametro()+" non presente nella borsa!");
			return;
		}
		partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(super.getParametro()));
		partita.getGiocatore().getBorsa().removeAttrezzo(super.getParametro());
		super.getIo().mostraMessaggio("Attrezzo "+super.getParametro()+" posato!");
	}

//	@Override
//	public void setParametro(String parametro) {
//		this.nomeAttrezzo = parametro;
//	}
//
//	@Override
//	public void setIO(IO console) {
//		this.io = console;
//	}
//	
//	@Override
//	public String getNome() {
//		return "posa";
//	}
//
//	@Override
//	public String getParametro() {
//		return this.nomeAttrezzo;
//	}
	

}
