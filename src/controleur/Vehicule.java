package controleur;

public class Vehicule {
	private int idvehicule, idclient;
	private String matricule, marque, energie;
	private int nbkm;
	private String datecirculation;
	public Vehicule(int idvehicule, int idclient, String matricule, String marque, String energie, int nbkm,
			String datecirculation) {
		super();
		this.idvehicule = idvehicule;
		this.idclient = idclient;
		this.matricule = matricule;
		this.marque = marque;
		this.energie = energie;
		this.nbkm = nbkm;
		this.datecirculation = datecirculation;
	}
	public int getIdvehicule() {
		return idvehicule;
	}
	public void setIdvehicule(int idvehicule) {
		this.idvehicule = idvehicule;
	}
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getEnergie() {
		return energie;
	}
	public void setEnergie(String energie) {
		this.energie = energie;
	}
	public int getNbkm() {
		return nbkm;
	}
	public void setNbkm(int nbkm) {
		this.nbkm = nbkm;
	}
	public String getDatecirculation() {
		return datecirculation;
	}
	public void setDatecirculation(String datecirculation) {
		this.datecirculation = datecirculation;
	}
	
}
