package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.connexion;
import dao.IDAO;
import entities.Client;

public class ClientService implements IDAO<Client>{
	List<Client> cli = new ArrayList<>();
	@Override
	public boolean create(Client o) {
		String req = "insert into client values (null,?,?,?,?)";
		try {
			PreparedStatement stmt = connexion.getCon().prepareStatement(req);
			stmt.setString(1,o.getNom());
			stmt.setString(2,o.getPrenom());
			stmt.setString(3,o.getTelephone());
			stmt.setString(4,o.getEmail());
			if (stmt.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean update(Client o) {
		String req = "update client set nom=?,prenom=?,telephone=?,email=? where id=?";
		try {
			PreparedStatement stmt = connexion.getCon().prepareStatement(req);
                        stmt.setInt(5, o.getId());
			stmt.setString(1, o.getNom());
			stmt.setString(2, o.getPrenom());
                        stmt.setString(3, o.getTelephone());
			stmt.setString(4, o.getEmail());
			if(stmt.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}
	@Override
	public boolean delete(Client o) {
		String req="delete from client where id=?";
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
	public List<Client> findAll() {
		String req="select * from client";
		List<Client> clients =new ArrayList<Client>();
		try {
			PreparedStatement stmt=connexion.getCon().prepareStatement(req);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				clients.add(new Client(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("telephone"),rs.getString("email")));
			}
			return clients;
		} catch (SQLException e) {
			e.printStackTrace();
		};
		return null;
	}
	@Override
	public Client findById(int id) {
		String req="select * from client where id=?";
		try {
			PreparedStatement stmt=connexion.getCon().prepareStatement(req);
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}
