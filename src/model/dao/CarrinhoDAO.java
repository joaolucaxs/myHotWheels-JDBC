package model.dao;

import java.util.List;

import model.entities.Carrinho;
import model.entities.Colecao;

public interface CarrinhoDAO {

	void insert(Carrinho obj);

	void update(Carrinho obj);

	void deleteById(Integer id);

	Carrinho findById(Integer id);

	Carrinho findByName(String nome);

	List<Carrinho> findAll();

	List<Carrinho> findByColecao(Colecao colecao);

}
