package domMOIZHL1026;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomModifyMOIZHL {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException  {
		// TODO Auto-generated method stub
		File xmlFile = new File("carsMOIZHL.xml"); 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();


        System.out.println("--------Modified file--------");
        Modify(doc);

	}
	
    public static void ModifyXML(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult console = new StreamResult(System.out);
        transformer.transform(source, console);
    }
    
    
    public static void Modify(Document doc) throws TransformerException {
    	NodeList nodeList = doc.getElementsByTagName("supercars");
    	
    	for (int i = 0; i < nodeList.getLength(); i++) {
    		Node nNode = nodeList.item(i);
    		Element element = (Element) nNode;

    		if(nNode.getNodeType() == Node.ELEMENT_NODE) {
    			if(element.getAttribute("company").equals("Ferrari")) {
    				
    				Node node1 = element.getElementsByTagName("carname").item(i);
    				Node node2 = element.getElementsByTagName("carname").item(1);
    				node1.setTextContent("Lamborghini 001");
    				node2.setTextContent("Lamborghini 002");
    				
    				element.setAttribute("company", "Lamborghini");

    			}
    		}
			
		}
    	ModifyXML(doc);
    }
}