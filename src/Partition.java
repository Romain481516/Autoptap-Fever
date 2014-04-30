import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Partition {
	
	//Attribut de la classe
	//TODO Supprimer le fichier exemple
	//String cheminPartitionXML = "XMLSchema2ex.xml";
	String cheminFichierAudio;
	String nom;
	//TODO voir pour le tableau ? Liste Chain�e ? TableauNote
	TripletNote[] tableauNote;
	//TODO voir pour le tableau ? Liste Chain�e ? TableauScore
	Score[] tableauScore;
	
	//Constructeur
	public Partition(String cheminPartXML){
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
	//Permet d'acc�der � toutes les notes de la partition
	//TODO D�finir le type retourner + Impl�mentation
	public void accessNote(){

	}
	//Permet d'acc�der � tous les scores de la partition
	//TODO D�finir le type retourner + Impl�mentation
	public void accessScore(){

	}
	//Permet d'ajouter un score
	//TODO D�finir le type retourner + Impl�mentation
	public void addScore(){

	}
	/** M�thode permettant de d�finir le nom de la musique.
	 * @param String - Le chemin du fichier audio
	 */
	public void setCheminAudio(String chemin){
		cheminFichierAudio = chemin;
	}
	/** M�thode permettant de d�finir le nom de la musique.
	 * @param String - Le nom du fichier audio
	 */
	public void setNomMusique(String name){
		nom = name;
	}
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
