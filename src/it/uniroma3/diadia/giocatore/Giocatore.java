package it.uniroma3.diadia.giocatore;
/**
 * Questa classe modella il giocatore della partita
 *
 * @author  studenti
 * @see Partita
 * @version 0.1
 */
public class Giocatore {
	
	public static final int CFU_INIZIALI = 10;
	private int cfu;
	private Borsa borsa;
	
	/**
	 * costruttore base
	 */
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public void decrementaCfu() {
		this.cfu--;
	}
	
	public Borsa getBorsa() {
		return borsa;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

}
