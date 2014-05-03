import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
public class Partition {

	//Attribut de la classe
	String cheminPartitionXML;
	String cheminFichierAudio;
	String nom;
	List<TripletNote> ListeTripletNote;	
	List<Score> ListeScore= new ArrayList<Score>();
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
	//TODO M�thode � surcharger ? avec les attributs du score ? i.e param�tre : joueur,niveau,nbScore
	public void addScore(Score nouveauScore)throws IOException {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			org.w3c.dom.Document doc ;
			File xml = new File(cheminPartitionXML);
			//InputStream xmlStream = Partition.class.getResourceAsStream(cheminPartitionXML);
			doc = docBuilder.parse(xml);

			//Placement au nivau de LISTE_SCORE
			Node listeScore = doc.getElementsByTagName("LISTE_SCORE").item(0);
			//Ajout du noeud Score
			Element score = doc.createElement("Score");
			listeScore.appendChild(score);

			//Ajout de l'�l�ment Joueur
			Element joueur = doc.createElement("joueur");
			Text joueurTxt = doc.createTextNode(nouveauScore.getJoueur());
			joueur.appendChild(joueurTxt);
			score.appendChild(joueur);
			//Ajout de l'�l�ment Niveau
			Element niveau = doc.createElement("niveau");
			Text niveauTxt = doc.createTextNode(nouveauScore.getNiveau());
			niveau.appendChild(niveauTxt);
			score.appendChild(niveau);
			//Ajout de l'�l�ment nbScore
			Element nbScore = doc.createElement("nbscore");
			Text nbScoreTxt = doc.createTextNode(nouveauScore.getNbScore());
			nbScore.appendChild(nbScoreTxt);
			score.appendChild(nbScore);

			DOMSource domSource = new DOMSource(doc);
			// Transformation 
			
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			
			TransformerFactory fabrique = TransformerFactory.newInstance();
			Transformer transformer = fabrique.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			transformer.transform(domSource, result);
			String xmlString = result.getWriter().toString();
			System.out.println(xmlString);
			
			//Ajout � la liste des scores
			this.ListeScore.add(nouveauScore);

			System.out.println("Done"); //TEST
			

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}

	/**M�thode permettant de d�finir le nom de la musique.
	 * Utiliser par la classe SaxHandler
	 * @param chemin
	 */
	public void setCheminAudio(String chemin){
		cheminFichierAudio = chemin;
	}
	/** M�thode permettant de d�finir le nom de la musique.
	 * Utiliser par la classe SaxHandler
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
