package malhaaerea.higorpalmeira.com.github.algoritmos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import malhaaerea.higorpalmeira.com.github.model.Aeroporto;

public class UnionFind {

	private Map<Aeroporto, Aeroporto> pai = new HashMap<>();
	
	public void criarSet(List<Aeroporto> aeroportos) {
		
		for (Aeroporto aeroporto : aeroportos) {
			pai.put(aeroporto, aeroporto);
		}
		
	}
	
	public Aeroporto find(Aeroporto aeroporto) {
		
		if (pai.get(aeroporto).equals(aeroporto)) {
			return aeroporto;
		}
		
		Aeroporto raiz = find(pai.get(aeroporto));
		pai.put(aeroporto, raiz);
		return raiz;
		
	}
	
	public void union(Aeroporto aeroporto1, Aeroporto aeroporto2) {
		
		Aeroporto raiz1 = find(aeroporto1);
		Aeroporto raiz2 = find(aeroporto2);
		
		if (!raiz1.equals(raiz2)) {
			pai.put(raiz1, raiz2);
		}
		
	}
	
}
