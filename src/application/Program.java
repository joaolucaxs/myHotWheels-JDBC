package application;

import model.dao.CarrinhoDAO;
import model.dao.ColecaoDAO;
import model.dao.FactoryDAO;
import model.entities.Carrinho;
import model.entities.Colecao;

public class Program {

	public static void main(String[] args) {
		
		
		ColecaoDAO colecaoDAO = FactoryDAO.createColecaoDAO();
		
		System.out.println("\n==== TEST 1: colecao findById ====");
		Colecao colecao = colecaoDAO.findById(2);
		System.out.println(colecao);
		
		//----------------------------------------------------------------------------//
		
		CarrinhoDAO carrinhoDAO = FactoryDAO.createCarrinhoDAO();
		
		System.out.println("\n==== TEST 1: carrinho findById ====");
		Carrinho carrinho = carrinhoDAO.findById(5);
		System.out.println(carrinho);


	}

}
