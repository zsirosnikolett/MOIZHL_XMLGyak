package domMOIZHL1026;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DomWriteMOIZHL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document newDoc = dBuilder.newDocument();
			Element newRoot = newDoc.createElementNS("domMOIZHL","users");
			newDoc.appendChild(newRoot);
			
			newRoot.appendChild(createUser(newDoc, "01", "Nikolett", "Zsiros", "student"));
			newRoot.appendChild(createUser(newDoc, "02", "Gergely", "Szabo", "student"));
			newRoot.appendChild(createUser(newDoc, "03", "Marcell", "Meszaros", "student"));

			
			TransformerFactory tranFac = TransformerFactory.newInstance();
			Transformer transf = tranFac.newTransformer();
			
			transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transf.setOutputProperty(OutputKeys.INDENT, "yes");
			transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			DOMSource source = new DOMSource(newDoc);
			
			File myFile = new File("E:\\Egyetem\\XML\\XML\\MOIZHL_1026\\user1MOIZHL.xml");
			
			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(myFile);
			
			transf.transform(source, console);
			transf.transform(source, file);
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static Node createUser(Document doc,String id, String fname, String lname, String prof) {
		Element user = doc.createElement("user");
		
		user.setAttribute("id", id);
		user.appendChild(createUserElement(doc, "firstname", fname));
		user.appendChild(createUserElement(doc, "lastname", lname));
		user.appendChild(createUserElement(doc, "profession", prof));
		
		return user;
	}
	
	public static Node createUserElement(Document doc, String n, String i) {
		Element el = doc.createElement(n);
		el.appendChild(doc.createTextNode(i));
		
		return el;
	}

}
