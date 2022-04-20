package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private static final String ATTREZZO_SBLOCCANTE = "chiave";
	private static final String DIREZIONE_BLOCCATA = "nord";

	private String attrezzoSbloccante;
	private String direzioneBloccata;

	public StanzaBloccata(String nome) {
		this(nome, ATTREZZO_SBLOCCANTE, DIREZIONE_BLOCCATA);
	}

	public StanzaBloccata(String nome, String nomeAttrezzo, String direzioneBlocco) {
		super(nome);
		this.attrezzoSbloccante = nomeAttrezzo;
		this.direzioneBloccata = direzioneBlocco;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {

		StringBuilder s = new StringBuilder();
		Stanza stanza = null;
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			if (this.direzioni[i].equals(direzione))
				if(direzione != this.direzioneBloccata)
					stanza = super.stanzeAdiacenti[i];
				else
					if(super.hasAttrezzo(attrezzoSbloccante)) {
						stanza = super.stanzeAdiacenti[i];
						s.append("Direzione sbloccata!");
					}		
					else {
						s.append("Direzione bloccata!");
						super.getDescrizione();
					}

		return stanza;
	}


	//	public Stanza getStanzaAdiacente(String direzione) {
	//        
	//		StringBuilder s = new StringBuilder();
	//		if(direzione != this.direzioneBloccata)
	//			return super.getStanzaAdiacente(direzione);
	//		else if(!super.hasAttrezzo(attrezzoSbloccante))
	//			s.append("Direzione bloccata!");
	//		else s.append("Direzione sbloccata!");
	//		return super.getStanzaAdiacente(direzioneBloccata);			
	//			
	//	}

	@Override
	public String getDescrizione() {
		
		StringBuilder s = new StringBuilder();
		
		return this.toString();
		
	}

}
