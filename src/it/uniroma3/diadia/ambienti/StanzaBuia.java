package it.uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza {

	private String attrezzoParticolare;
	private static final String ATTREZZO_LUCE = "lanterna";
	
	public StanzaBuia(String nome) {
		this(nome, ATTREZZO_LUCE);
	}

	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.attrezzoParticolare = nomeAttrezzo;
	}

	
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(this.attrezzoParticolare))
			return super.getDescrizione();
		
		return "Qui c'è un buio pesto!";
	}

}
