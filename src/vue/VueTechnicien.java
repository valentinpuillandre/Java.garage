package vue;

import controleur.Technicien;

public class VueTechnicien {
	public static Technicien saisirTechnicien()
	{
		String nom, prenom, qualification, email, tel;
		System.out.println("Donner le nom du Technicien : ");
		nom = Console.saisirString();
		System.out.println("Donner le prenom du Technicien : ");
		prenom = Console.saisirString();
		System.out.println("Donner le adresse du Technicien : ");
		qualification = Console.saisirString();
		System.out.println("Donner le email du Technicien : ");
		email = Console.saisirString();
		System.out.println("Donner le tel du Technicien : ");
		tel = Console.saisirString();
		Technicien unTechnicien = new Technicien(0, nom, prenom, qualification, email, tel);
		return unTechnicien;
		
	}
	
	public static void afficher(Technicien unTechnicien)
	{
		System.out.println("________________INFO DU TECHNICIEN __________________");
		System.out.println("ID Technicien     : " + unTechnicien.getIdtechnicien());
		System.out.println("NOM Technicien    : " + unTechnicien.getNom());
		System.out.println("PRENOM Technicien : " + unTechnicien.getPrenom());
		System.out.println("qualification technicien: " + unTechnicien.getQualification());
		System.out.println("EMAIL Technicien  : " + unTechnicien.getEmail());
		System.out.println("TEL Technicien    : " + unTechnicien.getTel());
	}
	public static String toXml(Technicien unTechnicien)
	{
		String chaine = "<technicien>\n";
		chaine +="</nom>\n" + unTechnicien.getNom() + "</nom>\n" ;
		chaine +="</prenom>\n" + unTechnicien.getPrenom() + "</prenom>\n" ;
		chaine +="</qualification>\n" + unTechnicien.getQualification() + "</qualification>\n" ;
		chaine +="</email>\n" + unTechnicien.getEmail() + "</email>\n" ;
		chaine +="</tel>\n" + unTechnicien.getTel() + "</tel>\n" ;
		chaine +="</technicien>\n";
		return chaine;
	}
	
	public static int saisirIdTechnicien ()
	{
		int id;
		System.out.println("Donner un id Technicien : ");
		id = Console.saisirInt();
		return id;
	}
	
	public static Technicien modifierTechnicien( Technicien unTechnicien)
	{
		System.out.println("Ancien nom Technicien  : " + unTechnicien.getNom());
		System.out.println("Donner le nouveau nom du Technicien : ");
		unTechnicien.setNom(Console.saisirString());
		
		System.out.println("Ancien prénom Technicien  : " + unTechnicien.getPrenom());
		System.out.println("Donner le nouveau prénom du Technicien : ");
		unTechnicien.setPrenom(Console.saisirString());
		
		System.out.println("Ancienne qualification Technicien  : " + unTechnicien.getQualification());
		System.out.println("Donner la nouvelle qualification du Technicien : ");
		unTechnicien.setQualification(Console.saisirString());
		
		System.out.println("Ancien mail Technicien  : " + unTechnicien.getEmail());
		System.out.println("Donner la nouvelle adresse mail Technicien : ");
		unTechnicien.setEmail(Console.saisirString());
		
		System.out.println("Ancien téléphone Technicien  : " + unTechnicien.getTel());
		System.out.println("Donner la nouvelle ligne téléphonique du Technicien : ");
		unTechnicien.setTel(Console.saisirString());
		
		return unTechnicien;
		
	}
	
	
	
}
