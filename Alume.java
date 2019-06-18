package controleur;

import modele.BDD;
import modele.Modele;
import modele.ModeleChauffeur;
import modele.ModeleRdv;
import modele.ModeleUser;
import modele.ModeleClient;

import javax.jws.WebParam.Mode;
import javax.swing.JOptionPane;

import vue.VueClient;
import vue.VueConnexion;
import vue.VueAdministrateur;
import vue.VueUser;

public class Alume 
{
	private static VueConnexion uneVueConnexion ;
	private static VueAdministrateur uneVueAdministrateur; 
	private static VueUser uneVueUser ;
	private static VueClient uneVueClient ;
	
	
	public static void setVisible (boolean action)
	{
		uneVueConnexion.setVisible(action);
		
	}

	public static void main(String[] args) {
	uneVueConnexion = new VueConnexion();
	}

	

	public static void verifConnexion(String email, String mdp) 
	
	{
		if (email.equals("")|| mdp.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Veuillez remplir vos identifiants !", "Erreur", JOptionPane.ERROR_MESSAGE);
		}else 
		{
			//appel du modeleUser
			User unUser = ModeleUser.selectWhereUser(email,mdp);
			if (unUser == null)
			{
				JOptionPane.showMessageDialog(null, "Veuillez vérifier vos identifiants !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}else {
				
				if (unUser.getDroits().equalsIgnoreCase("admin"))
				{
					JOptionPane.showMessageDialog(null, "Vous etes connectés!"+ unUser.getNom()+ " " +unUser.getPrenom(), 
							"Connexion", JOptionPane.INFORMATION_MESSAGE);
				
					uneVueAdministrateur = new VueAdministrateur(unUser);
					uneVueConnexion.dispose();
				}else if (unUser.getDroits().equalsIgnoreCase("autre"))
				{
					JOptionPane.showMessageDialog(null, "Vous etes connectés!"+ unUser.getNom()+ " " +unUser.getPrenom(), 
							"Connexion", JOptionPane.INFORMATION_MESSAGE);
				
				uneVueClient = new VueClient(unUser);
					uneVueConnexion.dispose();
				}
				else if (unUser.getDroits().equalsIgnoreCase("user"))
						{
					JOptionPane.showMessageDialog(null, "Vous etes connectés!"+ unUser.getNom()+ " " +unUser.getPrenom(), 
							"Connexion", JOptionPane.INFORMATION_MESSAGE);
				
					uneVueUser = new VueUser(unUser);
					uneVueConnexion.dispose();
				
				} 
			}
		}
		
	}
		


	public static void insertArticle(Article unArticle) 
	{
		Modele.insertArticle(unArticle);
		
	}

	public static Article selectWhereArticle(Article unArticle) {
		
		return Modele.selectWhereA(unArticle);
	}

	public static void insertClients(Client unClients) {
		
		ModeleClient.insertClient(unClients);
		
	}

	public static Client selectWhereClients(Client unClients) {
		
		return ModeleClient.selectWhere(unClients);
	}
	
	
	public static void insertChauffeur(Chauffeur unChauffeur) {
		
		ModeleChauffeur.insertChauffeur(unChauffeur);
		
	}

	public static Chauffeur selectWhereChauffeur(Chauffeur unChauffeur) {
		
		return ModeleChauffeur.selectWhereChauffeur(unChauffeur);
	}
	
	
	public static Rdv selectWhereRdv(Rdv unRdv){
		return ModeleRdv.selectWhereRdv(unRdv);
	}
	
	public static void insertRdv(Rdv unRdv) {

		ModeleRdv.insertRdv(unRdv);
		
}
	
	
	
	

	

} 
