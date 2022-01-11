package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.Technicien;

public class Modele {

	private static Bdd uneBdd = new Bdd("localhost","garage","root","");
	/***************************** gestion des clients *******************/
	
	//********************** Insérer un client ***************************
	public static void insertClient(Client unClient)
	{
		String requete = "insert into client values(null,'" + unClient.getNom() + "','" +unClient.getPrenom()
		+"','"+unClient.getAdresse() + "','"+ unClient.getEmail() + "','" + unClient.getTel()+"');";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
	}
	//******************Afficher les clients *************************
	
	public static ArrayList<Client> selectAllClients ()
	{
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete = "select * from client ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet desResultats = unStat.executeQuery(requete); //fetchAll de PHP
			//parcours des résultats ppur construire des instances de clients
			while (desResultats.next())
			{
				Client unClient = new Client(
			desResultats.getInt("idclient"), desResultats.getString("nom"), 
			desResultats.getString("prenom"), desResultats.getString("adresse"), 
			desResultats.getString("email"), desResultats.getString("tel")
						);
				lesClients.add(unClient);
			}
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		return lesClients;
	}
	
	public static Client selectWhereClients ( int idclient)
	{
		
		Client unClient = null;
		String requete = "select * from client where idclient = " + idclient + " ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet unResultat = unStat.executeQuery(requete); //fetchAll de PHP
			//extraire un résultat et construire une seule instanc client
			if (unResultat.next())
			{
				unClient = new Client(
			unResultat.getInt("idclient"), unResultat.getString("nom"), 
			unResultat.getString("prenom"), unResultat.getString("adresse"), 
			unResultat.getString("email"), unResultat.getString("tel")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		return unClient;
	}
	
	// *******************supprimer un client *************************
	public static void deleteClient(int  idclient)
	{
		String requete = "delete from client where idclient = " + idclient + ";";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
	}
	
	public static void updateClient(Client unClient)
	{
	String requete = "update client set nom = '" + unClient.getNom() + "', prenom = '" +unClient.getPrenom()
	+"',adresse = '"+unClient.getAdresse() + "',email = '"+ unClient.getEmail() + "',tel = '"
	+ unClient.getTel()+"' where idclient = " + unClient.getIdclient() + ";";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
	}
	/***************************** gestion des techniciens *******************/
	
	//********************** Insérer un technicien ***************************
	public static void insertTechnicien(Technicien unTechnicien)
	{
		String requete = "insert into technicien values(null,'" + unTechnicien.getNom() + "','" +unTechnicien.getPrenom()
		+"','"+unTechnicien.getQualification() + "','"+ unTechnicien.getEmail() + "','" + unTechnicien.getTel()+"');";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
	}
	
	//******************Afficher les techniciens *************************
	
	public static ArrayList<Technicien> selectAllTechniciens ()
	{
		ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>();
		String requete = "select * from technicien ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet desResultats = unStat.executeQuery(requete); //fetchAll de PHP
			//parcours des résultats ppur construire des instances de techniciens
			while (desResultats.next())
			{
				Technicien unTechnicien = new Technicien(
			desResultats.getInt("idtechnicien"), desResultats.getString("nom"), 
			desResultats.getString("prenom"), desResultats.getString("qualification"), 
			desResultats.getString("email"), desResultats.getString("tel")
						);
				lesTechniciens.add(unTechnicien);
			}
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		return lesTechniciens;
	}
	
	// *******************supprimer un Technicien *************************
	
	public static void deleteTechnicien (int  idtechnicien)
	{
		String requete = "delete from client where idtechnicien = " + idtechnicien + ";";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
	}
	
	public static Technicien selectWhereTechnicien ( int idtechnicien)
	{
		
		Technicien unTechnicien = null;
		String requete = "select * from technicien where idtechnicien = " + idtechnicien + " ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet unResultat = unStat.executeQuery(requete); //fetchAll de PHP
			//extraire un résultat et construire une seule instanc client
			if (unResultat.next())
			{
				unTechnicien = new Technicien(
			unResultat.getInt("idtechnicien"), unResultat.getString("nom"), 
			unResultat.getString("prenom"), unResultat.getString("qualification"), 
			unResultat.getString("email"), unResultat.getString("tel")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		return unTechnicien;
	}
	
	public static void updateTechnicien(Technicien unTechnicien)
	{
	String requete = "update technicien set nom = '" + unTechnicien.getNom() + "', prenom = '" +unTechnicien.getPrenom()
	+"',qualification = '"+unTechnicien.getQualification() + "',email = '"+ unTechnicien.getEmail() + "',tel = '"
	+ unTechnicien.getTel()+"' where idtechnicien = " + unTechnicien.getIdtechnicien() + ";";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
	}
	}
