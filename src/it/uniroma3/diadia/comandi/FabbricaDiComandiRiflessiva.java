package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	//private IO io;

	@SuppressWarnings("deprecation")
	public AbstractComando costruisciComando(String istruzione, IO io) {

		Scanner scannerDiParole = new Scanner(istruzione); // es. vai sud
		String nomeComando = null; // es. vai
		String parametro = null; // es. sud
		AbstractComando comando = null;

		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();//prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();//seconda parola: eventuale parametro

		try {
			String nomeClasse = "it.uniroma3.diadia.comandi.Comando";

			nomeClasse += Character.toUpperCase(nomeComando.charAt(0));
			nomeClasse += nomeComando.substring(1);

			comando = (AbstractComando)Class.forName(nomeClasse).newInstance();
			
		} catch (Exception e) {
			comando = new ComandoNonValido();
		}
		
		comando.setIO(io);
		comando.setParametro(parametro);
		return comando;
	}
}