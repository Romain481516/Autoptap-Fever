public class TripletNote {

	//Attribut de la classe TripletNote
	boolean[] tripletNote = new boolean[3];
	int duree;
	int debut;
	
	//Constructeur
	public TripletNote(boolean[] triplet,int deb,int dur){
		super();
		tripletNote = triplet;
		duree = dur;
		debut = deb;
	}
	/*Les setters ne servent plus car on construit directement l'objet
	 * avec ces attributs (voir Constructeur)
	 *
	/*
	 * //Methode qui attribut une valeur (true ou false) au touche.
	public void setTouche(){
	}
	public void setDebut(){
	}
	public void setDuree(){
	}
	*/
	//TODO choisir ce que renvoie la m�thode.
	public void getTouche(){
	}
	//TODO choisir ce que renvoie la m�thode.
	public void getDuree(){
	}
	//TODO choisir ce que renvoie la m�thode.
	public void getDebut(){
	}
	//Pour les tests
	public String toString(){
		String toReturn = "Note:"+"\n" + "Touches: ";
		for(int i = 0; i<3; i++){
			toReturn = toReturn + tripletNote[i]+ " ";	
		}
		toReturn = toReturn + "\nDebut: " + debut +"\n";
		toReturn = toReturn + "Duree: " + duree +"\n";
		return toReturn;
		
	}
}
