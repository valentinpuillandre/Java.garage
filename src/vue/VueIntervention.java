package vue;

import controleur.Intervention;

public class VueIntervention {


	
	public static Intervention saisirIntervention()
	{
		String description, dateinter;
		int idvehicule, idtechnicien;
		float prix;
		
		System.out.println("Donner la description : ");
		description = Console.saisirString();
		System.out.println("Donner la date de l'intervention : ");
		dateinter = Console.saisirString();
		System.out.println("Donner l'id du véhicule : ");
		idvehicule = Console.saisirInt();
		System.out.println("Donner l'id du technicien : ");
		idtechnicien = Console.saisirInt();
		System.out.println("Donner le prix : ");
		prix = Console.saisirFloat();
		Intervention uneIntervention = new Intervention(0, idvehicule, idtechnicien, description, dateinter, prix);
		return uneIntervention;
		
	}
	
	public static void afficherIntervention(Intervention uneIntervention)
	{
		System.out.println("________________INFO D'UNE INTERVENTION __________________");
		System.out.println("ID Vehicule    : " + uneIntervention.getIdintervention());
		System.out.println("ID Intervention     : " + uneIntervention.getIdvehicule());
		System.out.println("ID Vehicule    : " + uneIntervention.getIdtechnicien());
		System.out.println("ID technicien : " + uneIntervention.getDescription());
		System.out.println("Description: " + uneIntervention.getDateinter());
		System.out.println("date inter  : " + uneIntervention.getPrix());
		
	}
	
	public static int saisirIdIntervention ()
	{
		int id;
		System.out.println("Donner un id intervention : ");
		id = Console.saisirInt();
		return id;
	}
	
	public static Intervention modifierInterventions( Intervention unIntervention)
	{
		int choix;
		do
		{
			System.out.println("_________________MODIFICATION INTERVENTION____________");
			System.out.println("1- Modifier la description");
			System.out.println("2- Modifier le prix");
			System.out.println("3- Modifier la date d'intervention");
			System.out.println("4- Modifier l'id vehicule");
			System.out.println("5- Modifier l'id technicien");
			System.out.println("0- Quitter");
			choix =Console.saisirInt();
			switch (choix)
			{
			
			case 1 : 
		System.out.println("Ancienne description  : " + unIntervention.getDescription());
		System.out.println("Donner la nouvelle description : ");
		unIntervention.setDescription(Console.saisirString()); break;
		
			case 2 : 
		System.out.println("Ancien prix  : " + unIntervention.getPrix());
		System.out.println("Donner le nouveau prix : ");
		unIntervention.setPrix(Console.saisirFloat()); break;
		
			case 3: 
		System.out.println("Ancienne date d'intervention  : " + unIntervention.getDateinter());
		System.out.println("Donner la nouvelle date d'intervention : ");
		unIntervention.setDateinter(Console.saisirString());break;
		
			case 4 : 
		System.out.println("Ancien Id vehicule  : " + unIntervention.getIdvehicule());
		System.out.println("Donner le nouvel Id vehicule : ");
		unIntervention.setIdvehicule(Console.saisirInt()); break;
		
			case 5 :
		System.out.println("Ancien Id technicien  : " + unIntervention.getIdtechnicien());
		System.out.println("Donner le nouvel Id technicien : ");
		unIntervention.setIdtechnicien(Console.saisirInt()); break;
			}
	}while(choix!=0);
		return unIntervention;
		
	}
}
