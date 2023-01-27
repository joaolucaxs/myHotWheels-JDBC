package model.dao;
import db.DB;
import model.dao.impl.CarrinhoDAOJDBC;
import model.dao.impl.ColecaoDAOJDBC;

public class FactoryDAO {

	public static CarrinhoDAO createCarrinhoDAO() {
		return new CarrinhoDAOJDBC(DB.getConnection());
	}
	
	public static ColecaoDAO createColecaoDAO() {
		return new ColecaoDAOJDBC(DB.getConnection());
	}
}
