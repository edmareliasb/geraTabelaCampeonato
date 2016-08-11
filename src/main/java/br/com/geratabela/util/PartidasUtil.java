package br.com.geratabela.util;

import java.util.List;

import br.com.geratabela.model.Partida;
import br.com.geratabela.model.Time;

public class PartidasUtil {

	/**
	 * Criar as partidas de uma rodada quando a qtde de times do campeonato for Par
	 * @param cabecaChave
	 * @param numRodada
	 * @param listaPartidas
	 * @param listaTimesAux
	 * @param numPartida
	 * @return
	 */
	public static List<Partida> gerarPartidasQtdeTimesPar(Time cabecaChave, int numRodada, List<Partida> listaPartidas, List<Time> listaTimesAux, int numPartida) {

		Time ultimoTime;

		if (numPartida == 0) {
			Partida partida;
			ultimoTime = listaTimesAux.get(listaTimesAux.size() - 1);
			
			// Se a rodada for impar (considerando q a primeira rodada é 0 e a segunda é 1), inverte o mando
			if (numRodada % 2 != 0) {
				partida = criarPartida(ultimoTime, cabecaChave);
			} else {
				partida = criarPartida(cabecaChave, ultimoTime);
			}

			listaPartidas.add(partida);
			
		} else {
			ultimoTime = listaTimesAux.get(listaTimesAux.size() - 1);
			
			//Primeiro time da lista
			Time timeCasa = listaTimesAux.get(numPartida - 1);
			Partida partida;

			// Se for a partida impar da rodada (considerando q a primeira é 0 e a segunda é 1), inverte o mando
			if (numPartida % 2 != 0) {
				partida = criarPartida(ultimoTime, timeCasa);
			} else {
				partida = criarPartida(timeCasa, ultimoTime);
			}

			listaPartidas.add(partida);
		}		
		
		listaTimesAux.remove(ultimoTime);
		return listaPartidas;
	}

	/**
	 * Criar as partidas de uma rodada quando a qtde de times do campeonato for Impar
	 * @param cabecaChave
	 * @param numRodada
	 * @param listaPartidas
	 * @param listaTimesAux
	 * @param numPartida
	 * @return
	 */
	public static List<Partida> gerarPartidasQtdeTimesImpar(Time cabecaChave, int numRodada, List<Partida> listaPartidas, List<Time> listaTimesAux, int numPartida) {
				
		if (numPartida > 0) {
			//Ultimo time da lista
			Time ultimoTime = listaTimesAux.get(listaTimesAux.size() - 1);
			
			//Primeiro time da lista
			Time timeCasa = listaTimesAux.get(numPartida - 1);
			
			Partida partida;
			// Se for a partida par da rodada (considerando q a primeira é 0 e a segunda é 1), inverte o mando
			if (numPartida % 2 == 0) {
				partida = criarPartida(ultimoTime, timeCasa);
			} else {
				partida = criarPartida(timeCasa, ultimoTime);
			}
			
			listaPartidas.add(partida);
			listaTimesAux.remove(ultimoTime);
		}
		
		return listaPartidas;
	}
	
	private static Partida criarPartida(Time timeCasa, Time timeVisitante) {

		Partida partida = new Partida();
		partida.setTimeCasa(timeCasa);
		partida.setTimeVisitante(timeVisitante);

		return partida;
	}

}
