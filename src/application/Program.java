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

		// ----------------------------------------------------------------------------//

		CarrinhoDAO carrinhoDAO = FactoryDAO.createCarrinhoDAO();

		System.out.println("\n==== TEST 1: carrinho findById ====");
		Carrinho carrinho = carrinhoDAO.findById(1);
		System.out.println(carrinho);

		// ----------------------------------------------------------------------------//

		System.out.println("\n==== TEST 2: colecao insert ====");
		Colecao newColecao = new Colecao(null, "NIGHTBURNERZ", 10);
		colecaoDAO.insert(newColecao);
		System.out.println("Inserido, novo id = " + newColecao.getId());

		// ----------------------------------------------------------------------------//

		System.out.println("\n==== TEST 2: carrinho insert ====");
		Carrinho newCarrinho = new Carrinho("'96 CHEVROLET IMPALA SS", "2", "", newColecao);
		carrinhoDAO.insert(newCarrinho);
		System.out.println("Inserido, novo id = " + newCarrinho.getId());

		// ----------------------------------------------------------------------------//

		System.out.println("\n==== TEST 3: colecao update ====");
		colecao = colecaoDAO.findById(4);
		colecao.setNome("COLECAO QUALQUER");
		colecao.setTamanho(10);
		colecaoDAO.update(colecao);

		// ----------------------------------------------------------------------------//

		System.out.println("\n==== TEST 3: carrinho update ====");
		carrinho = carrinhoDAO.findById(1);
		carrinho.setNome("2019 AUDI R8 SPYDER");
		carrinho.setColecao(new Colecao(1, null, null));
		carrinhoDAO.update(carrinho);

		// ----------------------------------------------------------------------------//

		System.out.println("\n==== TEST 4: colecao delete ====");
		colecaoDAO.deleteById(3);

		// ----------------------------------------------------------------------------//

		System.out.println("\n==== TEST 4: carrinho delete ====");
		carrinhoDAO.deleteById(10);

	}

}
