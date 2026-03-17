package malhaaerea.higorpalmeira.com.github.model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	
	List<Aeroporto> aeroportos;
	List<Rota> rotas;
	
	public Grafo(List<Aeroporto> aeroportos, List<Rota> rotas) {
		this.aeroportos = aeroportos;
		this.rotas = rotas;
	}

	public Grafo() {
		this.aeroportos = new ArrayList<>();
		this.rotas = new ArrayList<>();
	}
	
	public void adicionarAeroporto(Aeroporto aeroporto) {
		
		if (!aeroportos.contains(aeroporto)) {
			aeroportos.add(aeroporto);
		}
		
	}
	
	public void adicionarRota(Aeroporto origem, Aeroporto destino, int tempoVoo) {
		
		Rota novaRota = new Rota(origem, destino, tempoVoo);
		rotas.add(novaRota);
		
	}
	
	public List<Aeroporto> getAeroportos() {
		
		return aeroportos;
		
	}
	
	public List<Rota> getRotas() {
		
		return rotas;
		
	}

}
