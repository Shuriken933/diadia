package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe StanzaMagica - dopo N volte che in tale stanza 
 * viene posato (aggiunto)un qualsiasi attrezzo da parte 
 * del giocatore, la stanza inizierà a comportarsi «magicamente»
 * 
 * quando la stanza si comporta magicamente, ogni volta
 * che posiamo un attrezzo, la stanza "inverte" il nome
 * dell'attrezzo e ne raddoppia il peso.
 * 
 * @author studenti
 * @see Stanza
 * @version 0.2
*/

class StanzaMagica extends Stanza {

	final static private int SOGLIA_MAGICA_DEFAULT = 3;

	private int contatoreAttrezziPosati;
	private int sogliaMagica;


	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}


	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
        if(this.contatoreAttrezziPosati > this.sogliaMagica)
        	attrezzo = this.modificaAttrezzo(attrezzo);
        
        return super.addAttrezzo(attrezzo);
    }

	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoX2);
		
		return attrezzo;
	}
	
	public int getContatoreAttrezziPosati() {
		return contatoreAttrezziPosati;
	}
}