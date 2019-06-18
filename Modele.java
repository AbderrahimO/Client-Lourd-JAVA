package modele;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Article;
import controleur.Chauffeur;

public class Modele {
	static BDD uneBdd = new BDD("localhost", "alume", "root", "");
	
	public static ArrayList<Article> selectAllArticle ()
	{
		ArrayList<Article> lesArticles = new ArrayList<Article>();
		
		String requete = "select code_art, nom_art, prix_art, qte from article ;" ;
		
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next())
			{
				String code_art = unRes.getString("code_art");
				String noma = unRes.getString("nom_art");
				String prixa = unRes.getString("prix_art");
				String qte = unRes.getString("qte");
				Article unArticle = new Article(code_art, noma, prixa, qte); 
				lesArticles.add(unArticle);
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete );
		}
		return lesArticles; 
	}
	
	public static void insertArticle (Article unArticle)
	{
		String requete = "insert into article(code_art,nom_art,prix_art,qte) values "
				+ "('" + unArticle.getCode_art() + "', '" + unArticle.getNoma()+"' ,  "
						+ "'" + unArticle.getPrixa() +"', "
				+ "'" + unArticle.getQte() + "');";
		System.out.println(requete);
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
	
	public static void updateArticle (Article unArticle)
	{
		String requete = "update article set code_art ='"+unArticle.getCode_art()
					+ "', nom_art ='"+unArticle.getNoma() 
					+ "', prix_art = '"+unArticle.getPrixa()
					+ "', qte = '"+unArticle.getQte()
					+ "' where code_art = '" + unArticle.getCode_art()
					+ "'"
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
	
	public static void deleteArticle (Article unArticle)
	{
		String requete = "delete from article where code_art ="
					+ "'" + unArticle.getCode_art() +"';";
		
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
	public static Article selectWhereA (Article unArticle)
	{
		String requete = "select * from article where "
				+ " code_art = '" +unArticle.getCode_art()
				+ "' and  nom_art = '"+unArticle.getNoma()
				+ "' and prix_art = '"+unArticle.getPrixa()
				+ "' and qte = '"+unArticle.getQte()
				+"' ; ";
		Article lArticle = null;
		
		try
		{
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				String code_art = unRes.getString("code_art");
				lArticle = new Article(code_art, unArticle.getNoma(),  unArticle.getPrixa(), unArticle.getQte());
			}
			unStat.close();
			unRes.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur : " + requete);
		}
		return lArticle;
	}

	
	}

