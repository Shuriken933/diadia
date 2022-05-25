package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	
	private static final String MESSAGGIO = "Ti ho morso, ora hai un CFU in meno!";

	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO;
		partita.setCfu(partita.getCfu() -1);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}
}
