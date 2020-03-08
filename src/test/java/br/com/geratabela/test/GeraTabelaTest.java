package br.com.geratabela.test;

import br.com.geratabela.GeraTabelaCampeonato;
import br.com.geratabela.model.Campeonato;
import br.com.geratabela.model.Partida;
import br.com.geratabela.model.Rodada;
import org.junit.Test;

import java.util.List;

public class GeraTabelaTest {

	@Test
	public void gerarTabela() {
		GeraTabelaCampeonato geraTabela = new GeraTabelaCampeonato();

		Campeonato campeonato = geraTabela.gerarTabela(1);

		for (Rodada rodada : campeonato.getListaRodadas()) {
			System.out.println("==================================");
			for (Partida partida : rodada.getListaPartidas()) {
				System.out.println(partida.getTimeCasa().getNome() + " X " + partida.getTimeVisitante().getNome());
			}
		}

	}
	
}
