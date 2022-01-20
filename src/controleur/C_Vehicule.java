package controleur;

import java.util.ArrayList;

import modele.Modele;
import vue.Console;
import vue.VueClient;
import vue.VueVehicule;

public class C_Vehicule 
{

	
		private int idClientChoisi = 0 ; 
		
		public boolean verifierId (int idClient)
		{
			ArrayList<Client> lesClients = Modele.selectAllClients();
			for(Client unClient : lesClients)
			{
				if (unClient.getIdclient() == idClient)
			{
			return true;
			}
			}
			return false;
			}
		public void saisirIdClient()
			{
			ArrayList<Client> lesClients = Modele.selectAllClients();
			do {
			String chaine = "Liste des Clients [";
			for(Client unClient : lesClients)
				{
				chaine+= unClient.getIdclient()+" : "+unClient.getPrenom()+" "+unClient.getNom()+";";
				}
			chaine += "]";
			System.out.println(chaine);
			this.idClientChoisi = VueClient.saisirIdClient();
			}while (! verifierId(this.idClientChoisi ));
			Client unClient = Modele.selectWhereClients(this.idClientChoisi);
			if(unClient == null)
			{
				System.out.println("Aucun client avec cet ID");
				this.idClientChoisi = 0;
			}
			else
			{
				System.out.println("Vous allez gérer les véhicules du client :");
				VueClient.afficher(unClient);
			}
		}
		//********************************************************************************
	
		//************************************************************************************
		public void insertVehicule ()
		{
			//on appelle la vue pour créer un véhicule du client choisi
			this.saisirIdClient();
			if(this.idClientChoisi != 0) {
			Vehicule unVehicule = VueVehicule.saisirVehicule(this.idClientChoisi);
			//on appelle le modele pour insérer ce véhicule dans la BDD
			Modele.insertVehicule(unVehicule);
			}
		}
		public void listerVehiculeClient ()
		{
			saisirIdClient();
			if(this.idClientChoisi != 0)
			{
				ArrayList<Vehicule> lesVehicules = Modele.selectAllVehicules (this.idClientChoisi);
				for (Vehicule unVehicule : lesVehicules)
				{
					VueVehicule.afficherVehicule(unVehicule);
					
				}
			}
		}
		public void listerVehicules ()
		{
			
				ArrayList<Vehicule> lesVehicules = Modele.selectAllVehicules(0) ;
				for (Vehicule unVehicule : lesVehicules)
				{
					VueVehicule.afficherVehicule(unVehicule);
					
				}
			
		}
		public void retirerVehicule ()
		{
			//on appelle la vue pour avoir un id client à retirer 
			int idvehicule = VueVehicule.saisirIdVehicule();
			// on appelle le modele pour supprimer de la BDD le client identifié par id 
			Modele.deleteVehicule(idvehicule);
		}
		public void menuVehicule ()
		{
		int choix = 0; 
		do{
			System.out.println("________Menu Vehicule__________");
			System.out.println("1- Ajouter un Vehicule");
			System.out.println("2- Lister les Vehicule du client");
			System.out.println("3- Retirer un Vehicule");
			System.out.println("4- Editer un Vehicule");
			System.out.println("5- Lister tous les vehicules ");
			System.out.println("0- Quitter ");
			System.out.println("Votre choix ");
			choix = Console.saisirInt();
			switch(choix)
			{
			case 1 : this.insertVehicule(); break;
			case 2 : this.listerVehiculeClient(); break;
			case 3 : this.retirerVehicule(); break;
			case 4 :  break;
			case 5 : this.listerVehicules();break;
			case 6 : break;
			}
		}
		while (choix !=0);
			
	}
}
