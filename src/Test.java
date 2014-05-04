import java.io.IOException;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Test de l'affectation des attributs nom et chemin � la partition.
		 * Le r�sultat attendu est nomcheminmusique suivi de nomcheminmusique.
		 */
		Partition part = new Partition("XMLSchema2ex.xml");
		part.getCheminAudio();
		part.getNomMusique();
		/*Validation de la cr�ation des notes.
		 * Le r�sultat attendu est l'ensemble des notes contenus dans le 
		 * fichier XML correspondant au niveau.
		 * Voir M�thode toString de TripletNote
		 */
		part.accessNote("Facile");
		for (int i = 0; i < part.ListeTripletNote.size(); i++){
			System.out.println(part.ListeTripletNote.get(i).toString());
		}
		//Test de deux chargements succ�ssifs
		part.accessNote("Facile");
		
		/*Validation du chargement des notes
		 * Le r�sultat attendu est l'ensemble des scores contenus dans 
		 * le fichier XML correspondant.
		 * Voir m�thode toString de Score.
		 */
		part.accessScore();
		for (int i = 0; i < part.ListeScore.size(); i++){
			System.out.println(part.ListeScore.get(i).toString());
		}
		/*Valisation de l'ajout d'un nouveau score � un partition
		 * Le r�sultat attendu est la cr�ation d'un nouveau fichier XML "NouveauScore.XML"
		 * reprenant l'ancien fichier mais contenant le score suppl�mentaire.
		 * Puis voir l'ensemble des scores contenus dans le nouveau fichier XML.
		 */

			try {
				part.addScore( new Score("Jean","Facile",0));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		part.accessScore();
		for (int i = 0; i < part.ListeScore.size(); i++){
			System.out.println(part.ListeScore.get(i).toString());
		}
		System.out.println(part.ListeScore.size());
	}

}
