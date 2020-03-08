package br.com.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import br.com.geratabela.GeraTabelaCampeonato;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import br.com.geratabela.model.Campeonato;
import br.com.geratabela.model.Partida;
import br.com.geratabela.model.Rodada;

public class MontaExcel {

	public static void main(String[] args) throws IOException {

		GeraTabelaCampeonato gera = new GeraTabelaCampeonato();
		Campeonato campeonato = gera.gerarTabela(1);

		List<Rodada> rodadas = campeonato.getListaRodadas();

		// Criando o arquivo fisico
		FileOutputStream out = new FileOutputStream("D:\\workbook.xls");

		// Criando area de trabalho para o excel
		Workbook wb = new HSSFWorkbook();
		// criando uma nova sheet
		Sheet sheet = wb.createSheet();

		int linha = 0;
		int numRodada = 0;

		for (Rodada rodada : rodadas) {

			Row linhaRodada = sheet.createRow(++linha);
			Cell cellLinhaRodada = linhaRodada.createCell(0);
			cellLinhaRodada.setCellValue(++numRodada + " Semana");

			for (Partida partida : rodada.getListaPartidas()) {
				Row row = sheet.createRow(++linha);

				int numCel = 0;

				Cell cell = row.createCell(numCel++);
				cell.setCellValue(partida.getTimeCasa().getNome());

				Cell cell2 = row.createCell(numCel++);
				cell2.setCellValue("");

				Cell cell3 = row.createCell(numCel++);
				cell3.setCellValue("X");

				Cell cell4 = row.createCell(numCel++);
				cell4.setCellValue("");

				Cell cell5 = row.createCell(numCel++);
				cell5.setCellValue(partida.getTimeVisitante().getNome());
			}

		}

		// Criando uma referencia para Linha
		// Row r = null;

		// Referencia para Celula
		// Cell c = null;

		// Criando a primeira linha na LINHA zero, que seria o n�mero 1
		// r = sheet.createRow(0);

		// Criando a celula na posicao ZERO, que seria A, com referencia na
		// linha ZERO criado acima ou seja, colocaremos
		// informacao na A1
		// c = r.createCell(0);

		// Colocando um valor
		// c.setCellValue("byiorio");

		// Salvando o arquivo
		wb.write(out);
		out.close();

	}

}
