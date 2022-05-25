package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {

	private static final String NOME = "prendi";
	private String nomeAttrezzo;
	
	public ComandoPrendi() {
		super.setNome(NOME);
	}	

	@Override
	public void esegui(Partita partita) {

		if(!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			super.getIo().mostraMessaggio("Attrezzo "+nomeAttrezzo+" non presente!");
			return;
		}
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
			partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			super.getIo().mostraMessaggio("Attrezzo "+nomeAttrezzo+" preso!");
		}
		else {
			super.getIo().mostraMessaggio("Attrezzo "+nomeAttrezzo+" NON preso!");
		}		
	}

//	@Override
//	public void setParametro(String parametro) {
//		this.nomeAttrezzo = parametro;
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
//		return "prendi";
//	}
//
//	@Override
//	public String getParametro() {
//		return this.nomeAttrezzo;
//	}

}
