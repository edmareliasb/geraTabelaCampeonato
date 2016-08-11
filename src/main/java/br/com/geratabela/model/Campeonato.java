package br.com.geratabela.model;

import java.util.ArrayList;
import java.util.List;

public class Campeonato {
	private List<Rodada> listaRodadas = new ArrayList<>();
	
	private List<Time> listaTimes = new ArrayList<>();
	
	public List<Rodada> getListaRodadas() {
		return listaRodadas;
	}

	public void setListaRodadas(List<Rodada> listaRodadas) {
		this.listaRodadas = listaRodadas;
	}
	
	public List<Time> getListaTimes() {
		return listaTimes;
	}
	
	public void setListaTimes(List<Time> listaTimes) {
		this.listaTimes = listaTimes;
	}
}
