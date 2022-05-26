package it.uniroma3.diadia.personaggi;

import java.util.TreeSet;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.ComparatoreStanzePerNumeroAttrezzi;
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
		TreeSet<Stanza> stanzeAdiacentiPerNumeroAttrezzi = new TreeSet<Stanza>(new ComparatoreStanzePerNumeroAttrezzi());
		for(Direzione direzione : partita.getStanzaCorrente().getDirezioni()) {
			stanzeAdiacentiPerNumeroAttrezzi.add(partita.getStanzaCorrente().getStanzaAdiacente(direzione));
		}
		
		if(super.haSalutato()) {
			partita.setStanzaCorrente(stanzeAdiacentiPerNumeroAttrezzi.first());
		}
		else {
			partita.setStanzaCorrente(stanzeAdiacentiPerNumeroAttrezzi.last());
		}
		return MESSAGGIO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "AHAHAHAHAHAHAH";
	}

}
