package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	//private static final String ATTREZZO_SBLOCCANTE = "chiave";
	//private static final Direzione DIREZIONE_BLOCCATA = "nord";

	private String attrezzoSbloccante;
	private Direzione direzioneBloccata;

	/*public StanzaBloccata(String nome) {
		this(nome, ATTREZZO_SBLOCCANTE, DIREZIONE_BLOCCATA);
	}*/

	public StanzaBloccata(String nome, String nomeAttrezzo, Direzione direzioneBlocco) {
		super(nome);
		this.attrezzoSbloccante = nomeAttrezzo;
		this.direzioneBloccata = direzioneBlocco;
	}

	@Override
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(direzione.equals(this.direzioneBloccata) && !super.hasAttrezzo(attrezzoSbloccante))
			return this;
		return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {
		return this.toString() + "\nLa direzione bloccata è " + this.direzioneBloccata +
				"\nL'oggetto sbloccante è " + this.attrezzoSbloccante;
	}

}
