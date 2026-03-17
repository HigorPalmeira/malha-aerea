package malhaaerea.higorpalmeira.com.github.model;

import java.util.Objects;

public class Aeroporto {
	
	private String icao;
	private String cidade;
	
	public Aeroporto() { }

	public Aeroporto(String icao, String cidade) {
		this.icao = icao;
		this.cidade = cidade;
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, icao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeroporto other = (Aeroporto) obj;
		return Objects.equals(icao, other.icao);
	}

	@Override
	public String toString() {
		return icao + "(" + cidade + ")";
	}
	
	

}
