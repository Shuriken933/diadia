package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	
	private static final String MESSAGGIO = "Ti ho morso, ora hai un CFU in meno!";
	
	private String ciboPreferito;
	private Attrezzo regaloCane;

	public Cane(String nome, String presentazione, Attrezzo regalo, String ciboPreferito) {
		super(nome, presentazione);
		this.ciboPreferito = ciboPreferito;
		this.regaloCane = regalo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO;
		partita.setCfu(partita.getCfu() -1);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo regalo, Partita partita) {
		
		partita.getStanzaCorrente().addAttrezzo(regalo);
		if(regalo.getNome().equals(ciboPreferito)) {
			partita.getStanzaCorrente().addAttrezzo(this.regaloCane);
			return "Il cane non ti ha morso e ti ha lasciato un attrezzo";
		}
		else {
			partita.setCfu(partita.getCfu() -1);
			return "Il cane non accetta il regalo e ti morde";
		}
	}
}
