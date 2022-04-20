package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {

	private String nomeAttrezzo;
	private IO io;

	@Override
	public void esegui(Partita partita) {

		if(!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			this.io.mostraMessaggio("Attrezzo "+nomeAttrezzo+" non presente nella borsa!");
			return;
		}
		partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo));
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		io.mostraMessaggio("Attrezzo "+nomeAttrezzo+" posato!");
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

	@Override
	public void setIO(IO console) {
		this.io = console;
	}

}
