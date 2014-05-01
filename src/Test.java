public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Test de l'affectation des attributs nom et chemin à la partition.
		 * Le résultat attendu est nomcheminmusique suivi de nomcheminmusique deux fois.
		 */
		Partition part = new Partition("XMLSchema2ex.xml");
		//Vérification avec les get
		part.getCheminAudio();
		part.getNomMusique();
		part.accessNote("Facile");
		/*for (TripletNote note : part.ListeTripletNote){
			note.toString();
		}*/
		
	}

}
