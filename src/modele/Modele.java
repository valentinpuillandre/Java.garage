package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;
import controleur.Intervention;
import controleur.TableauBord;

import controleur.Technicien;
import controleur.Vehicule;

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
/***************************** gestion des vehicule *******************/
	
	//********************** Insérer un vehicule ***************************
	public static void insertVehicule(Vehicule unVehicule)
	{
		String requete = "insert into vehicule values(null,'" + unVehicule.getMatricule() + "','" +unVehicule.getMarque()
		+"','"+unVehicule.getEnergie() + "','"+ unVehicule.getNbkm() + "','" + unVehicule.getDatecirculation()+"','"
				+ unVehicule.getIdclient()+"');";
		
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
	
	////////////////////////****************************lister les véhicules d'une personne **************************
	public static ArrayList<Vehicule> selectAllVehicules (int idclient)
	{
		ArrayList<Vehicule> lesVehicules = new ArrayList<Vehicule>();
		String requete ;
		if(idclient == 0)
		{
		requete = "select * from vehicule ; ";
		}
		else
		{
		requete = "select * from vehicule where idclient = "+idclient +" ; ";
		}
	
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet desResultats = unStat.executeQuery(requete); //fetchAll de PHP
			//parcours des résultats ppur construire des instances de clients
			while (desResultats.next())
			{
				Vehicule unVehicule = new Vehicule(
			desResultats.getInt("idvehicule"), desResultats.getInt("idvehicule"),
			desResultats.getString("matricule"), 
			desResultats.getString("marque"), desResultats.getString("energie"), 
			desResultats.getInt("nbkm"), desResultats.getString("datecirculation")
						);
				lesVehicules.add(unVehicule);
			}
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		return lesVehicules;
	}
	public static void deleteVehicule (int  idvehicule)
	{
		String requete = "delete from vehicule where idvehicule = " + idvehicule + ";";
		
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

	public static int count(String table) {
		int nb = 0;
		String requete = "select count(*) as nb from " + table + ";";
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet unResultat = unStat.executeQuery(requete);
			if(unResultat.next())
			{
				nb = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		return nb;
	}

//********************************TABLEAU DE BORD**************************************************
	public static ArrayList<TableauBord> selectAllTableauBord ()
	{
		ArrayList<TableauBord> lesTableauBords = new ArrayList<TableauBord>();
		String requete ;
		
		requete = "select * from tableaudebord ; ";
		
		
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet desResultats = unStat.executeQuery(requete); //fetchAll de PHP
			//parcours des résultats ppur construire des instances de clients
			while (desResultats.next())
			{
				TableauBord unTableauBord= new TableauBord(
			desResultats.getString("nomc"), desResultats.getString("prenomc"),
			desResultats.getString("nomt"), 
			desResultats.getString("prenomt"), desResultats.getString("matricule"), 
			desResultats.getString("description"), desResultats.getString("dateinter")
						);
				lesTableauBords.add(unTableauBord);
			}
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		return lesTableauBords;
	}
	
/***************************** gestion des interventions *******************/
	
	//********************** Insérer une intervention ***************************
	public static void insertIntervention(Intervention uneIntervention)
	{
		String requete = "insert into intervention values(null,'" + uneIntervention.getDescription() + "','" +uneIntervention.getPrix()
		+"','"+ uneIntervention.getDateinter()+ "','"+ uneIntervention.getIdvehicule() + "','" + uneIntervention.getIdtechnicien()+"');";
		
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
	
	////////////////////////****************************lister les véhicules d'une personne **************************
	public static ArrayList<Intervention> selectAllInterventions (int id, int choix)
	{
		ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>();
		String requete ;
		
		switch(choix)
		{
		case 1 : requete ="select * from intervention where idtechnicien = " +id +";";break;
		case 2 : requete ="select * from intervention where idvehicule = " +id +";";break;
		case 3 : requete =" select i.idintervention, i.description, i.prix, i.dateinter,i.idvehicule, idtechnicien "
				+ "from intervention i, client c, vehicule v"
				+ "where i.idvehicule = v.idvehicule"
				+ "and v.idclient = c.idclient;"
				+ "and  c.idclient = " + id ;break;
		default  : requete ="select * from intervention ;";break;
		}
		
		requete = "select * from intervention ; ";
	
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet desResultats = unStat.executeQuery(requete); //fetchAll de PHP
			//parcours des résultats ppur construire des instances de clients
			while (desResultats.next())
			{
				Intervention uneIntervention = new Intervention(
			desResultats.getInt("idIntervention"), desResultats.getInt("idvehicule"),
			desResultats.getInt("idtechnicien"), 
			desResultats.getString("description"), desResultats.getString("dateinter"), 
			desResultats.getFloat("prix")
						);
				lesInterventions.add(uneIntervention);
			}
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		return lesInterventions;
	}
	public static void deleteIntervention (int  idintervention)
	{
		String requete = "delete from intervention where idintervention = " + idintervention + ";";
		
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
	
	public static Intervention selectWhereIntervention ( int idintervention)
	{
		
		Intervention unIntervention = null;
		String requete = "select * from intervention where idintervention = " + idintervention + " ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();//curseur 
			ResultSet unResultat = unStat.executeQuery(requete); //fetchAll de PHP
			//extraire un résultat et construire une seule instanc client
			if (unResultat.next())
			{
				unIntervention = new Intervention(
						unResultat.getInt("idIntervention"), unResultat.getInt("idvehicule"),
						unResultat.getInt("idtechnicien"), 
						unResultat.getString("description"), unResultat.getString("dateinter"), 
						unResultat.getFloat("prix")
									);
			}
			unStat.close();
			uneBdd.seDeconnecter();

		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution requete : " + requete);
		}
		return unIntervention;
	}
	public static void updateIntervention (Intervention uneIntervention)
	{
		String requete = "update intervention set description = '" + uneIntervention.getDescription() + "', prix = '" +uneIntervention.getPrix()
		+"',dateinter = '"+uneIntervention.getDateinter() + "',idvehicule = '"+ uneIntervention.getIdvehicule() + "',idtechnicien = '"
		+ uneIntervention.getIdtechnicien()+"' where idintervention = " + uneIntervention.getIdintervention() + ";";
			
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
