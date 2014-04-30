import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
	//Attribut définissant l'action a effectuer sur le fichier XML
	//Le premier booléen correspond à la création d'une partition
	//Le deuxième a la demande de lecture des notes
	//Le troisième a la consultation des scores
	boolean bCreation;
	boolean bLectureNote;
	boolean bConsultationScore;
	//Booléen de position
	boolean bChemin;
	boolean bNom;
	//Attribut
	Partition part;

	public SaxHandler(boolean creation, boolean lecture, boolean consultationScore, Partition partition){
		super();
		bCreation = creation;
		bLectureNote = lecture;
		bConsultationScore = consultationScore;
		part = partition; 
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		//Repère la postion dans le fichier XML
		if(qName.equals("CHEMIN")){
			bChemin = true;
		}
		if(qName.equals("NOM")){
			bNom = true;
		}
	}
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("CHEMIN")){
			bChemin = false;
		}
		if(qName.equals("NOM")){
			bNom = false;
		}

	}
	public void characters(char[] chars, int start, int length) throws SAXException {
		//System.out.println(new String(chars, start, length)); //Affichage de le texte
		if (bCreation){
			if(bChemin){
				System.out.println("Création de la partition.");
				part.setCheminAudio(new String(chars, start, length));
				System.out.println(new String(chars, start, length));
			}
			if(bNom){
				part.setNomMusique(new String(chars, start, length));
				System.out.println(new String(chars, start, length));
			}
		}
		else if (bLectureNote){
			System.out.println("Accès aux notes contenus dans la partition.");
		}
		else if (bConsultationScore){
			System.out.println("Accès à la liste de score");
		}
		else System.out.println("Erreur pas de code opération.");
	}
}

