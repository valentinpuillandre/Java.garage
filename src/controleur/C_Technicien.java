package controleur;

import java.util.ArrayList;

import modele.Modele;
import vue.Console;
import vue.VueTechnicien;

public class C_Technicien {

	public void ajouterTechnicien ()
	{
		//on appelle la vue pour saisir un technicien
		Technicien unTechnicien = VueTechnicien.saisirTechnicien();
		
		//on appelle le mod�le pour ins�rer le technicien
		Modele.insertTechnicien(unTechnicien);
	}
	public void listerTechniciens ()
	{
		//on appelle le Modele pour r�cup�rer la liste des techniciens 
		
		ArrayList<Technicien> lesTechniciens = Modele.selectAllTechniciens();
		//on appelle la vue pour afficher les clients
		for(Technicien unTechnicien : lesTechniciens)
		{
			VueTechnicien.afficher(unTechnicien);
		}
	}
	
	public void retirerTechnicien ()
	{
		//on appelle la vue pour avoir un id client � retirer 
		int idtechnicien = VueTechnicien.saisirIdTechnicien();
		// on appelle le modele pour supprimer de la BDD le client identifi� par id 
		Modele.deleteTechnicien(idtechnicien);
	}
	public void modifierTechnicien ()
	{
		//on appelle la vue pour avoir un id client � modifier 
		int idtechnicien = VueTechnicien.saisirIdTechnicien();
		// on appelle le modele pour r�cup�rer le client � modifier
		Technicien unTechnicien  = Modele.selectWhereTechnicien(idtechnicien);
		
		if(unTechnicien != null) {
		//on demande les infos � modifier du client � partir de la vue 
		unTechnicien = VueTechnicien.modifierTechnicien(unTechnicien);
		// on r�alise la modif en appelant le mod�le
		Modele.updateTechnicien(unTechnicien);
		}
	}
	public void menuTechnicien ()
	{
		int choix = 0; 
		do{
			System.out.println("________Menu Technicien__________");
			System.out.println("1- Ajouter un Technicien");
			System.out.println("2- Lister les Techniciens");
			System.out.println("3- Retirer un Technicien");
			System.out.println("4- Editer un Technicien");
			System.out.println("5- Les interventions du Technicien ");
			System.out.println("0- Quitter ");
			System.out.println("Votre choix ");
			choix = Console.saisirInt();
			switch(choix)
			{
			case 1 : this.ajouterTechnicien(); break;
			case 2 : this.listerTechniciens(); break;
			case 3 : this.retirerTechnicien(); break;
			case 4 : this.modifierTechnicien();break;
			case 5 : break;
			case 6 : break;
			}
		}
		while (choix !=0);
			
	}
}
