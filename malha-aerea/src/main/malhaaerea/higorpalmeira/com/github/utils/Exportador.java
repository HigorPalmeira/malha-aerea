package malhaaerea.higorpalmeira.com.github.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import malhaaerea.higorpalmeira.com.github.model.Rota;

public class Exportador {

	public static void exportarParaDOT(String arquivo, List<Rota> malhaEssencial) {

		// String arquivo = "malha_aerea_mt.gv";

		try (FileWriter writer = new FileWriter(arquivo)) {

			writer.write("graph MalhaAerea {\n");

			writer.write("	node [shape=ellipse, style=filled, fillcolor=lightblue, fontname=\"Arial\"];\n");
			writer.write("	edge [color=gray50, fontname=\"Arial\", fontsize=10];\n");

			for (Rota rota : malhaEssencial) {
				String origem = rota.getOrigem().getIcao();
				String destino = rota.getDestino().getIcao();
				int peso = rota.getTempoVoo();

				writer.write(String.format("	\"%s\" -- \"%s\" [label=\"%d min\"];\n", origem, destino, peso));

			}

			writer.write("}\n");

			System.out.println("\nArquivo para visualização gerado com sucesso: " + arquivo);

		} catch (IOException e) {

			System.out.println("Erro ao exportar arquivo: " + e.getMessage());

		}

	}

}
