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
	
	/**
	 * Méthode permettant d'accéder au nom du joueur stocké
	 * dans l'objet Score
	 * @return
	 */
	public String getJoueur(){
		return joueur.toString();
	}
	/**
	 * Méthode permettant d'accéder au niveau stocké
	 * dans l'objet Score
	 * @return
	 */
	public String getNiveau(){
		return niveau.toString();
	}
	/**
	 * Méthode permettant d'accéder au score (numérique) stocké
	 * dans l'objet Score
	 * @return
	 */
	public String getNbScore(){
		return Integer.toString(nbScore);
	}
	//Test
	public String toString(){
		String toReturn = "Joueur:" + joueur;
		toReturn = toReturn + "\nNiveau: " + niveau +"\n";
		toReturn = toReturn + "Score: " + nbScore +"\n";
		return toReturn;
	}
}
