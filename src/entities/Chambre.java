package entities;

public class Chambre {
	private int id;
	private String telephone;
	private Categorie c;
	private static int cnt=0;
	
	public Chambre(int id, String telephone, Categorie c) {
		super();
		this.id = id;
		this.telephone = telephone;
		this.c = c;
	}
	public Chambre(String telephone,Categorie c) {
		this.id = cnt++;
		this.telephone = telephone;
		this.c = c;
	}
	public Categorie getC() {
		return c;
	}

	public void setC(Categorie c) {
		this.c = c;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return id+" " +c ;
	}
	
	
	
	
	

}
