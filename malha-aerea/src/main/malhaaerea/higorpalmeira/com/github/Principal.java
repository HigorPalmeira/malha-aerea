package malhaaerea.higorpalmeira.com.github;

import java.util.List;

import malhaaerea.higorpalmeira.com.github.algoritmos.Kruskal;
import malhaaerea.higorpalmeira.com.github.leitor.Leitor;
import malhaaerea.higorpalmeira.com.github.model.Aeroporto;
import malhaaerea.higorpalmeira.com.github.model.Grafo;
import malhaaerea.higorpalmeira.com.github.model.Rota;
import malhaaerea.higorpalmeira.com.github.utils.Exportador;

public class Principal {
	
	public static void main(String[] args) {
		
		String caminho = "SirosGradeDeDados.csv";
		
		Grafo grafo = Leitor.crieGrafoDoCSV(caminho);
		
		System.out.print("\n===\tRESUMO DO GRAFO\t===\n");
		System.out.println("Total de Aeroportos (Vértices): " + grafo.getAeroportos().size());
		System.out.println("Total de Voos (Arestas): " + grafo.getRotas().size());
		
		System.out.print("\n===\tLISTA DE AEROPORTOS\t===\n");
		for (Aeroporto aeroporto : grafo.getAeroportos()) {
			System.out.println(aeroporto);
		}
		
		System.out.print("\n===\tALGUMAS ROTAS CADASTRADAS\t===\n");
		for (int i=0; i<Math.min(5, grafo.getRotas().size()); i++) {
			System.out.println(grafo.getRotas().get(i));
		}
		
		System.out.println("\n========================================");
		System.out.println("EXECUTANDO O ALGORITMO DE KRUSKAL (MST)...");
		System.out.println("==========================================");
		
		List<Rota> malhaEssencial = Kruskal.executar(grafo);
		
		int tempoTotalMalha = 0;
		for (Rota rota : malhaEssencial) {
			tempoTotalMalha += rota.getTempoVoo();
		}
		
		System.out.println("Malha Aérea Essencial gerada com sucesso!");
		System.out.println("Aeroportos Conectados: " + grafo.getAeroportos().size());
		System.out.println("Quantidade de Voos Originais: " + grafo.getRotas().size());
		System.out.println("Quantidade de Voos na Malha Essencial: " + malhaEssencial.size());
		System.out.println("Tempo Total de Voo da Malha (Minutos): " + tempoTotalMalha);
		
		System.out.println("\n===\tTOP 10 VOOS MAIS RÁPIDOS DA MALHA\t===");
		for (int i=0; i<Math.min(10, tempoTotalMalha); i++) {
			System.out.println(malhaEssencial.get(i));
		}
		
		Exportador.exportarParaDOT("malha_aerea_mt.gv", malhaEssencial);
		
	}
	
}
