import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Partition {
	
	//Attribut de la classe
	//TODO Supprimer le fichier exemple
	//String cheminPartitionXML = "XMLSchema2ex.xml";
	String cheminFichierAudio;
	String nom;
	//TODO voir pour le tableau ? Liste Chainée ? TableauNote
	TripletNote[] tableauNote;
	//TODO voir pour le tableau ? Liste Chainée ? TableauScore
	Score[] tableauScore;
	
	//Constructeur
	public Partition(String cheminPartXML){
		//Appelle du parser SAX sur le fichier XML Spécifié
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance(); 
			SAXParser saxParser = factory.newSAXParser();
			InputStream xmlStream = Partition.class.getResourceAsStream(cheminPartXML);
			//Affectation des attributs nom et cheminFichierAudio
			saxParser.parse(xmlStream, new SaxHandler(true,false,false,this));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	//Permet d'accéder à toutes les notes de la partition
	//TODO Définir le type retourner + Implémentation
	public void accessNote(){

	}
	//Permet d'accéder à tous les scores de la partition
	//TODO Définir le type retourner + Implémentation
	public void accessScore(){

	}
	//Permet d'ajouter un score
	//TODO Définir le type retourner + Implémentation
	public void addScore(){

	}
	/** Méthode permettant de définir le nom de la musique.
	 * @param String - Le chemin du fichier audio
	 */
	public void setCheminAudio(String chemin){
		cheminFichierAudio = chemin;
	}
	/** Méthode permettant de définir le nom de la musique.
	 * @param String - Le nom du fichier audio
	 */
	public void setNomMusique(String name){
		nom = name;
	}
	/** Méthode permettant d'accéder le nom de la musique.
	 */
	public void getCheminAudio(){
		System.out.println(cheminFichierAudio);
	}
	/** Méthode permettant d'accéder au nom de la musique.
	 */
	public void getNomMusique(){
		System.out.println(nom);
	}
}
