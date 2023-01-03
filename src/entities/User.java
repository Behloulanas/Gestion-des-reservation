/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author YAHYA
 */
public class User {
    
    private int id;
	private String nom;
	private String prenom;
	private String Telephone;
	private String email;
	private String password;
	private static int cnt=0;
	
	public User(int id, String nom, String prenom, String telephone, String email, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.Telephone = telephone;
		this.email = email;
		this.password = password;
	}
	public User(String nom, String prenom, String telephone, String email, String password) {
		super();
		this.id = cnt++;
		this.nom = nom;
		this.prenom = prenom;
		this.Telephone = telephone;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", Telephone=" + Telephone + ", email="
				+ email + ", password=" + password + "]";
	}
}
        

