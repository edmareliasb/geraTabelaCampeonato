package br.com.geratabela;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.geratabela.model.Campeonato;
import br.com.geratabela.model.Partida;
import br.com.geratabela.model.Rodada;
import br.com.geratabela.model.Time;

public class GeraTabelaCampeonato {

	public static void main(String[] args) {
		
		GeraTabelaCampeonato geraTabela = new GeraTabelaCampeonato();
		
		Campeonato campeonato = new Campeonato();
		Integer qtdeTurnos = 1;
		
		List<Time> listaTimes = geraTabela.carregaListaTimes();
		
		campeonato.setListaRodadas(geraTabela.manipularListaTimes(listaTimes, qtdeTurnos));
		
		for (Rodada rodada : campeonato.getListaRodadas()) {
			System.out.println("==================================");
			for (Partida partida : rodada.getListaPartidas()) {
				System.out.println(partida.getTimeCasa().getNome() + " X " + partida.getTimeVisitante().getNome());
			}
		}
		
	}
	
	public Campeonato gerarTabela() {
		Campeonato campeonato = new Campeonato();
		Integer qtdeTurnos = 1;
		
		List<Time> listaTimes = carregaListaTimes();
		
		campeonato.setListaRodadas(manipularListaTimes(listaTimes, qtdeTurnos));
		
		return campeonato;
	}
	
	private List<Rodada> manipularListaTimes(List<Time> listaTimes, Integer qtdeTurnos) {
		Rodada rodada;
		List<Rodada> listaRodada = new ArrayList<Rodada>();
		
		int countInteracaoForExterno = 0;
		Time timeAux1 = new Time();
		Time timeAux2 = new Time();
		
		// Se a quantidade de times for ímpar instancia um objeto time e adiciona a lista
		if (listaTimes.size() % 2 != 0) {
			listaTimes.add(new Time());
		}
		
		Time cabecaChave = listaTimes.get(0);
		listaTimes.remove(0);
		
		for (int i = 1; i <= qtdeTurnos; i ++) {
		
			for (Time timesCampeonato: listaTimes) {
				int countInteracaoForinterno = 0;
				
				for (Time time: listaTimes) {
					if (countInteracaoForinterno % 2 == 0) {
						timeAux1 = time;
					} else {
						timeAux2 = time;
					}
					
					if ((countInteracaoForinterno > 0) 
						 && (countInteracaoForinterno % 2 != 0)) {
						listaTimes.set(countInteracaoForinterno, timeAux1);	
					} else if (countInteracaoForinterno > 0) {
						listaTimes.set(countInteracaoForinterno, timeAux2);
					}
				
					if (countInteracaoForinterno == (listaTimes.size() - 1)) {
						listaTimes.set(0, timeAux1);						
					}
					
					countInteracaoForinterno ++;
				}
				
				countInteracaoForExterno ++;
				
				rodada = new Rodada();
				rodada.setListaPartidas(montarPartidasRodadaAtual(cabecaChave, listaTimes));
				listaRodada.add(rodada);
			}
		}
		return listaRodada;
	}
	
	private List<Partida> montarPartidasRodadaAtual(Time cabecaChave, List<Time> listaTimes) {
		Partida partida;
		Integer metadeListaTimes = (Double.valueOf(listaTimes.size() / 2)).intValue(); 
		List<Time> timesMandantes = new ArrayList<Time>();
		List<Time> timesVisitantes = new ArrayList<Time>();
		List<Partida> listaPartidas = new ArrayList<Partida>();
		
		timesMandantes.add(cabecaChave);
		
		// Monta lista de times mandantes e visitantes da rodada atual
		for (int i = 0; i < listaTimes.size(); i++) {
			if (i < metadeListaTimes) {
				// Mando do campo
				if (i % 2 == 0) {
					timesVisitantes.add(listaTimes.get(i));
				} else {
					timesMandantes.add(listaTimes.get(i));
				}
			} else {
				if (i % 2 == 0) {
					timesVisitantes.add(listaTimes.get(i));
				} else {
					timesMandantes.add(listaTimes.get(i));
				}
			}
		}
		
		Collections.reverse(timesVisitantes);
		
		// monta partidas da rodada atual
		for (int i = 0; i < timesMandantes.size(); i++) {
			if (timesVisitantes.size() > i 
					&& timesMandantes.get(i).getNome() != null
					&& timesVisitantes.get(i).getNome() != null) {
				partida = new Partida();
				partida.setTimeCasa(timesMandantes.get(i));			
				partida.setTimeVisitante(timesVisitantes.get(i));
				
				listaPartidas.add(partida);
			}
		}
		
		return listaPartidas;
	}
	
	/**
	 * Método que carrega uma lista de times
	 * para montagem da tabela
	 */
	private List<Time> carregaListaTimes() {
		List<Time> listaTimes = new ArrayList<Time>();
		
		Time time = new Time();
		
		time.setNome("Boa Vista");
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
		
		return listaTimes;
	}

}
