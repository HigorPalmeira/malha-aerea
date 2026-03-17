package malhaaerea.higorpalmeira.com.github.leitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

import malhaaerea.higorpalmeira.com.github.model.Aeroporto;
import malhaaerea.higorpalmeira.com.github.model.Grafo;

public class Leitor {
	
	private static final int LIMIT = 10001;
	private static final String SEPARATOR = ";";
	
	private static final int ICAO_ORIGEM_IDX = 22;
	private static final int CIDADE_ORIGEM_IDX = 24;
	private static final int ICAO_DESTINO_IDX = 26;
	private static final int CIDADE_DESTINO_IDX = 28;
	private static final int HORARIO_PARTIDA_IDX = 30;
	private static final int HORARIO_CHEGADA_IDX = 31;

	public static Grafo crieGrafoDoCSV(String arquivo) {

		Grafo grafo = new Grafo();

		try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

			String linha = br.readLine();
			int cont = 0;
			while ((linha = br.readLine()) != null && cont < LIMIT) {
				cont++;
				String[] colunas = linha.split(SEPARATOR);

				if (colunas.length < 32) {
					continue;
				}

				String icaoOrigem = colunas[ICAO_ORIGEM_IDX];
				String cidadeOrigem = colunas[CIDADE_ORIGEM_IDX];
				String icaoDestino = colunas[ICAO_DESTINO_IDX];
				String cidadeDestino = colunas[CIDADE_DESTINO_IDX];
				String strHorarioPartida = colunas[HORARIO_PARTIDA_IDX];
				String strHorarioChegada = colunas[HORARIO_CHEGADA_IDX];

				Aeroporto origem = new Aeroporto(icaoOrigem, cidadeOrigem);
				Aeroporto destino = new Aeroporto(icaoDestino, cidadeDestino);

				grafo.adicionarAeroporto(origem);
				grafo.adicionarAeroporto(destino);

				int tempoVoo = calcularTempoVoo(strHorarioPartida, strHorarioChegada);

				if (tempoVoo < 25 || tempoVoo > 1440) { // não adicionar rotas com erro no grafo;
					continue;
				}

				grafo.adicionarRota(origem, destino, tempoVoo);

			}

		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}

		return grafo;

	}

	private static int calcularTempoVoo(String partida, String chegada) {

		try {

			LocalTime horaPartida = LocalTime.parse(partida);
			LocalTime horaChegada = LocalTime.parse(chegada);

			long minutos = Duration.between(horaPartida, horaChegada).toMinutes();

			if (minutos < 0) { // voo da meia noite
				minutos += 1440;
			}

			return (int) minutos;

		} catch (Exception e) {
			return 0;
		}

	}

}
