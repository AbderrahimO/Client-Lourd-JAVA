package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Chauffeur;

public class ModeleChauffeur 
{
	private static BDD uneBDD = new BDD("localhost", "alume", "root", "");
	
	public static void insertChauffeur (Chauffeur unChauffeur)
	{
		String requete = "insert into chauffeur values(null, '" + unChauffeur.getNom_chauf() 
	              + "','" +unChauffeur.getPrenom_chauf() +"','" +unChauffeur.getTel_chauf() +
	              "','" + unChauffeur.getLibre()+"');";
	    ModeleChauffeur.uneBDD.seConnecter();
	    try {
	        Statement unStat = ModeleChauffeur.uneBDD.getMaConnexion().createStatement();
	        unStat.execute(requete);
	        } catch (SQLException exp) {
	        System.out.println("Erreur d'execution de la requete : " +requete);
	    }
	    ModeleChauffeur.uneBDD.seDeconnecter();
	}
	public static void updateUser (Chauffeur unChauffeur){
		String requete = "update chauffeur set nom_chauf =('" + unChauffeur.getNom_chauf() 
	              + "', prenom_chauf = " +unChauffeur.getPrenom_chauf() +", tel_chauf = " +unChauffeur.getTel_chauf() +
	              ", libre = '" + unChauffeur.getLibre()+"' where id_chauf = "+unChauffeur.getId_chauf()+");";
	    ModeleChauffeur.uneBDD.seConnecter();
	    try {
	        Statement unStat = ModeleChauffeur.uneBDD.getMaConnexion().createStatement();
	        unStat.execute(requete);
	        }
	    catch (SQLException exp) {
	        System.out.println("Erreur d'execution de la requete : " +requete);
	    }
	}
	
	public static void deleteChauffeur(int idChauffeur) {
		String requete = "delete from chauffeur" + "where id_chauf ="+idChauffeur+";";
		ModeleChauffeur.uneBDD.seConnecter();
		try
		{
			Statement unStat = ModeleChauffeur.uneBDD.getMaConnexion().createStatement();
			unStat.execute(requete);
			
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur execution requete:"+ requete);
		}
		ModeleChauffeur.uneBDD.seDeconnecter();
		
	}
	
	public static Chauffeur selectWhereChauffeur(Chauffeur unChauffeur)
    {
        String requete = " select * from chauffeur where nom_chauf ='" +unChauffeur.getNom_chauf()+"' "
        		+ "and prenom_chauf = '"+unChauffeur.getPrenom_chauf()+"' "	+ "and tel_chauf ='"+ unChauffeur.getTel_chauf()
        		+"' and libre = '" +unChauffeur.getLibre() +"' ;" ;
        Chauffeur unChauffeur1 = null;
        ModeleChauffeur.uneBDD.seConnecter();
        try
        {
            Statement unStat = ModeleChauffeur.uneBDD.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            if (unResultat.next())
            {
                unChauffeur1 = new Chauffeur(
                        unResultat.getInt("id_chauf"),
                        unResultat.getString("nom_chauf"),
                        unResultat.getString("prenom_chauf"),
                        unResultat.getString("tel_chauf"),
                        unResultat.getString("libre")
                        );
            }
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution de la requete : "+requete);
        }
        ModeleChauffeur.uneBDD.seDeconnecter();
        return unChauffeur1;
    }
	public static ArrayList<Chauffeur> selectAllChauffeurs(){
		ArrayList<Chauffeur> lesChauffeurs = new ArrayList<Chauffeur>();
		String requete = "select * from chauffeur;";
		ModeleChauffeur.uneBDD.seConnecter();
		Chauffeur unChauffeur;
		try
		{
			Statement unStat = ModeleChauffeur.uneBDD.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			while (unResultat.next())
			{
				unChauffeur = new Chauffeur(
						unResultat.getInt("id_chauf"),
						unResultat.getString("nom_chauf"),
						unResultat.getString("prenom_chauf"),
						unResultat.getString("tel_chauf"),
						unResultat.getString("libre")
						
						);
				lesChauffeurs.add(unChauffeur);
			}
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de "+requete);
		}
		ModeleChauffeur.uneBDD.seDeconnecter(); 
		return lesChauffeurs ; 
	}
	
	}


