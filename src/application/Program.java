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

		//----------------------------------------------------------------------------//
		
		System.out.println("\n==== TEST 2: colecao insert ====");
		Colecao newColecao = new Colecao(null, "NIGHTBURNERZ", 10);
		colecaoDAO.insert(newColecao);
		System.out.println("Inserido, novo id = " + newColecao.getId());
		
		//----------------------------------------------------------------------------//
		
		System.out.println("\n==== TEST 2: carrinho insert ====");
		Carrinho newCarrinho = new Carrinho("'96 CHEVROLET IMPALA SS", "2", "", newColecao);
		carrinhoDAO.insert(newCarrinho);
		System.out.println("Inserido, novo id = " + newCarrinho.getId());
	}

}
