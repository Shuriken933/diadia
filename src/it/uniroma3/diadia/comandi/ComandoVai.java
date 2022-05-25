package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {

	private static final String NOME = "vai";
	//private String direzione;
	
	public ComandoVai() {
		super.setNome(NOME);
	}	

	@Override
	public void esegui(Partita partita) {

		if(super.getParametro()==null)
			super.getIo().mostraMessaggio("Dove vuoi andare ?");
		
		Stanza prossimaStanza = null;
		Direzione direzione;
		try {
			direzione = Direzione.valueOf(super.getParametro().toUpperCase());
		}catch (IllegalArgumentException e){
			super.getIo().mostraMessaggio("Direzione inesistente");
			return;
		}
		
		prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		
		if (prossimaStanza == null)
			super.getIo().mostraMessaggio("Direzione inesistente");
		else {
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu-1);
		}
		super.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	

	
	
}