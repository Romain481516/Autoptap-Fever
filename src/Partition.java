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
	//TODO Impl�menter le constructeur
	public Partition(String cheminPartXML){
		//Appelle du parser SAX sur le fichier XML Sp�cifi�
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
}
