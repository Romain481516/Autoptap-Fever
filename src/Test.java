public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Test de l'affectation des attributs nom et chemin � la partition.
		 * Le r�sultat attendu est nomcheminmusique suivi de nomcheminmusique.
		 */
		Partition part = new Partition("XMLSchema2ex.xml");
		//V�rification avec les get
		part.getCheminAudio();
		part.getNomMusique();
		part.accessNote("Facile");
		for (int i = 0; i < part.ListeTripletNote.size(); i++){
			System.out.println(part.ListeTripletNote.get(i).toString());
		}
	}

}
