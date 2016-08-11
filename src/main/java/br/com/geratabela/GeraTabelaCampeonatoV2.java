package br.com.geratabela;

import java.util.ArrayList;
import java.util.List;

import br.com.geratabela.model.Campeonato;
import br.com.geratabela.model.Partida;
import br.com.geratabela.model.Rodada;
import br.com.geratabela.model.Time;
import br.com.geratabela.util.PartidasUtil;
import br.com.geratabela.util.RodadaUtil;
import br.com.geratabela.util.TimesUtil;

public class GeraTabelaCampeonatoV2 {

	public static void main(String[] args) {
		GeraTabelaCampeonatoV2 geraTabela = new GeraTabelaCampeonatoV2();

		Campeonato campeonato = new Campeonato();

		List<Time> listaTimes = TimesUtil.carregaListaTimes();
		
		List<Rodada> rodadas = geraTabela.montarRodadas(listaTimes);	
		
		List<Rodada> segundoTurno = RodadaUtil.inverterMandoJogoPartidas(rodadas);
		
		campeonato.setListaRodadas(rodadas);

		System.out.println("1 TURNO");
		
		for (Rodada rodada : campeonato.getListaRodadas()) {
			System.out.println("==================================");
			for (Partida partida : rodada.getListaPartidas()) {
				System.out.println(partida.getTimeCasa().getNome() + " X " + partida.getTimeVisitante().getNome());
			}
		}
		
		System.out.println("2 TURNO");
		
		for (Rodada rodada : segundoTurno) {
			System.out.println("==================================");
			for (Partida partida : rodada.getListaPartidas()) {
				System.out.println(partida.getTimeCasa().getNome() + " X " + partida.getTimeVisitante().getNome());
			}
		}
	}

	public Campeonato gerarTabela() {
		Campeonato campeonato = new Campeonato();

		List<Time> listaTimes = TimesUtil.carregaListaTimes();
		
		List<Rodada> rodadas = montarRodadas(listaTimes);		
		campeonato.setListaRodadas(rodadas);

		return campeonato;
	}

	private List<Rodada> montarRodadas(List<Time> listaTimes) {
		
		List<Rodada> listaRodada = new ArrayList<Rodada>();		
		boolean qtdTimesImpar = false;
		
		Time cabecaChave;
		
		// Se a quantidade de times for ímpar instancia um objeto Time como cabeca de chave
		if (listaTimes.size() % 2 != 0) {
			qtdTimesImpar = true;
			cabecaChave = new Time();
		} else {
			cabecaChave = listaTimes.get(0);
			listaTimes.remove(0);	
		}

		int qtdeRodadas = listaTimes.size();
		
		for (int numRodada = 0; numRodada < qtdeRodadas; numRodada ++) {
			
			Rodada rodada = new Rodada();			
			//Cada rodada tem uma lista de partidaas
			List<Partida> listaPartidas = new ArrayList<>();
			
			List<Time> listaTimesAux = new ArrayList<>();
			listaTimesAux.addAll(listaTimes);
			
			Time ultimoTimeLista = listaTimes.get(listaTimes.size() - 1);

			for (int numPartida = 0; numPartida < listaTimesAux.size(); numPartida++) {
				
				if (!qtdTimesImpar) {
					listaPartidas = PartidasUtil.gerarPartidasQtdeTimesPar(cabecaChave, numRodada, listaPartidas, listaTimesAux, numPartida);
				} else {
					listaPartidas = PartidasUtil.gerarPartidasQtdeTimesImpar(cabecaChave, numRodada, listaPartidas, listaTimesAux, numPartida);	
				}
			}
			
			rodada.setListaPartidas(listaPartidas);
			listaRodada.add(rodada);
			
			listaTimes = girarListaTimes(listaTimes, ultimoTimeLista);
		}
		
		return listaRodada;
	}

	private List<Time> girarListaTimes(List<Time> listaTimes, Time ultimoTimeLista) {
		List<Time> lista = new ArrayList<>();

		lista.add(ultimoTimeLista);

		for (Time time : listaTimes) {
			if (!time.equals(ultimoTimeLista)) {
				lista.add(time);
			}
		}

		return lista;
	}

}
