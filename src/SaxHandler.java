import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
	//Attribut d�finissant l'action a effectuer sur le fichier XML
	//Le premier bool�en correspond � la cr�ation d'une partition
	//Le deuxi�me a la demande de lecture des notes
	//Le troisi�me a la consultation des scores
	boolean bCreation = false;
	boolean bLectureNote = false;
	boolean bConsultationScore = false;
	String niveau = "";
	//Bool�en de position
	boolean bChemin = false;
	boolean bNom = false;
	boolean bNote = false;
	boolean bNiveau = false;
	boolean bTouche = false;
	boolean bDuree = false;
	boolean bDebut = false;
	//Attribut
	Partition part;
	//Attribut li� � la cr�ation d'une note
	boolean[] tripletNote = new boolean[3];
	int debut;
	int duree;

	/**
	 * Constructeur du gestionnaire Sax
	 * @param creation
	 * @param lecture
	 * @param consultationScore
	 * @param partition
	 */
	public SaxHandler(boolean creation, boolean lecture, boolean consultationScore, Partition partition){
		super();
		bCreation = creation;
		bLectureNote = lecture;
		bConsultationScore = consultationScore;
		part = partition; 
	}
	/**
	 * Surcharge du constructeur permettant de savoir quelle niveau charger.
	 * @param creation
	 * @param lecture
	 * @param consultationScore
	 * @param partition
	 * @param niv
	 */
	public SaxHandler(boolean creation, boolean lecture, boolean consultationScore, Partition partition, String niv){
		super();
		bCreation = creation;
		bLectureNote = lecture;
		bConsultationScore = consultationScore;
		part = partition; 
		niveau = niv;
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		//Rep�re la postion dans le fichier XML
		if(qName.equals("CHEMIN")){
			bChemin = true;
		}
		if(qName.equals("NOM")){
			bNom = true;
		}
		if(qName.equals("PARTITION")){
			/*L'attribut bNiveau passe � l'�tat vrai uniquement lorsque celui
			 * correspond au niveau demand�.
			 */
			if (attributes.getValue(0).equals(niveau)){
				bNiveau = true;
				System.out.println(bNiveau);
			}
		}
		/*bNiveau est important ici. Sinon on va demander la cr�ation de
		 * note � chaque fois que l'on passe sur la balise fermante Note.
		 */
		if(qName.equals("Note")&& bNiveau){
			bNote = true;
		}
		if(qName.equals("touche")&& bNiveau){ //bNiveau optionnel
			bTouche = true;
		}
		if(qName.equals("debut")&& bNiveau){
			bDebut = true;
		}
		if(qName.equals("duree")&& bNiveau){
			bDuree = true;
		}
	}
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("CHEMIN")){
			bChemin = false;
		}
		if(qName.equals("NOM")){
			bNom = false;
		}
		if(qName.equals("PARTITION")){
			bNiveau = false;
		}

		if(qName.equals("Note")&& bNote){ //TODO V�rifier l'utilit� (bNote) !
			bNote = false;
			//Ajout de la note � la partition.
			part.ListeTripletNote.add(new TripletNote(tripletNote,debut,duree));
			System.out.println("Une note a �t� ajout�e !");
		}
		if(qName.equals("touche")){
			bTouche = false;
		}
		if(qName.equals("debut")){
			bDebut = false;
		}
		if(qName.equals("duree")){
			bDuree = false;
		}

	}
	public void characters(char[] chars, int start, int length) throws SAXException {
		//System.out.println(new String(chars, start, length)); //Affichage de le texte
		if (bCreation){
			if(bChemin){
				part.setCheminAudio(new String(chars, start, length));
				//System.out.println(new String(chars, start, length));//Retour Test
			}
			if(bNom){
				part.setNomMusique(new String(chars, start, length));
				//System.out.println(new String(chars, start, length));//Retour Test
			}
		}
		else if (bLectureNote){
			if (bNiveau){
				System.out.println("Acc�s aux notes contenus dans la partition.");
				if(bNote){
					String aDecouper = new String(chars,start,length);
					String[] Decoupe= aDecouper.split(" ");
					for(int i = 1; i==3; i++){
						tripletNote[i]=Boolean.parseBoolean(Decoupe[i]);	
					}
				}
				if(bDebut){
					debut = Integer.parseInt(new String(chars,start,length));
				}
				if(bDuree){
					duree = Integer.parseInt(new String(chars,start,length));
				}
			}
		}
		else if (bConsultationScore){
			System.out.println("Acc�s � la liste de score");
		}
		else System.out.println("Erreur pas de code op�ration.");
	}
}

