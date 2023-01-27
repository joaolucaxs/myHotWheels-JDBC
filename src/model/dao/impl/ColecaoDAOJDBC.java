package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ColecaoDAO;
import model.entities.Colecao;

public class ColecaoDAOJDBC implements ColecaoDAO {

	
	private Connection conn;

	public ColecaoDAOJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Colecao obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Colecao obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Colecao findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM myhotwheels.colecao WHERE id = ?";
			
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Colecao col = instantiateColecao(rs);
				return col;
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
	public Colecao findByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Colecao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private Colecao instantiateColecao(ResultSet rs) throws SQLException {
		Colecao col = new Colecao();
		col.setId(rs.getInt("id"));
		col.setNome(rs.getString("nome"));
		col.setTamanho(rs.getInt("tamanho"));
		return col;
	}

}
