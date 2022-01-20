package controleur;

import java.util.ArrayList;

import modele.Modele;
import vue.Console;
import vue.VueClient;
import vue.VueVehicule;


public class C_Client {
	
	public void ajouterClient ()
	{
		//on appelle la vue pour saisir un client
		Client unClient = VueClient.saisirClient();
		
		//on appelle le mod�le pour ins�rer le client
		Modele.insertClient(unClient);
	}
	
	public void listerClients ()
	{
		//on appelle le Modele pour r�cup�rer la liste des clients 
		
		ArrayList<Client> lesClients = Modele.selectAllClients();
		//on appelle la vue pour afficher les clients
		for(Client unClient : lesClients)
		{
			VueClient.afficher(unClient);
		}
	}
	public void retirerClient ()
	{
		//on appelle la vue pour avoir un id client � retirer 
		int idclient = VueClient.saisirIdClient();
		//on appelle le mod�le pour v�rifier s'il y a un client avec cet id, si 
		// c'est le cas on supprime, sinon on affiche d'erreur
		Client unClient  = Modele.selectWhereClients(idclient);
		if(unClient !=null)
		{
			Modele.deleteClient(idclient);
		}
		else
		{
			System.out.println("Aucun client avec cet ID ! ");
		}
		
		
		// on appelle le modele pour supprimer de la BDD le client identifi� par id 
		
	}
	
	public void modifierClient ()
	{
		//on appelle la vue pour avoir un id client � modifier 
		int idclient = VueClient.saisirIdClient();
		// on appelle le modele pour r�cup�rer le client � modifier
		Client unClient  = Modele.selectWhereClients(idclient);
		
		if(unClient != null) {
		//on demande les infos � modifier du client � partir de la vue 
		unClient = VueClient.modifierClient(unClient);
		// on r�alise la modif en appelant le mod�le
		Modele.updateClient(unClient);
		}
	}
	public void vehiculesClient()
	{
		//on appelle la vue pour r�cup�rer l'id du client
		int idclient = VueClient.saisirIdClient();
		
		//on appelle le mod�le pour r�cup�rer la liste des v�hicules de ce client
		ArrayList<Vehicule> lesVehicules = Modele.selectAllVehicules(idclient);
		
		//on affichedes v�hicules
		System.out.println("_____Liste des v�hicules de ce client ________");
		for (Vehicule unVehicule : lesVehicules)
		{
			VueVehicule.afficherVehicule(unVehicule);
		}
	}
	
	public void menuClient ()
	{
		int choix = 0; 
		do{
			System.out.println("________Menu Client__________");
			System.out.println("1- Ajouter un client");
			System.out.println("2- Lister les clients");
			System.out.println("3- Retirer un client");
			System.out.println("4- Editer un client");
			System.out.println("5- Les vehicules du client ");
			System.out.println("0- Quitter ");
			System.out.println("Votre choix ");
			choix = Console.saisirInt();
			switch(choix)
			{
			case 1 : this.ajouterClient(); break;
			case 2 : this.listerClients(); break;
			case 3 : this.retirerClient(); break;
			case 4 : this.modifierClient(); break;
			case 5 : this.vehiculesClient();break;
			case 6 : break;
			}
		}
		while (choix !=0);
			
	}

}
