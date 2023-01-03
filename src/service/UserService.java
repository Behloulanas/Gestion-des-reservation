/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.connexion;
import dao.IDAO;
import entities.User;
/**
 *
 * @author YAHYA
 */

    





public class UserService  implements IDAO<User>{
	List<User> utili = new ArrayList<>();
	@Override
	public boolean create(User o) {
		String req = "insert into utilisateur values (null,?,?,?,?,?)";		
		try {
			PreparedStatement stmt = connexion.getCon().prepareStatement(req);
			stmt.setString(1,o.getNom());
			stmt.setString(2, o.getPrenom());
			stmt.setString(3,o.getTelephone());
			stmt.setString(4,o.getEmail());
			stmt.setString(5,o.getPassword());
			if (stmt.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(User o) {
		String req = "update utilisateur set nom=?,prenom=?,telephone=?,email=?,password=? where id=?";
		try {
			PreparedStatement stmt = connexion.getCon().prepareStatement(req);
			stmt.setString(1, o.getNom());
			stmt.setString(2, o.getPrenom());
			stmt.setString(3, o.getEmail());
			stmt.setString(4, o.getTelephone());
			stmt.setString(5,o.getPassword());
			stmt.setInt(6, o.getId());
			if(stmt.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}

	@Override
	public boolean delete(User o) {
		String req="delete from utilisateur where id=?";
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
	public List<User> findAll() {
		String req="select * from utilisateur";
		List<User> utilis =new ArrayList<User>();
		try {
			PreparedStatement stmt=connexion.getCon().prepareStatement(req);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				utilis.add(new User(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("telephone"),rs.getString("email"),rs.getString("password")));
			}
			return utilis;
		} catch (SQLException e) {
			e.printStackTrace();
		};
		return null;
	}

	@Override
	public User findById(int id) {
		String req="select * from utilisateur where id = ?";
		try {
			PreparedStatement stmt=connexion.getCon().prepareStatement(req);
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}

