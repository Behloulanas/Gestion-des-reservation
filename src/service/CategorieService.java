package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.connexion;
import dao.IDAO;
import entities.Categorie;

public class CategorieService implements IDAO<Categorie> {
	List<Categorie> cat = new ArrayList<>();
	@Override
	public boolean create(Categorie o) {
		String req = "insert into categorie values(null,?,?)";
		try {
			PreparedStatement stmt=connexion.getCon().prepareStatement(req);
			stmt.setString(1, o.getCode());
			stmt.setString(2, o.getLibelle());
			if(stmt.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return false;
	}
	@Override
	public boolean update(Categorie o) {
		String req="update categorie set code=?,libelle=? where id=?";
		try {
			PreparedStatement stmt=connexion.getCon().prepareStatement(req);
			stmt.setString(1, o.getCode());
			stmt.setString(2, o.getLibelle());
			stmt.setInt(3, o.getId());
			if(stmt.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean delete(Categorie o) {
		String req="delete from categorie where id=?";
		try {
			PreparedStatement stmt = connexion.getCon().prepareStatement(req);
			stmt.setInt(1, o.getId());
			if(stmt.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Categorie> findAll() {
		String req="select * from categorie";
		List<Categorie> cats=new ArrayList<Categorie>();
		try {
			PreparedStatement stmt=connexion.getCon().prepareStatement(req);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				cats.add(new Categorie(rs.getInt("id"),rs.getString("code"),rs.getString("libelle")));
			}
			return cats;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public Categorie findById(int id) {
		String req="select * from categorie where id=?";
		try {
			PreparedStatement stmt=connexion.getCon().prepareStatement(req);
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return new Categorie(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
