package br.com.geratabela.util;

import java.util.ArrayList;
import java.util.List;

import br.com.geratabela.model.Time;

public class TimesUtil {

	/**
	 * Método que carrega uma lista de times para montagem da tabela
	 */
	public static List<Time> carregaListaTimes() {
		List<Time> listaTimes = new ArrayList<Time>();
		
		Time time = new Time();
		
		time.setNome("A");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("B");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("C");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("D");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("E");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("F");
		listaTimes.add(time);
		
	    /*time = new Time();
		time.setNome("G");
		listaTimes.add(time);*/
		
		/*time.setNome("Boa Vista");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Ponto Preto");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Ponte Azul");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Deuses");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Beija-Flor");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Santo Antonio");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Bandeiras");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Miranta");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Santana");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Lagoa Nova");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Rio Branco");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("São Pedro");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("American Cali");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Pioneiros");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Sport Siena");
		listaTimes.add(time);
		
		time = new Time();
		time.setNome("Central Vila");
		listaTimes.add(time);
		*/
		return listaTimes;
	}
	
}
