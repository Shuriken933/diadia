package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

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

public class Borsa{
	
	private List <Attrezzo> attrezzi;

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	//private Attrezzo[] attrezzi;
	//private int numeroAttrezzi;
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
		//this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.attrezzi = new ArrayList<Attrezzo>();
		//this.numeroAttrezzi = 0;
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
		if (this.attrezzi.size()==10) {
			return false;
		}
		
		//this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.attrezzi.add(attrezzo);
		//this.numeroAttrezzi++;
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
		/*Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++) {
			if (this.attrezzi[i] != null && this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
				a = attrezzi[i];
			}
		}*/
		
		for(Attrezzo a : this.attrezzi) {
			if(a.getNome().equals(nomeAttrezzo)) {
				return a;
			}
		}
		return null;
	}

	/**
	 * @return peso peso totale sostenuto dalla borsa
	 */
	public int getPeso() {
		int peso = 0;
		for (Attrezzo a : this.attrezzi) {
			peso += a.getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
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
		//int i = 0;
		Iterator<Attrezzo> iter = this.attrezzi.iterator();
		while(iter.hasNext()) {
			a=iter.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				iter.remove();
				return a;
			}
		}
		return null;
	}
	
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		// List<Attrezzo> attrezziOrdinatiPerPeso = new ArrayList<Attrezzo>();
		ComparatorePerPeso comparator = new ComparatorePerPeso();
		Collections.sort(this.attrezzi, comparator);
		return this.attrezzi;
	}
	
	/*public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		
	}*/
	
	

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			
			for(Attrezzo attrezzo : this.attrezzi) {
				s.append(attrezzo.toString()+ " ");
			}
			
			/*for (int i= 0; i<this.numeroAttrezzi; i++) {
				s.append(attrezzi[i].toString()+" ");
			}*/
		}
		else {
			s.append("Borsa vuota");
		}
		return s.toString();
	}


	
}
