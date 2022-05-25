package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando{
	
	private static final String NOME = "saluta";

	public ComandoSaluta(){
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		if(partita.getStanzaCorrente().getPersonaggio() == null) {
			super.getIo().mostraMessaggio("non c'è nessuno");
		}
		else {
			super.getIo().mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		}
		
	}

}
