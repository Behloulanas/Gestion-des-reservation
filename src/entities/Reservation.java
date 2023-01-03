package entities;

import java.util.Date;

public class Reservation {
	private int id;
	private Date datedebut;
	private Date datefin;
	private Client cl;
	private Chambre ch;
	private static int cnt=0;
	
	public Reservation(int id,Date datedebut, Date datefin, Client cl, Chambre ch) {
		this.id = id;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.cl = cl;
		this.ch = ch;
	}
	public Reservation(Date datedebut, Date datefin, Client cl, Chambre ch) {
		this.id = cnt++;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.cl = cl;
		this.ch = ch;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public Client getCl() {
		return cl;
	}

	public void setCl(Client cl) {
		this.cl = cl;
	}

	public Chambre getCh() {
		return ch;
	}

	public void setCh(Chambre ch) {
		this.ch = ch;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", datedebut=" + datedebut + ", datefin=" + datefin + ", cl=" + cl + ", ch="
				+ ch + "]";
	}
	
	
}
