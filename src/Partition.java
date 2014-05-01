import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Partition {
	
	//Attribut de la classe
	String cheminPartitionXML;
	String cheminFichierAudio;
	String nom;
	List<TripletNote> ListeTripletNote;	
	List<Score> ListeScore;
	
	/**Constructeur
	 * @param cheminPartXML
	 */
	public Partition(String cheminPartXML){
		cheminPartitionXML = cheminPartXML;
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
	public void accessNote(String niveau){
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance(); 
			SAXParser saxParser = factory.newSAXParser();
			InputStream xmlStream = Partition.class.getResourceAsStream(cheminPartitionXML);
			//Affectation des attributs nom et cheminFichierAudio
			saxParser.parse(xmlStream, new SaxHandler(false,true,false,this,niveau));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Permet d'accéder à tous les scores de la partition
	//TODO Définir le type retourner + Implémentation
	public void accessScore(){

	}
	//Permet d'ajouter un score
	//TODO Définir le type retourner + Implémentation - Voir JDOM
	public void addScore(){

	}
	/**Méthode permettant de définir le nom de la musique.
	 * @param chemin
	 */
	public void setCheminAudio(String chemin){
		cheminFichierAudio = chemin;
	}
	/** Méthode permettant de définir le nom de la musique.
	 * @param name
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
