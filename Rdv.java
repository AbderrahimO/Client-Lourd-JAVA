package controleur;

public class Rdv { // OBJET ARTICLE 3 DIFFERENTES FACON ECRITE POUR DIFFERENTES UTILISATIONS

	private int id_rdv;
	private String nom_rdv,prenom_rdv,email_rdv,
	date_rdv,heure_rdv,motif_rdv;
	
	public Rdv() 
	{
		this.id_rdv =0; 
		this.nom_rdv="";
		this.prenom_rdv="";
		this.email_rdv="";
		this.date_rdv="";
		this.heure_rdv="";
		this.motif_rdv="";
	}
	public Rdv (int id_rdv, String nom_rdv, String prenom_rdv,
			String email_rdv,String date_rdv,String heure_rdv,String motif_rdv)
	{
		this.id_rdv = id_rdv ; 
		this.nom_rdv = nom_rdv;
		this.prenom_rdv = prenom_rdv;
		this.email_rdv=email_rdv;
		this.date_rdv = date_rdv;
		this.heure_rdv=heure_rdv;
		this.motif_rdv=motif_rdv ;
	}
	public Rdv (String nom_rdv, String prenom_rdv,String email_rdv,String date_rdv,String heure_rdv,String motif_rdv)
	{
		this.id_rdv = 0; 
		this.nom_rdv = nom_rdv;
		this.prenom_rdv = prenom_rdv;
		this.email_rdv = email_rdv;
		this.date_rdv = date_rdv;
		this.heure_rdv = heure_rdv;
		this.motif_rdv = motif_rdv;
		
	}
	public int getId_rdv() {
		return id_rdv;
	}
	public void setId_rdv(int id_rdv) {
		this.id_rdv = id_rdv;
	}
	public String getNom_rdv() {
		return nom_rdv;
	}
	public void setNom_rdv(String nom_rdv) {
		this.nom_rdv = nom_rdv;
	}
	public String getPrenom_rdv() {
		return prenom_rdv;
	}
	public void setPrenom_rdv(String prenom_rdv) {
		this.prenom_rdv = prenom_rdv;
	}
	public String getEmail_rdv() {
		return email_rdv;
	}
	public void setEmail_rdv(String email_rdv) {
		this.email_rdv = email_rdv;
	}
	public String getDate_rdv() {
		return date_rdv;
	}
	public void setDate_rdv(String date_rdv) {
		this.date_rdv = date_rdv;
	}
	public String getHeure_rdv() {
		return heure_rdv;
	}
	public void setHeure_rdv(String heure_rdv) {
		this.heure_rdv = heure_rdv;
	}
	public String getMotif_rdv() {
		return motif_rdv;
	}
	public void setMotif_rdv(String motif_rdv) {
		this.motif_rdv = motif_rdv;
	}
	
}

	

	