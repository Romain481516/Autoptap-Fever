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
		 * Le r�sultat obtenu est l'ensemble des notes contenus dans le fichier XML correspondant
		 * au niveau.
		 * Voir M�thode toString de TripletNote
		 */
		part.accessNote("Facile");
		for (int i = 0; i < part.ListeTripletNote.size(); i++){
			System.out.println(part.ListeTripletNote.get(i).toString());
		}
	}

}
