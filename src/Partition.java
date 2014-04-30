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
	//TODO Implémenter le constructeur
	public Partition(String cheminPartXML){
		//Appelle du parser SAX sur le fichier XML Spécifié
		try{
			SAXParserFactory factory = SAXParserFactory.newInstance(); 
			SAXParser saxParser = factory.newSAXParser();
			InputStream xmlStream = Partition.class.getResourceAsStream(cheminPartXML);
			saxParser.parse(xmlStream, new SaxHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Affectation des attributs nom et cheminFichierAudio
		
		
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
}
