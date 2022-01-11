package controleur;


import vue.Console;


public class Garage {

	private C_Client unControleurClient = new C_Client();
	private C_Technicien unControleurTechnicien = new C_Technicien();
	
	
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
			System.out.println("0- Quitter ");
			System.out.println("Votre choix ");
			choix = Console.saisirInt();
			switch(choix)
			{
			case 1 : unControleurClient.menuClient(); break;
			case 2 : unControleurTechnicien.menuTechnicien();break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			case 6 : break;
			}
		}
		while (choix !=0);
			
	}

	public static void main(String[] args) {
		Garage norauto = new Garage ();
		norauto. menuGeneral ();
	}

}
