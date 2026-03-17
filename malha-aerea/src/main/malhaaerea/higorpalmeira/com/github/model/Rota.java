package malhaaerea.higorpalmeira.com.github.model;

public class Rota {
	
	private Aeroporto origem;
	private Aeroporto destino;
	private int tempoVoo;
	
	public Rota(Aeroporto origem, Aeroporto destino, int tempoVoo) {
		this.origem = origem;
		this.destino = destino;
		this.tempoVoo = tempoVoo;
	}

	public Rota() { }

	public Aeroporto getOrigem() {
		return origem;
	}

	public void setOrigem(Aeroporto origem) {
		this.origem = origem;
	}

	public Aeroporto getDestino() {
		return destino;
	}

	public void setDestino(Aeroporto destino) {
		this.destino = destino;
	}

	public int getTempoVoo() {
		return tempoVoo;
	}

	public void setTempoVoo(int tempoVoo) {
		this.tempoVoo = tempoVoo;
	}

	@Override
	public String toString() {
		return origem.getIcao() + " -> " + destino.getIcao() + " [" + tempoVoo + " min]";
	}
	
	

}
