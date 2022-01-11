package controleur;

public class Technicien {
	private int idtechnicien;
	private String nom, prenom, qualification, email, tel;
	public Technicien(int idtechnicien, String nom, String prenom, String qualification, String email, String tel) {
	
		this.idtechnicien = idtechnicien;
		this.nom = nom;
		this.prenom = prenom;
		this.qualification = qualification;
		this.email = email;
		this.tel = tel;
	}
	public int getIdtechnicien() {
		return idtechnicien;
	}
	public void setIdtechnicien(int idtechnicien) {
		this.idtechnicien = idtechnicien;
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
