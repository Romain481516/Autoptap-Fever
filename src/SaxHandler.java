import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
	private String currentElement;

	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {

	}
	public void endElement(String uri, String localName, String qName) throws SAXException {

	}
	public void characters(char[] chars, int start, int length) throws SAXException {
		//System.out.println(new String(chars, start, length)); //Affichage de le texte
	}
}

