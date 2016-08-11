package br.com.geratabela.model;

import java.util.ArrayList;
import java.util.List;

public class Rodada {
	private List<Partida> listaPartidas = new ArrayList<>();

	public List<Partida> getListaPartidas() {
		return listaPartidas;
	}

	public void setListaPartidas(List<Partida> listaPartidas) {
		this.listaPartidas = listaPartidas;
	}
	
}
