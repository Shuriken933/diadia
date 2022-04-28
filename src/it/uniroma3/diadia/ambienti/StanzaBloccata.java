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
						this.getDescrizione();
					}

		return stanza;
	}
	
//	@Override
//	public Stanza getStanzaAdiacente(String direzione) {
//		if(direzione.equals(this.direzioneBloccata) && !super.hasAttrezzo(attrezzoSbloccante))
//			return this;
//		return super.getStanzaAdiacente(direzione);
//	}

	@Override
	public String getDescrizione() {
		return this.toString() + "\nLa direzione bloccata è " + this.direzioneBloccata +
				"\nL'oggetto sbloccante è " + this.attrezzoSbloccante;
	}

}
