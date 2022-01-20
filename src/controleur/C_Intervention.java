package controleur;

import java.util.ArrayList;

import modele.Modele;
import vue.Console;
import vue.VueClient;
import vue.VueIntervention;
import vue.VueTechnicien;
import vue.VueVehicule;

public class C_Intervention {
	
	public void ajouterInterventions()
	{
		//on appelle la vue pour saisir une intervention
				Intervention uneIntervention = VueIntervention.saisirIntervention();
				
				//on appelle le modèle pour insérer les interventions
				Modele.insertIntervention(uneIntervention);
	}
	public void listerInterventions()
	{
		ArrayList<Intervention> lesInterventions = Modele.selectAllInterventions(0,0);
		System.out.println("_______Liste des interventions_____________");
		for(Intervention UneIntervention : lesInterventions)
		{
			VueIntervention.afficherIntervention(UneIntervention);
		}
	}
	public void retirerInterventions()
	{
		int idintervention = VueIntervention.saisirIdIntervention();
		Modele.deleteIntervention(idintervention);
		
	}
	public void modifierInterventions()
	{
		
			//on appelle la vue pour avoir un id client à modifier 
			int idintervention = VueIntervention.saisirIdIntervention();
			// on appelle le modele pour récupérer le client à modifier
			Intervention unIntervention  = Modele.selectWhereIntervention(idintervention);
			
			if(unIntervention != null) {
			//on demande les infos à modifier du client à partir de la vue 
				unIntervention = VueIntervention.modifierInterventions(unIntervention);
			// on réalise la modif en appelant le modèle
			Modele.updateIntervention(unIntervention);
			}
		
	}
	public void interventionsTechnicien()
	{
		//demander un id Technicien 
		int idtechnicien = VueTechnicien.saisirIdTechnicien();
		//récuperer du modèle la liste des interventions de ce technicien
		ArrayList<Intervention> lesInterventions = Modele.selectAllInterventions(idtechnicien,1);
		//améliorer juste selectAllInterventions
		
		//afficher les interventions
	}
	public void interventionsVehicule()
	{
		//demander un id Technicien 
		int idvehicule = VueVehicule.saisirIdVehicule();
				//récuperer du modèle la liste des interventions de ce véhicule
				
				//améliorer juste selectAllInterventions
				ArrayList<Intervention> lesInterventions = Modele.selectAllInterventions(idvehicule, 2); 
				//afficher les interventions
				System.out.println("________Liste des interventions du véhicule___________");
				for(Intervention uneIntervention : lesInterventions)
				{
					VueIntervention.afficherIntervention(uneIntervention);
				}
	}
	public void interventionsClient()
	{
		int idclient = VueClient.saisirIdClient();
		ArrayList<Intervention> lesInterventions = Modele.selectAllInterventions(idclient, 3); 
		//afficher les interventions
		System.out.println("________Liste des interventions du véhicule___________");
		for(Intervention uneIntervention : lesInterventions)
		{
			VueIntervention.afficherIntervention(uneIntervention);
		}
	}
	
	public void menuIntervention ()
	{
		int choix = 0; 
		do{
			System.out.println("________Menu Intervention");
			System.out.println("1- Ajouter une intervention");
			System.out.println("2- Lister les Interventions");
			System.out.println("3- Retirer une Intervention");
			System.out.println("4- Editer une Intervention");
			System.out.println("5- Intervention d'un technicien ");
			System.out.println("6- Intervention d'un vehicule ");
			System.out.println("7- Intervention d'un client ");
			System.out.println("0- Quitter ");
			System.out.println("Votre choix ");
			choix = Console.saisirInt();
			switch(choix)
			{
			case 1 : this.ajouterInterventions(); break;
			case 2 : this.listerInterventions(); break;
			case 3 : this.retirerInterventions(); break;
			case 4 : this.modifierInterventions(); break;
			case 5 : this.interventionsTechnicien();break;
			case 6 : this.interventionsVehicule();break;
			case 7 : this.interventionsClient();break;
			case 0 : break;
			}
		
		}while (choix !=0);
		}
		}

