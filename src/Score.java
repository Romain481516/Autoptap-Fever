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
	
	/**
	 * M�thode permettant d'acc�der au nom du joueur stock�
	 * dans l'objet Score
	 * @return
	 */
	public String getJoueur(){
		return joueur.toString();
	}
	/**
	 * M�thode permettant d'acc�der au niveau stock�
	 * dans l'objet Score
	 * @return
	 */
	public String getNiveau(){
		return niveau.toString();
	}
	/**
	 * M�thode permettant d'acc�der au score (num�rique) stock�
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
