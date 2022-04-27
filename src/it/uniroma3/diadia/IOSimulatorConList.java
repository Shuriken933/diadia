package it.uniroma3.diadia;

import java.util.LinkedList;
import java.util.List;

public class IOSimulatorConList implements IO{

	private List<String> righeDaLeggere;
	private List<String> messaggiProdotti;


	public IOSimulatorConList(List<String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.messaggiProdotti = new LinkedList<String>();

	}

	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti.add(messaggio);
	}

	@Override
	public String leggiRiga() {
		if(!this.righeDaLeggere.isEmpty())
			return this.righeDaLeggere.remove(0);		//passaggio spiegato a 1 ora e 24 a lezione del 21
		else 
			return null;
	}

	public String nextMessaggio() {
		if(hasNextMessaggio())
			return this.messaggiProdotti.remove(0);		//passaggio spiegato a 1 ora e 24 a lezione del 21
		else 
			return null;
	}

	public boolean hasNextMessaggio() {
		return !this.messaggiProdotti.isEmpty();
	}

}
