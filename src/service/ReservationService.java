package service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import entities.Categorie;
import connection.connexion;
import dao.IDAO;
import entities.Chambre;
import entities.Client;
import entities.Reservation;

public class ReservationService implements IDAO<Reservation> {
    private List<Reservation> reservations;
    private CategorieService cat = new CategorieService();
    public ReservationService(){
        reservations = new ArrayList<Reservation>();
    }
	@Override
	public boolean create(Reservation o) {
		String req="insert into reservation values (null,?,?,?,?)";
		try {
			PreparedStatement stmt = connexion.getCon().prepareStatement(req);
			stmt.setDate(1,new Date(o.getDatedebut().getTime()));
			stmt.setDate(2,new Date(o.getDatefin().getTime()));
			stmt.setInt(3,o.getCl().getId());
			stmt.setInt(4,o.getCh().getId());
			
			if (stmt.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean update(Reservation o) {
		String req="update reservation set datedebut=?,datefin=?,idClient=?,idChambre=? where id=?";
		try {
			PreparedStatement stmt = connexion.getCon().prepareStatement(req);
			stmt.setInt(3,o.getCl().getId());
			stmt.setInt(4,o.getCh().getId());
			stmt.setDate(1,new Date(o.getDatedebut().getTime()));
			stmt.setDate(2,new Date(o.getDatefin().getTime()));
                        stmt.setInt(5,o.getId());
			if (stmt.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean delete(Reservation o) {
		String req="delete from reservation where id=?";
		try {
			PreparedStatement stmt = connexion.getCon().prepareStatement(req);
			stmt.setInt(1,o.getId());
            if(stmt.executeUpdate()==1)
                return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Reservation> findAll() {
		ClientService cls = new ClientService();
		ChambreService chs = new ChambreService();
		String req="select * from reservation";
		List<Reservation> Reservations=new ArrayList<Reservation>();
		try {
			PreparedStatement stmt = connexion.getCon().prepareStatement(req);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				Reservations.add(new Reservation(rs.getInt(1),rs.getDate(2),rs.getDate(3),cls.findById(rs.getInt(4)),chs.findById(rs.getInt(5))));
			}
                        return Reservations;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Reservation findById(int id) {
		ClientService cls = new ClientService();
		ChambreService chs = new ChambreService();
		String req="select * from reservation where id=?";
		try {
			PreparedStatement stmt=connexion.getCon().prepareStatement(req);
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return new Reservation (rs.getInt(1),rs.getDate(2),rs.getDate(3),cls.findById(rs.getInt(4)),chs.findById(rs.getInt(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
        public List<Chambre> findChambreBetweenDates(Client client, java.util.Date dateDebut, java.util.Date dateFin) {
        String req;
        req = "select c.id,c.telephone,c.idCategorie from chambre c,reservation "
                + "where reservation.idChambre = c.id and reservation.idClient = ? and reservation.dateDebut>=? and reservation.dateFin<=?";
        List<Chambre> cham = new ArrayList<Chambre>();
        try {
            PreparedStatement stmt = connexion.getCon().prepareStatement(req);
            stmt.setInt(1, client.getId());
            stmt.setDate(2, new Date(dateDebut.getTime()));
            stmt.setDate(3, new Date(dateFin.getTime()));
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                cham.add(new Chambre(res.getInt(1), res.getString(2), cat.findById(res.getInt(3))));
            }
            return cham;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
      

}
