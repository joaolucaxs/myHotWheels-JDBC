package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Carrinho implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String posicao_Colecao;
	private String descricao;
	private Colecao colecao;

	public Carrinho() {
	}

	public Carrinho(String nome, String posicao_Colecao, String descricao, Colecao colecao) {
		this.nome = nome;
		this.posicao_Colecao = posicao_Colecao;
		this.descricao = descricao;
		this.colecao = colecao;
	}

	public Carrinho(Integer id, String nome, String posicao_Colecao, String descricao, Colecao colecao) {
		this.id = id;
		this.nome = nome;
		this.posicao_Colecao = posicao_Colecao;
		this.descricao = descricao;
		this.colecao = colecao;
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

	public String getPosicao_Colecao() {
		return posicao_Colecao;
	}

	public void setPosicao_Colecao(String posicao_Colecao) {
		this.posicao_Colecao = posicao_Colecao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Colecao getColecao() {
		return colecao;
	}

	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}

	@Override
	public String toString() {
		return "Carrinho [id=" + id + ", nome=" + nome + ", posicao_Colecao=" + posicao_Colecao + ", descricao="
				+ descricao + ", colecao=" + colecao.getNome() + "]";
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
		Carrinho other = (Carrinho) obj;
		return Objects.equals(id, other.id);
	}

}
