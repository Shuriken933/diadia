package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {

	private IO io;
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {

		if(!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			this.io.mostraMessaggio("Attrezzo "+nomeAttrezzo+" non presente!");
			return;
		}
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		partita.getStanzaCorrente().removeAttrezzo(attrezzo);
		this.io.mostraMessaggio("Attrezzo "+nomeAttrezzo+" preso!");
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
