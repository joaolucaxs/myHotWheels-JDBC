package model.dao;

import java.util.List;

import model.entities.Colecao;

public interface ColecaoDAO {

	void insert(Colecao obj);

	void update(Colecao obj);

	void deleteById(Integer id);

	Colecao findById(Integer id);

	Colecao findByName(String nome);

	List<Colecao> findAll();
}
