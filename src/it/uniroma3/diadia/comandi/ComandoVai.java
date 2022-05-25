package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {

	private static final String NOME = "vai";
	private String direzione;
	
	public ComandoVai() {
		super.setNome(NOME);
	}	

	@Override
	public void esegui(Partita partita) {

		if(direzione==null)
			super.getIo().mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
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
	
//	@Override
//	public void setParametro(String parametro) {
//		this.direzione = parametro;
//
//	}
//
//	@Override
//	public void setIO(IO console) {
//		this.io = console;
//	}
//	
//	@Override
//	public String getNome() {
//		return "vai";
//	}
//
//	@Override
//	public String getParametro() {
//		return this.direzione;
//	}
}