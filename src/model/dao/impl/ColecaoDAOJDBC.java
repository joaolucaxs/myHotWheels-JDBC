package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		PreparedStatement st = null;

		try {
			String sql = "INSERT INTO colecao " + "(nome, tamanho) " + "VALUES (?, ?) ";

			st = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNome());
			st.setInt(2, obj.getTamanho());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Nenhuma linha afetada");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Colecao obj) {
		PreparedStatement st = null;

		try {
			String sql = "UPDATE colecao " + "SET colecao.nome = ?, colecao.tamanho = ? " + "WHERE id = ? ";

			st = conn.prepareStatement(sql);
			st.setString(1, obj.getNome());
			st.setInt(2, obj.getTamanho());
			st.setInt(3, obj.getId());

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;

		try {
			String sql = "DELETE FROM colecao WHERE Id = ?";

			st = conn.prepareStatement(sql);
			st.setInt(1, id);

			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

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
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM myhotwheels.colecao";

			st = conn.prepareStatement(sql);
			rs = st.executeQuery();

			List<Colecao> list = new ArrayList<>();
			Map<Integer, Colecao> map = new HashMap<>();

			while (rs.next()) {

				Colecao col = map.get(rs.getInt("id"));

				if (col == null) {
					col = instantiateColecao(rs);
					map.put(rs.getInt("id"), col);
				}

				list.add(col);
			}
			return list;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Colecao instantiateColecao(ResultSet rs) throws SQLException {
		Colecao col = new Colecao();
		col.setId(rs.getInt("id"));
		col.setNome(rs.getString("nome"));
		col.setTamanho(rs.getInt("tamanho"));
		return col;
	}

}
