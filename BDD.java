package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {
	private String user,mdp, serveur, bdd;
	private Connection maConnexion ;
	
	public BDD(String serveur,String bdd,String user,String mdp){
		this.serveur = serveur;
		this.bdd = bdd;
		this.user = user;
		this.mdp = mdp;
		this.maConnexion = null;
	}
	public void chargerPilote()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException exp) 
		{
			System.out.println("Absence du driver de connexion JDBC");
			
		}
	}
		public void seConnecter ()
		{
			this.chargerPilote();
			String url = "jdbc:mysql://"+this.serveur+"/" +this.bdd;
			
			try 
			{
				this.maConnexion = DriverManager.getConnection(url,this.user,this.mdp);
			}
			catch (SQLException exp)
			{
				System.out.println("Imposible de se connecter a :"+url);
				exp.printStackTrace();
			}
				
		}
	
	public void seDeconnecter ()
	{
		try {
			if (this.maConnexion != null)
			{
				this.maConnexion.close();
			}
		}
		catch (SQLException exp)
		{
			System.out.println("Impossible de fermer la connexion");
		}
	}
	public Connection getMaConnexion ()
	{
		return this.maConnexion ;
	}

}
