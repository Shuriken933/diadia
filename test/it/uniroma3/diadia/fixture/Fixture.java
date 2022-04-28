package it.uniroma3.diadia.fixture;

import java.util.List;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.IOSimulatorConList;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Fixture {
	
	public static IOSimulator creSimulazionePartitaEGioca(String... righeDaLeggere) {
		IOSimulator io = new IOSimulator(righeDaLeggere);
		new DiaDia(io).gioca();
		return io;		
	}
	
	public static Attrezzo creAttrezzoEAggiungiAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}

	public static IOSimulatorConList creSimulazionePartitaEGiocaConList(List<String> righeDaLeggere) {
		IOSimulatorConList io = new IOSimulatorConList(righeDaLeggere);
		new DiaDia(io).gioca();
		return io;
	}

}
