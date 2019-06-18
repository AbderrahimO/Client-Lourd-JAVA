package controleur;

public class Article { // OBJET ARTICLE 3 DIFFERENTES FACON ECRITE POUR DIFFERENTES UTILISATIONS

	
	private String code_art,noma,prixa,qte;
	
	public Article() 
	{
		this.code_art =""; 
		this.noma="";
		this.prixa="";
		this.qte="";
	}
	public Article (String code_art, String noma, String prixa, String qte)
	{
		this.code_art = code_art; 
		this.noma = noma;
		this.prixa = prixa;
		this.qte=qte;
	}
	public Article (String noma, String prixa,String qte)
	{
		this.code_art = ""; 
		this.noma = noma;
		this.prixa = prixa;
		this.qte = qte;
		
	}

	

	public String getCode_art() {
		return code_art;
	}
	public void setCode_art(String code_art) {
		this.code_art = code_art;
	}
	public String getNoma() {
		return noma;
	}

	public void setNoma(String noma) {
		this.noma = noma;
	}

	
	public String getPrixa() {
		return prixa;
	}

	public void setPrixa(String prixa) {
		this.prixa = prixa;
	}
	public String getQte() {
		return qte;
	}
	public void setQte(String qte) {
		this.qte = qte;
	}

	
	
}

