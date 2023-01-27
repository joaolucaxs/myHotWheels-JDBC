package model.dao;

import java.util.List;

import model.entities.Carrinho;

public interface CarrinhoDAO {

	void insert(Carrinho obj);

	void update(Carrinho obj);

	void deleteById(Integer id);

	Carrinho findById(Integer id);

	Carrinho findByName(String nome);

	List<Carrinho> findAll();

	List<Carrinho> showCarsByIdCollection(Integer id);

}
