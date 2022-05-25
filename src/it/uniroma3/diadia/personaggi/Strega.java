package it.uniroma3.diadia.personaggi;

import java.util.TreeSet;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio{
	
	private static final String MESSAGGIO = "Ti ho spostato";

	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		TreeSet<Stanza> stanzeAdiacenti = new TreeSet<Stanza>();
		for(Direzione direzione : partita.getStanzaCorrente().getDirezioni()) {
			stanzeAdiacenti.add(partita.getStanzaCorrente().getStanzaAdiacente(direzione));
		}
		
		if(super.haSalutato()) {
			partita.setStanzaCorrente(stanzeAdiacenti.first());
		}
		else {
			partita.setStanzaCorrente(stanzeAdiacenti.last());
		}
		return MESSAGGIO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

}
