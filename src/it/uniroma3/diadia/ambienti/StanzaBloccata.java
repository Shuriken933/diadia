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
