package controleur;

public class User {
	private String email;
	private int idUser ;
	private String mdp  ; 
	private String nom ; 
	private String prenom ;
	private String droits ; 

	public User ()
	{
		this.email= "";
		this.idUser=0;
		this.mdp="";
		this.nom="";
		this.prenom = "" ;
		this.droits="";
	}
	public User (int idUser, String email, String mdp,String nom,String prenom, String droits)
	{
		this.email= email;
		this.idUser=idUser;
		this.mdp= mdp;
		this.nom= nom;
		this.prenom= prenom;
		this.droits = droits ;
	}
	public User (String email, String mdp,String nom,String prenom, String droits)
	{
		this.email= email;
		this.idUser=0;
		this.mdp= mdp;
		this.nom= nom;
		this.prenom= prenom ;
		this.droits = droits ;
	}
	
	
	public String getDroits() {
		return droits;
	}
	public void setDroits(String droits) {
		this.droits = droits;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}