package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.CarrinhoDAO;
import model.entities.Carrinho;
import model.entities.Colecao;

public class CarrinhoDAOJDBC implements CarrinhoDAO {

	private Connection conn;

	public CarrinhoDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Carrinho obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Carrinho obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Carrinho findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT myhotwheels.carrinho.*, myhotwheels.colecao.nome as ColName FROM myhotwheels.carrinho "
					+"JOIN myhotwheels.colecao ON myhotwheels.carrinho.colecaoId = myhotwheels.colecao.id WHERE myhotwheels.carrinho.id = ? ";
			
			// Sempre usar o "as" para renomear colunas se essas colunas forem iguais, pq no rs fica bugando e trazendo o primeiro que tiver
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Colecao col = instantiateColecao(rs);
				Carrinho car = instantiateCarrinho(rs, col);
				return car;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public Carrinho findByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carrinho> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private Carrinho instantiateCarrinho(ResultSet rs, Colecao col) throws SQLException {
		Carrinho car = new Carrinho();
		car.setId(rs.getInt("id"));
		car.setNome(rs.getString("nome"));
		car.setPosicao_Colecao(rs.getString("posicao_Colecao"));
		car.setDescricao(rs.getString("descricao"));
		car.setColecao(col);
		return car;
	}

	private Colecao instantiateColecao(ResultSet rs) throws SQLException {
		Colecao col = new Colecao();
		col.setNome(rs.getString("ColName"));
		System.out.println(col);
		return col;
	}

}
