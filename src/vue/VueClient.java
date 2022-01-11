package vue;

import controleur.Client;

public class VueClient {
	public static Client saisirClient()
	{
		String nom, prenom, adresse, email, tel;
		System.out.println("Donner le nom du client : ");
		nom = Console.saisirString();
		System.out.println("Donner le prenom du client : ");
		prenom = Console.saisirString();
		System.out.println("Donner le adresse du client : ");
		adresse = Console.saisirString();
		System.out.println("Donner le email du client : ");
		email = Console.saisirString();
		System.out.println("Donner le tel du client : ");
		tel = Console.saisirString();
		Client unCLient = new Client(0, nom, prenom, adresse, email, tel);
		return unCLient;
		
	}
	
	public static void afficher(Client unClient)
	{
		System.out.println("________________INFO DU CLIENT __________________");
		System.out.println("ID client     : " + unClient.getIdclient());
		System.out.println("NOM client    : " + unClient.getNom());
		System.out.println("PRENOM client : " + unClient.getPrenom());
		System.out.println("ADRESSE client: " + unClient.getAdresse());
		System.out.println("EMAIL client  : " + unClient.getEmail());
		System.out.println("TEL client    : " + unClient.getTel());
	}
	public static String toXml(Client unClient)
	{
		String chaine = "<client>\n";
		chaine +="</nom>\n" + unClient.getNom() + "</nom>\n" ;
		chaine +="</prenom>\n" + unClient.getPrenom() + "</prenom>\n" ;
		chaine +="</adresse>\n" + unClient.getAdresse() + "</adresse>\n" ;
		chaine +="</email>\n" + unClient.getEmail() + "</email>\n" ;
		chaine +="</tel>\n" + unClient.getTel() + "</tel>\n" ;
		chaine +="</client>\n";
		return chaine;
	}
	
	public static int saisirIdClient ()
	{
		int id;
		System.out.println("Donner un id Client : ");
		id = Console.saisirInt();
		return id;
	}
	
	public static Client modifierClient( Client unClient)
	{
		System.out.println("Ancien nom client  : " + unClient.getNom());
		System.out.println("Donner le nouveau nom du client : ");
		unClient.setNom(Console.saisirString());
		
		System.out.println("Ancien prénom client  : " + unClient.getPrenom());
		System.out.println("Donner le nouveau prénom du client : ");
		unClient.setPrenom(Console.saisirString());
		
		System.out.println("Ancienne adresse client  : " + unClient.getAdresse());
		System.out.println("Donner la nouvelle adresse du client : ");
		unClient.setAdresse(Console.saisirString());
		
		System.out.println("Ancien mail client  : " + unClient.getEmail());
		System.out.println("Donner la nouvelle adresse mail client : ");
		unClient.setEmail(Console.saisirString());
		
		System.out.println("Ancien téléphone client  : " + unClient.getTel());
		System.out.println("Donner la nouvelle ligne téléphonique du client : ");
		unClient.setTel(Console.saisirString());
		
		return unClient;
		
	}
}
