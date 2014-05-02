import java.io.InputStream;
import java.util.ArrayList;
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
	String niveau ="";

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
	/**Permet de charger dans l'objet toutes les notes de la partition.
	 * @param niveau
	 */
	public void accessNote(String niveau){
		if(!this.niveau.equals(niveau)){
			this.niveau = niveau;
			/*TODO Question de l'instanciation. (idem avec accessScore) 
			 * Quand ? 
			 *Va-t-il y avoir une surcharge de la mémoire ?
			 *A chaque changement de niveau, création d'une nouvelle ArrayList
			 *Ramasse-miettes ?
			 *Comment éviter cela ? 
			 */
			
			ListeTripletNote = new ArrayList<TripletNote>();
			try{
				SAXParserFactory factory = SAXParserFactory.newInstance(); 
				SAXParser saxParser = factory.newSAXParser();
				InputStream xmlStream = Partition.class.getResourceAsStream(cheminPartitionXML);
				saxParser.parse(xmlStream, new SaxHandler(false,true,false,this,niveau));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//else System.out.println("Le niveau est déjà en mémoire"); - Test
	}
	//Permet d'accéder à tous les scores de la partition
	//TODO Définir le type retourner + Implémentation
	public void accessScore(){
		ListeScore = new ArrayList<Score>();
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance(); 
			SAXParser saxParser = factory.newSAXParser();
			InputStream xmlStream = Partition.class.getResourceAsStream(cheminPartitionXML);
			saxParser.parse(xmlStream, new SaxHandler(false,false,true,this));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Permet d'ajouter un score
	//TODO Définir le type retourner + Implémentation - Voir JDOM
	public void addScore(){

	}
	/**Méthode permettant de définir le nom de la musique.
	 * Utiliser par SaxHandler
	 * @param chemin
	 */
	public void setCheminAudio(String chemin){
		cheminFichierAudio = chemin;
	}
	/** Méthode permettant de définir le nom de la musique.
	 * Utiliser par SaxHandler
	 * @param name
	 */
	public void setNomMusique(String name){
		nom = name;
	}
	//TODO Voir utiliter autre que pour les tests
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
