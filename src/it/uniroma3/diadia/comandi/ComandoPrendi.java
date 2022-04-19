package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String attrezzo;

	public ComandoPrendi(String attrezzo) {
		this.attrezzo = attrezzo;
	}

	/**
	 * Prendi un oggetto se la tua borsa non è piena
	 */
	@Override
	public void esegui(Partita partita) {
		if(!partita.getStanzaCorrente().hasAttrezzo(this.attrezzo)) {
			System.out.println("Attrezzo "+this.attrezzo+" non presente!");
			//io.mostraMessaggio("Attrezzo "+this.attrezzo+" non presente!");
			return;
		}
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(this.attrezzo);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		partita.getStanzaCorrente().removeAttrezzo(attrezzo);
		System.out.println("Attrezzo "+this.attrezzo+" preso!");
		//io.mostraMessaggio("Attrezzo "+this.attrezzo+" preso!");
	}

	@Override
	public void setParametro(String parametro) {
		this.attrezzo = parametro;
	}

}
