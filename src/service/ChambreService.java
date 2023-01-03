package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.connexion;
import dao.IDAO;
import entities.Categorie;
import entities.Chambre;

public class ChambreService implements IDAO<Chambre>{
	List<Chambre> cha = new ArrayList<>();
	 CategorieService cats = new CategorieService();
	@Override
	public boolean create(Chambre o) {
		String req = "insert into chambre values(null,?,?)";
		try {
			PreparedStatement stmt = connexion.getCon().prepareStatement(req);
			stmt.setString(1,o.getTelephone());
			stmt.setInt(2, o.getC().getId());
			if(stmt.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean update(Chambre o) {
		String req="update chambre set telephone=?,idCategorie=? where id=?";
		try {
			PreparedStatement stmt=connexion.getCon().prepareStatement(req);
			stmt.setString(1,o.getTelephone());
			stmt.setInt(2, o.getC().getId());
			stmt.setInt(3, o.getId());
			if(stmt.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean delete(Chambre o) {
		 String req="delete from chambre where id=?";
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
	public List<Chambre> findAll() {
		String req="select * from chambre";
        List<Chambre> chambres=new ArrayList<Chambre>();
        try {
            PreparedStatement stmt=connexion.getCon().prepareStatement(req);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                chambres.add(new Chambre(rs.getInt("id"),rs.getString("telephone"),cats.findById(rs.getInt(3))));
            }
            return chambres;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public Chambre findById(int id) {
		String req="select * from chambre where id=?";
        try {
            PreparedStatement stmt=connexion.getCon().prepareStatement(req);
            stmt.setInt(1, id);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()) {
                return new Chambre(rs.getInt(1),rs.getString(2),cats.findById(rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
	  public List<Chambre> findChambreByCategorie(Categorie c) {
            String query = "select c.id,c.telephone,c.idCategorie from chambre c,categorie cat\n"
                    + "where c.idCategorie = cat.id and cat.id = ?";
        List<Chambre> chambres = new ArrayList<Chambre>();
        try {
            PreparedStatement stmt = connexion.getCon().prepareStatement(query);
            stmt.setInt(1, c.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                chambres.add(new Chambre(rs.getInt("id"), rs.getString("telephone"), cats.findById(rs.getInt(3))));
            }
            return chambres;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
