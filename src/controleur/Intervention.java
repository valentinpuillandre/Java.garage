package controleur;

public class Intervention {
	private int idintervention, idvehicule, idtechnicien;
	private String description, dateinter;
	private float prix;
	public Intervention(int idintervention, int idvehicule, int idtechnicien, String description, String dateinter,
			float prix) {
		super();
		this.idintervention = idintervention;
		this.idvehicule = idvehicule;
		this.idtechnicien = idtechnicien;
		this.description = description;
		this.dateinter = dateinter;
		this.prix = prix;
	}
	public int getIdintervention() {
		return idintervention;
	}
	public void setIdintervention(int idintervention) {
		this.idintervention = idintervention;
	}
	public int getIdvehicule() {
		return idvehicule;
	}
	public void setIdvehicule(int idvehicule) {
		this.idvehicule = idvehicule;
	}
	public int getIdtechnicien() {
		return idtechnicien;
	}
	public void setIdtechnicien(int idtechnicien) {
		this.idtechnicien = idtechnicien;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateinter() {
		return dateinter;
	}
	public void setDateinter(String dateinter) {
		this.dateinter = dateinter;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
}
