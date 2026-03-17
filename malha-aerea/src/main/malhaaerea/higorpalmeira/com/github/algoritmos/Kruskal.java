package malhaaerea.higorpalmeira.com.github.algoritmos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import malhaaerea.higorpalmeira.com.github.model.Aeroporto;
import malhaaerea.higorpalmeira.com.github.model.Grafo;
import malhaaerea.higorpalmeira.com.github.model.Rota;

public class Kruskal {

	public static List<Rota> executar(Grafo grafo) {
		
		List<Rota> mst = new ArrayList<>();
		List<Rota> allRotas = new ArrayList<>(grafo.getRotas());
		
		allRotas.sort(Comparator.comparingInt(Rota::getTempoVoo)); // ordenar da menor para maior
		
		UnionFind unionFind = new UnionFind();
		unionFind.criarSet(grafo.getAeroportos());
		
		for (Rota rota : allRotas) {
			
			Aeroporto origem = rota.getOrigem();
			Aeroporto destino = rota.getDestino();
			
			if (rota.getTempoVoo() <= 0) { // rota com dado errado
				continue;
			}
			
			if (!unionFind.find(origem).equals(unionFind.find(destino)) ) { // sem representante, une
				
				unionFind.union(origem, destino);
				mst.add(rota);
				
			}
			
		}
		
		return mst;
		
	}
	
}
