public class Score {
	//Attribut de la classe
	String joueur;
	String niveau;
	int nbScore;

	//Constructeur
	//TODO Implementer le constructeur Score
	public Score(String nom,String niv, int nb){
		joueur = nom;
		niveau = niv;
		nbScore = nb;
	}
	/*/ //TODO Utile ?
	//Permet d'ajouter un joueur � une partition
	public void addJoueur(){

	}
	// choisir attribut retourn� - Voir avec le Parser Sax (param�tre)
	public void setNiveau(){

	}
	// choisir attribut retourn� - Voir avec le Parser Sax (param�tre)
	public void setNbScore(){

	}*/
	
	//TODO Choisir le type d'attribut � retourner + Impl�menter
	public void getJoueur(){

	}
	//TODO Choisir le type d'attribut � retourner + Impl�menter
	public void getNiveau(){

	}
	//TODO Choisir le type d'attribut � retourner + Impl�menter
	public void getNbScore(){

	}
	//Test
	public String toString(){
		String toReturn = "Joueur:" + joueur;
		toReturn = toReturn + "\nNiveau: " + niveau +"\n";
		toReturn = toReturn + "Score: " + nbScore +"\n";
		return toReturn;
	}
}
