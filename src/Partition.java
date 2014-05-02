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
		//Appelle du parser SAX sur le fichier XML Sp�cifi�
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
			 *Va-t-il y avoir une surcharge de la m�moire ?
			 *A chaque changement de niveau, cr�ation d'une nouvelle ArrayList
			 *Ramasse-miettes ?
			 *Comment �viter cela ? 
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
		}//else System.out.println("Le niveau est d�j� en m�moire"); - Test
	}
	//Permet d'acc�der � tous les scores de la partition
	//TODO D�finir le type retourner + Impl�mentation
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
	//TODO D�finir le type retourner + Impl�mentation - Voir JDOM
	public void addScore(){

	}
	/**M�thode permettant de d�finir le nom de la musique.
	 * Utiliser par SaxHandler
	 * @param chemin
	 */
	public void setCheminAudio(String chemin){
		cheminFichierAudio = chemin;
	}
	/** M�thode permettant de d�finir le nom de la musique.
	 * Utiliser par SaxHandler
	 * @param name
	 */
	public void setNomMusique(String name){
		nom = name;
	}
	//TODO Voir utiliter autre que pour les tests
	/** M�thode permettant d'acc�der le nom de la musique.
	 */
	public void getCheminAudio(){
		System.out.println(cheminFichierAudio);
	}
	/** M�thode permettant d'acc�der au nom de la musique.
	 */
	public void getNomMusique(){
		System.out.println(nom);
	}
}
