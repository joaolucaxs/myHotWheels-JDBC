package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Colecao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer tamanho;
	
	public Colecao() {
	}


	public Colecao(String nome, Integer tamanho) {
		this.nome = nome;
		this.tamanho = tamanho;
	}
	
	public Colecao(Integer id, String nome, Integer tamanho) {
		this.id = id;
		this.nome = nome;
		this.tamanho = tamanho;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getTamanho() {
		return tamanho;
	}


	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}


	@Override
	public String toString() {
		return "Colecao [id=" + id + ", nome=" + nome + ", tamanho=" + tamanho + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colecao other = (Colecao) obj;
		return Objects.equals(id, other.id);
	}
	

}
