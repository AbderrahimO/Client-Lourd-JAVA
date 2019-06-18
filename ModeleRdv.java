package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import controleur.Rdv;

public class ModeleRdv 
{
	private static BDD uneBDD = new BDD("localhost", "alume", "root", "");
	
	public static void insertRdv (Rdv unRdv)
	{
		String requete = "insert into rdv_cli values(null, '" + unRdv.getNom_rdv() 
	              + "','" +unRdv.getPrenom_rdv() +"','" +unRdv.getEmail_rdv() +
	              "','" + unRdv.getDate_rdv()+"','"+unRdv.getHeure_rdv()+"','"+unRdv.getMotif_rdv()+"');";
	    ModeleRdv.uneBDD.seConnecter();
	    try {
	        Statement unStat = ModeleRdv.uneBDD.getMaConnexion().createStatement();
	        unStat.execute(requete);
	        } catch (SQLException exp) {
	        System.out.println("Erreur d'execution de la requete : " +requete);
	    }
	    ModeleRdv.uneBDD.seDeconnecter();
	}
	public static void updateRdv (Rdv unRdv){
		String requete = "update rdv_cli set nom_rdv =('" + unRdv.getNom_rdv() 
	              + "', prenom_rdv = " +unRdv.getPrenom_rdv() +","
	              		+ " email_rdv = " +unRdv.getEmail_rdv() +
	              ", date_rdv = " + unRdv.getDate_rdv()+",heure_rdv="+unRdv.getHeure_rdv()+
	              		",motif_rdv='"+unRdv.getMotif_rdv()+
	        "'where id_rdv = "+unRdv.getId_rdv()+"); ";
	    ModeleRdv.uneBDD.seConnecter();
	    try {
	        Statement unStat = ModeleRdv.uneBDD.getMaConnexion().createStatement();
	        unStat.execute(requete);
	        }
	    catch (SQLException exp) {
	        System.out.println("Erreur d'execution de la requete : " +requete);
	    }
	}
	
	public static void deleteRdv(int idRdv) {
		String requete = "delete from rdv_cli" + "where id_rdv ="+idRdv+";";
		ModeleRdv.uneBDD.seConnecter();
		try
		{
			Statement unStat = ModeleRdv.uneBDD.getMaConnexion().createStatement();
			unStat.execute(requete);
			
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur execution requete:"+ requete);
		}
		ModeleRdv.uneBDD.seDeconnecter();
		
	}
	
	public static Rdv selectWhereRdv(Rdv unRdv)
    {
        String requete = " select * from rdv_cli where nom_rdv ='" +unRdv.getNom_rdv()+"' "
        		+ "and prenom_rdv = '"+unRdv.getPrenom_rdv()+"' "	+ "and email_rdv ='"+ unRdv.getEmail_rdv()
        		+"' and date_rdv = '" +unRdv.getDate_rdv() +"'"+"and heure_rdv='"+unRdv.getHeure_rdv()+"' "
        				+ " "+" and motif_rdv='"+unRdv.getMotif_rdv()+"';" ;
        Rdv unRdv1 = null;
      
        ModeleRdv.uneBDD.seConnecter();
        try
        {
            Statement unStat = ModeleRdv.uneBDD.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            if (unResultat.next())
            {
                unRdv = new Rdv(
                        unResultat.getInt("id_rdv"),
                        unResultat.getString("nom_rdv"),
                        unResultat.getString("prenom_rdv"),
                        unResultat.getString("email_rdv"),
                        unResultat.getString("date_rdv"),
                        unResultat.getString("heure_rdv"),
                        unResultat.getString("motif_rdv")
                        );
            }
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur d'execution de la requete : "+requete);
        }
        ModeleRdv.uneBDD.seDeconnecter();
        return unRdv;
    }
	public static ArrayList<Rdv> selectAllRdv(){
		ArrayList<Rdv> lesRdv = new ArrayList<Rdv>();
		String requete = "select * from rdv_cli;";
		ModeleRdv.uneBDD.seConnecter();
		Rdv unRdv;
		try
		{
			Statement unStat = ModeleRdv.uneBDD.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			while (unResultat.next())
			{
				unRdv = new Rdv(
						unResultat.getInt("id_rdv"),
						unResultat.getString("nom_rdv"),
						unResultat.getString("prenom_rdv"),
						unResultat.getString("email_rdv"),
						unResultat.getString("date_rdv"),
						unResultat.getString("heure_rdv"),
						unResultat.getString("motif_rdv")
						
						
						);
				lesRdv.add(unRdv);
			}
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'execution de "+requete);
		}
		ModeleRdv.uneBDD.seDeconnecter(); 
		return lesRdv ; 
	}
	
	}



