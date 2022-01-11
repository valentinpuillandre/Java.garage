package vue;

import controleur.Vehicule;

public class VueVehicule {
	public static Vehicule saisirVehicule(int idclient )
	{
		String matricule, marque, energie, datecirculation;
		int nbkm;
		System.out.println("Donner le matricule du V�hicule : ");
		matricule = Console.saisirString();
		System.out.println("Donner la marque du V�hicule : ");
		marque = Console.saisirString();
		System.out.println("Donner l'�nergie du V�hicule : ");
		energie = Console.saisirString();
		System.out.println("Donner le nombre de km du V�hicule : ");
		nbkm = Console.saisirInt();
		System.out.println("Donner la date de circulation du V�hicule : ");
		datecirculation = Console.saisirString();
		
		Vehicule unVehicule = new Vehicule (0,idclient, matricule, marque, energie, nbkm, datecirculation);
		return unVehicule;
		
	}
	public static void afficherVehicule (Vehicule unVehicule)
	{
		System.out.println("_________________INFOS DU VEHICULE___________________");
		System.out.println("ID vehicule : " + unVehicule.getIdvehicule());
		System.out.println("ID vehicule : " + unVehicule.getMatricule());
		System.out.println("ID vehicule : " + unVehicule.getMarque());
		System.out.println("ID vehicule : " + unVehicule.getEnergie());
		System.out.println("ID vehicule : " + unVehicule.getNbkm());
		System.out.println("ID vehicule : " + unVehicule.getDatecirculation());
		System.out.println("ID vehicule : " + unVehicule.getIdclient());
	}
	public static String toXml (Vehicule unVehicule)
	{
		String chaine = "<vehicule>\n";
		chaine +="</matricule>\n" + unVehicule.getMatricule() + "</matricule>\n" ;
		chaine +="</marque>\n" + unVehicule.getMarque() + "</marque>\n" ;
		chaine +="</energie>\n" + unVehicule.getEnergie() + "</energie>\n" ;
		chaine +="</nbkm>\n" + unVehicule.getNbkm() + "</nbkm>\n" ;
		chaine +="</datecirculation>\n" + unVehicule.getDatecirculation() + "</datecirculation>\n" ;
		chaine +="</idclient>\n" + unVehicule.getIdclient() + "</idclient>\n" ;
		chaine +="</vehicule>\n";
		return chaine;
	}
	

}
