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
	//Permet d'ajouter un joueur à une partition
	public void addJoueur(){

	}
	// choisir attribut retourné - Voir avec le Parser Sax (paramètre)
	public void setNiveau(){

	}
	// choisir attribut retourné - Voir avec le Parser Sax (paramètre)
	public void setNbScore(){

	}*/
	
	//TODO Choisir le type d'attribut à retourner + Implémenter
	public void getJoueur(){

	}
	//TODO Choisir le type d'attribut à retourner + Implémenter
	public void getNiveau(){

	}
	//TODO Choisir le type d'attribut à retourner + Implémenter
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
