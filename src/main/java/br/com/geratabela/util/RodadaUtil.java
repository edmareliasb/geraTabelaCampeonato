package br.com.geratabela.util;

import java.util.ArrayList;
import java.util.List;

import br.com.geratabela.model.Partida;
import br.com.geratabela.model.Rodada;

public class RodadaUtil {
	
	/**
	 * Caso o campeonato tem mais de um turno inverte o mando de jogo das partidas
	 * @param listaRodada
	 * @return List<Rodada>
	 */
	public static List<Rodada> inverterMandoJogoPartidas(List<Rodada> listaRodadas) {
		
		List<Rodada> novasRodadas = new ArrayList<>();
		
		for (Rodada rodada : listaRodadas) {
			List<Partida> listaPartidas = new ArrayList<>();
			Rodada novaRodada = new Rodada(); 
			
			for (Partida partida : rodada.getListaPartidas()) {
				
				Partida novaPartida = new Partida();
				
				novaPartida.setTimeCasa(partida.getTimeVisitante());
				novaPartida.setTimeVisitante(partida.getTimeCasa());			
				
				listaPartidas.add(novaPartida);
			}
			
			novaRodada.setListaPartidas(listaPartidas);
			novasRodadas.add(novaRodada);
		}
		
		return novasRodadas;
	}
	
}
