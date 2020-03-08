package br.com.geratabela.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.com.geratabela.model.Time;

public class TimesUtil {

	/**
	 * Método que carrega uma lista de times para montagem da tabela. A lista de times esta cadastrada no arquivo "equipes" do classloader
	 */
	public  List<Time> carregaListaTimes() {
		List<Time> listaTimes = new ArrayList<>();

		try {
			String urlArquivo = getClass().getClassLoader().getResource("equipes").getPath();
			Path equipes = Paths.get(urlArquivo);
			List<String> equipesLinha = Files.readAllLines(equipes);

			for (String equipe: equipesLinha) {
				Time time = new Time();
				time.setNome(equipe);

				listaTimes.add(time);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaTimes;
	}
}