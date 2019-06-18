package controleur;

public class Client // OBJET CLIENT 3 DIFFERENTES FACON ECRITE POUR DIFFERENTES UTILISATIONS 
{
	private int idclient; 
	private String nom,prenom,mdp,mail,adresse,cpcli,telcli ; 
	
	public Client ()
	{
		this.idclient = 0;
		this.mail = "";
		this.mdp = "";
		this.nom = ""; 
		this.prenom = "";
		this.telcli = "";
		this.adresse ="";
		this.cpcli = "";
		
	}
	
	public Client (int idclient, String mail, String mdp, String nom, String prenom, String telcli, String adresse, String cpcli)
	{
		this.idclient = idclient; 
		this.mail = mail;
		this.mdp = mdp;
		this.nom = nom; 
		this.prenom = prenom;
		this.telcli = telcli;
		this.adresse = adresse;
		this.cpcli = cpcli;
		
		
		
		
	}
	public Client (String mail, String mdp, String nom, String prenom, String telcli, String adresse, String cpcli)
	{
		this.idclient = 0; 
		this.mail = mail;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.telcli = telcli;
		this.adresse = adresse;
		this.cpcli = cpcli;
		
		
		

		// GETTERS ET SETTERS : FONCTIONS POUR RECUPERER LES OBJETS DE CETTE PAGE VERS UNE AUTRE
	}
	
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCpcli() {
		return cpcli;
	}
	public String getTelcli() {
		return telcli;
	}
	
	public void setCpcli(String cpcli) {
		this.cpcli = cpcli;
	}
	public void setTelcli(String telcli) {
		this.telcli = telcli;
	}
}
