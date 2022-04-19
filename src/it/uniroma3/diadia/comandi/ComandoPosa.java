package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {
	private String attrezzo;
	
	public ComandoPosa(String attrezzo) {
		this.attrezzo = attrezzo;
	}

	/**
	 * Posa un oggetto se la stanza ha ancora spazio
	 */
	@Override
	public void esegui(Partita partita) {
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo)) {
			System.out.println("Attrezzo "+this.attrezzo+" non presente nella borsa!");
			//io.mostraMessaggio("Attrezzo "+nomeAttrezzo+" non presente nella borsa!");
			return;
		}
		partita.getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(this.attrezzo));
		partita.getGiocatore().getBorsa().removeAttrezzo(this.attrezzo);
		System.out.println("Attrezzo "+this.attrezzo+" posato!");
		//io.mostraMessaggio("Attrezzo "+nomeAttrezzo+" posato!");

	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;
	}

}
