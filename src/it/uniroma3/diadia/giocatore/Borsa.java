package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe modella una borsa
 * Il giocatore possiede una borsa nella quale può
 * inserire degli oggetti con un limite di peso massimo
 *
 * @author  studenti
 * @see Giocatore
 * @version 0.1
 */

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	/**
	 * Costruttore base
	 */
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	/**
	 * Costruttore con parametro
	 * @param pesoMax indica il peso massimo che la borsa può sostenere
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}

	/**
	 * @param attrezzo
	 * @return true se viene aggiunto un attrezzo
	 * @return false se non viene aggiunto un attrezzo
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
			return false;
		}
		if (this.numeroAttrezzi==10) {
			return false;
		}
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	/**
	 * 
	 * @return pesoMax peso massimo che può sostenere la borsa
	 */
	public int getPesoMax() {
		return pesoMax;
	}

	/**
	 * @param nomeAttrezzo nome dell'attrezzo da cercare nella borsa
	 * @return attrezzo se l'attrezzo è contenuto nella borsa
	 * @return null se l'attrezzo non è presente nella borsa
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++) {
			if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = attrezzi[i];
			}
		}
		return a;
	}

	/**
	 * @return peso peso totale sostenuto dalla borsa
	 */
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++) {
			peso += this.attrezzi[i].getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	/**
	 * 
	 * @param nomeAttrezzo nome dell'attrezzo da rimuovere
	 * @return attrezzo se l'attrezzo è presente nella borsa
	 * @return null se l'attrezzo non è presente nella borsa
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		int i = 0;
		while(i < this.attrezzi.length && a==null) {
			if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = this.attrezzi[i];
				this.attrezzi[i] = null;
				numeroAttrezzi--;
			}
			i++;
		}
		return a;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++) {
				s.append(attrezzi[i].toString()+" ");
			}
		}
		else {
			s.append("Borsa vuota");
		}
		return s.toString();
	}
}
