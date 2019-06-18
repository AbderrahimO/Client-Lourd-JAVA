package modele;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;


public class ModeleClient {
	private static BDD uneBdd = new BDD("localhost", "alume", "root", "");
	
	public static ArrayList<Client> selectAllClients ()
	{
		ArrayList<Client> lesClients = new ArrayList<Client>();
		
		String requete = "select id_cli, mail_cli, mdp_cli, nom_cli, prenom_cli, tel_cli, adress_cli, cp_cli from client ;" ;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next())
			{
				int idclient = unRes.getInt("id_cli"); 
				String mail = unRes.getString("mail_cli");
				String mdp = unRes.getString("mdp_cli");
				String nom = unRes.getString("nom_cli"); 
				String prenom = unRes.getString("prenom_cli");
				String telcli = unRes.getString("tel_cli");
				String adresse = unRes.getString("adress_cli");
				String cpcli = unRes.getString("cp_cli");
				Client unClient = new Client(idclient, mail, mdp, nom, prenom, telcli, adresse, cpcli); 
				lesClients.add(unClient);
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete );
		}
		return lesClients; 
	}
	
	public static void insertClient (Client unClient)
	{
		String requete = "insert into client values (null, '" + unClient.getMail()+"' , '" + unClient.getMdp() + "', '" +
						unClient.getNom() +"', '" + unClient.getPrenom() +"',null, '" +
						unClient.getTelcli() +"', '" + unClient.getAdresse() +"', '" + unClient.getCpcli() +"',null);";
	
  		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	
	public static void updateClient (Client unClient)
	{
		String requete = "update client set nom_cli ='"+unClient.getNom()
					+ "', adress_cli='"+unClient.getAdresse() 
					+ "', mail_cli = '"+unClient.getMail()
				    + "', mdp_cli = '" +unClient.getMdp()
				    + "', nom_cli = '"+unClient.getNom()
				    + "', prenom_cli = '"+unClient.getPrenom()
				    + "', tel_cli = '"+unClient.getTelcli()
				    + "', adress_cli = '" + unClient.getAdresse()
					+ "', cp_cli = '" + unClient.getCpcli()
					+"' where id_cli = " + unClient.getIdclient() 
					+ ";" ;
		
		
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
						
	}
	
	public static void deleteClient (int idClient)
	{
		String requete = "delete from client where id_cli =" 
					+ idClient +";";
		
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
	}
	public static Client selectWhere (Client unClient)
	{
		String requete = "select id_cli, mail_cli,mdp_cli,nom_cli,prenom_cli,tel_cli,adress_cli,cp_cli from client where "
				+ " mail_cli = '"+unClient.getMail()
				+ "' and mdp_cli = '" +unClient.getMdp()
				+ "' and nom_cli = '"+unClient.getNom()
				+ "' and prenom_cli = '"+unClient.getPrenom()
				+ "' and tel_cli = '"+unClient.getTelcli()
				+ "' and adress_cli = '" + unClient.getAdresse()
				+ "' and cp_cli = '" + unClient.getCpcli()
				+ "' ; ";
		Client leClient = null;
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int idclient = unRes.getInt("id_cli");
				leClient = new Client(idclient, unClient.getMail(), unClient.getMdp(), unClient.getNom(), unClient.getPrenom(), unClient.getTelcli(), unClient.getAdresse(), unClient.getCpcli());
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return leClient;
	}
}
