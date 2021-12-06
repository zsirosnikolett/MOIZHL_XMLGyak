package xPathMOIZHL;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xPathMOIZHL {

	public static void main(String[] args) {
		
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			org.w3c.dom.Document doc = dBuilder.parse("./studentMOIZHL.xml");
			
			doc.getDocumentElement().normalize();
			
			XPath xPath = XPathFactory.newInstance().newXPath();
			
			//String expression = "class";
			
			//String expression = "class/student";
			
			//String expression = "//student[@id='01']";
			
			//String expression = "//student";
			
			String expression = "class";
			
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				
				System.out.println("\n Aktuális elem: " + node.getNodeName());
				
				if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					
					System.out.println("Hallgato ID: " + element.getAttribute("id"));
					
					System.out.println("Vezetek neve: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
					System.out.println("Kereszt neve: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
					System.out.println("Bece neve: " + element.getElementsByTagName("becenev").item(0).getTextContent());
					System.out.println("Kora: " + element.getElementsByTagName("kor").item(0).getTextContent());
				}
				
				/*if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
					Element element = (Element) node;
					if(element.getAttribute("id") == "01") {
						
						System.out.println("Feladat 2: 01 ID student: ");
						System.out.println("Hallgato ID: " + element.getAttribute("id"));
						
						System.out.println("Vezetek neve: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
						System.out.println("Kereszt neve: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
						System.out.println("Bece neve: " + element.getElementsByTagName("becenev").item(0).getTextContent());
						System.out.println("Kora: " + element.getElementsByTagName("kor").item(0).getTextContent());
					}
					
				}*/
				
			}
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
