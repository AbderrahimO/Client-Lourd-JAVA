package controleur;

public class Chauffeur // OBJET CHAUFFEURS 3 DIFFERENTES FACON ECRITE POUR DIFFERENTES UTILISATIONS
{
private int id_chauf;
private String nom_chauf,prenom_chauf,tel_chauf,libre ;


public Chauffeur ()
{
	this.id_chauf = 0;
	this.nom_chauf ="";
	this.prenom_chauf="";
	this.tel_chauf="";
	this.libre=""; 
}

public Chauffeur (String nomchauf, String prenomchauf, String telchauf, String libre)
{
	this.id_chauf = 0;
	this.nom_chauf =nomchauf;
	this.prenom_chauf=prenomchauf;
	this.tel_chauf=telchauf;
	this.libre=libre; 
}



public Chauffeur (int idchauf, String nomchauf, String prenomchauf, String telchauf, String libre)
{
	this.id_chauf = idchauf;
	this.nom_chauf =nomchauf;
	this.prenom_chauf=prenomchauf;
	this.tel_chauf=telchauf;
	this.libre=libre; 
}

public int getId_chauf() {
	return id_chauf;
}

public void setId_chauf(int id_chauf) {
	this.id_chauf = id_chauf;
}

public String getNom_chauf() {
	return nom_chauf;
}

public void setNom_chauf(String nom_chauf) {
	this.nom_chauf = nom_chauf;
}

public String getPrenom_chauf() {
	return prenom_chauf;
}

public void setPrenom_chauf(String prenom_chauf) {
	this.prenom_chauf = prenom_chauf;
}

public String getTel_chauf() {
	return tel_chauf;
}

public void setTel_chauf(String tel_chauf) {
	this.tel_chauf = tel_chauf;
}

public String getLibre() {
	return libre;
}

public void setLibre(String libre) {
	this.libre = libre;
}
}


// GETTERS ET SETTERS : FONCTIONS POUR RECUPERER LES OBJETS DE CETTE PAGE VERS UNE AUTRE


