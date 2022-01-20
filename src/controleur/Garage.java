package controleur;


import java.util.ArrayList;

import modele.Modele;
import vue.Console;
import vue.VueVehicule;


public class Garage {

	private C_Client unControleurClient = new C_Client();
	private C_Technicien unControleurTechnicien = new C_Technicien();
	private C_Vehicule unControleurVehicule = new C_Vehicule();
	private C_Intervention unControleurIntervention= new C_Intervention();
	public void stats ()
	{
		int nbClients = 0, nbTechniciens = 0, nbVehicules = 0, nbInterventions=0;
		
		//on appelle le modèle pour récupérer les nombres d'enregistrements par table
		
		nbClients = Modele.count("client");
		nbTechniciens  =Modele.count("technicien");
		nbVehicules = Modele.count("vehicule");
		nbInterventions = 	Modele.count("intervention");
		
		
		System.out.println("____________Statistiques de la BDD_______________");
		System.out.println("Nombre de clients : " + nbClients);
		System.out.println("Nombre de techniciens : " +nbTechniciens);
		System.out.println("Nombre de véhicules : " + nbVehicules);
		System.out.println("Nombre de Nomnre d'interventions : " +nbInterventions);
		System.out.println("________________________________________");
		
		
	}
	public void tableauBord()
	{
		/*
		déroulement:
		1. Allez dans le controleur réaliser une classe : tableauBord avec tous les champs
		qui existent dans la view (nomc,prenomc, nomt, prenomt, matricule, description, dateinter
		
		2. Allez dans le Modele et créer une méthode : selectAllTableauBord ()
		
		3. Ici dans cette méthode , récupérer l'ArrayList<TableauBord> et affichez les résultats
		
		*/

			ArrayList<TableauBord> lesTableauBords = Modele.selectAllTableauBord();
			System.out.println("________________Tableau de bord __________________\n");
			for (TableauBord unTableauBord : lesTableauBords)
			{
				
				System.out.println("Nom du client             : " + unTableauBord.getNomc());
				System.out.println("Prénom du client          : " + unTableauBord.getPrenomc());
				System.out.println("Nom du technicien         : " + unTableauBord.getNomt());
				System.out.println("Prénom du technicien      : " + unTableauBord.getPrenomt());
				System.out.println("Matricule                 : " + unTableauBord.getMatricule());
				System.out.println("Description               : " + unTableauBord.getDescription());
				System.out.println("Date de l'intervention    : " + unTableauBord.getDateinter());
				System.out.println("___________________________________________________\n");
				
			}
		
	}
	
	public void menuGeneral ()
	{
		int choix = 0; 
		do{
			System.out.println("________Menu General garage__________");
			System.out.println("1- Gérer les clients");
			System.out.println("2- Gérer les techniciens");
			System.out.println("3- Gérer les véhicules");
			System.out.println("4- Gérer les interventions");
			System.out.println("5- Statistiques ");
			System.out.println("6- Tableau de bords ");
			System.out.println("0- Quitter ");
			System.out.println("Votre choix ");
			choix = Console.saisirInt();
			switch(choix)
			{
			case 1 : unControleurClient.menuClient(); break;
			case 2 : unControleurTechnicien.menuTechnicien();break;
			case 3 : unControleurVehicule.menuVehicule (); break;
			case 4 : unControleurIntervention.menuIntervention ();break;
			case 5 : stats();break;
			case 6 : tableauBord ();break;
			case 7 : break;
			}
		}
		while (choix !=0);
			
	}

	public static void main(String[] args) {
		Garage norauto = new Garage ();
		norauto. menuGeneral ();
	}

}
