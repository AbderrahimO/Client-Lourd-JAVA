package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.User;

public class ModeleUser 
{
	private static BDD uneBdd = new BDD("localhost", "alume", "root", "");
	
	public static void insertUser (User unUser)
	{
		String requete = "insert into user (email," 
	              + "mdp, nom, prenom) values('" + unUser.getEmail() 
	              + "'," +unUser.getMdp() +"," +unUser.getNom() +
	              ",'" + unUser.getPrenom()+"');";
	    ModeleUser.uneBdd.seConnecter();
	    try {
	        Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
	        unStat.execute(requete);
	        } catch (SQLException exp) {
	        System.out.println("Erreur d'execution de la requete : " +requete);
	    }
	    ModeleUser.uneBdd.seDeconnecter();
	}
	public static void updateUser (User unUser){
		String requete = "update User set email ='" + unUser.getEmail() 
	              + "', mdp = " +unUser.getMdp() +", nom = " +unUser.getNom() +
	              ", prenom = '" + unUser.getPrenom()+"' where iduser = "+unUser.getIdUser()+";";
	    ModeleUser.uneBdd.seConnecter();
	    try {
	        Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
	        unStat.execute(requete);
	        }
	    catch (SQLException exp) {
	        System.out.println("Erreur d'execution de la requete : " +requete);
	    }
	}
	
	public static void deleteUser(int idUser) {
		String requete = "delete from user" + "where iduser ="+idUser+";";
		ModeleUser.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur execution requete:"+ requete);
		}
		ModeleUser.uneBdd.seDeconnecter();
		
	}
	
	public static User selectWhereUser(String email, String mdp)
    {
        String requete = " select * from user where email ='" + email +"' and mdp = '"+mdp+"' ;" ; 
        User unUser = null;
        ModeleUser.uneBdd.seConnecter();
        try
        {
            Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            if (unResultat.next())
            {
                unUser = new User(
                        unResultat.getInt("iduser"),
                        unResultat.getString("email"),
                        unResultat.getString("mdp"),
                        unResultat.getString("nom"),
                        unResultat.getString("prenom"),
                        unResultat.getString("droits")
                        );
            }
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution de la requete : "+requete);
        }
        ModeleUser.uneBdd.seDeconnecter();
        return unUser;
    }
	public static ArrayList<User> selectAllUsers(){
		ArrayList<User> lesUsers = new ArrayList<User>();
		String requete = "select * from user;";
		ModeleUser.uneBdd.seConnecter();
		User unUser;
		try
		{
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			while (unResultat.next())
			{
				unUser = new User(
						unResultat.getInt("iduser"),
						unResultat.getString("email"),
						unResultat.getString("mdp"),
						unResultat.getString("nom"),
						unResultat.getString("prenom"), 
						unResultat.getString("droits")
						);
				lesUsers.add(unUser);
			}
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de "+requete);
		}
		ModeleUser.uneBdd.seDeconnecter(); 
		return lesUsers ; 
	}
	
	}

