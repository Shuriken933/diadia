package it.uniroma3.diadia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IOSimulator implements IO {
	
	private List<String> righeDaLeggere;
	private int indiceRigheDaLeggere;
	private Map<Integer, List<String>> indice2messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;
	
	public IOSimulator(List<String> righeDaLeggere) {
		this.righeDaLeggere = righeDaLeggere;
		this.indiceRigheDaLeggere = 0;
		this.indice2messaggiProdotti = new HashMap<Integer, List<String>>();
		this.indiceMessaggiProdotti = 0;
		this.indiceMessaggiMostrati = 0;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		if(!this.indice2messaggiProdotti.containsKey(this.indiceRigheDaLeggere))
			this.indice2messaggiProdotti.put(this.indiceRigheDaLeggere, new LinkedList<String>());
		List<String> l = this.indice2messaggiProdotti.get(this.indiceRigheDaLeggere);
		l.add(messaggio);
	}

	@Override
	public String leggiRiga() {
		String rigaLetta = this.righeDaLeggere.get(this.indiceRigheDaLeggere);
		this.indiceRigheDaLeggere++;
		return rigaLetta;
	}
	
	public String nextMessaggio() {
		List<String> messaggiDaMostrare = this.indice2messaggiProdotti.get(this.indiceMessaggiMostrati);
		if(this.indiceMessaggiMostrati < messaggiDaMostrare.size()) {
			String messaggio = messaggiDaMostrare.get(this.indiceMessaggiMostrati);
			this.indiceMessaggiMostrati++;
			return messaggio;
		}
		this.indiceMessaggiMostrati = 0;
		this.indiceMessaggiMostrati++;
		return this.nextMessaggio();
	}
	
	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}

}
