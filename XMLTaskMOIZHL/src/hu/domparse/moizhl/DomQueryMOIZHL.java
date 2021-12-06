package hu.domparse.moizhl;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DomQueryMOIZHL {
	
	public static void main(String[] args)
			throws ParserConfigurationException, IOException, SAXException, TransformerException {
		
		File xmlFile = new File("XMLmoizhl.xml"); // xml fajl bekerese
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // olvasas lehetove tetele, /XML doksiból DOM doksi létrehozása
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		System.out.println("Root elem: " + doc.getDocumentElement().getNodeName());
		System.out.println("--------------------------------------");
		LoadPizzazoQuery(doc);
	
	}
	//Kilistazza az osszes pizzazo nevet
		public static void LoadPizzazoQuery(Document doc) throws TransformerException {
			NodeList nodeList = doc.getElementsByTagName("Pizzazo"); // Pizzazo elemek listazasa
			String Pizzazo;
			Element element = null;
			Node nNode = null;
			for (int i = 0; i < nodeList.getLength(); i++) {
				nNode = nodeList.item(i);
				element = (Element) nNode;
				String Nev = element.getElementsByTagName("Nev").item(0).getTextContent();
				System.out.println((i + 1) + ") " + Nev);
		}
			// Pizzazo valasztas
		System.out.println("Irja be annak a Pizzazonak a nevet, amelyiknek latni szeretne a Pizzak adatait:");
		Scanner sc = new Scanner(System.in);
		Pizzazo = sc.nextLine();
		for (int i = 0; i < nodeList.getLength(); i++) {
			nNode = nodeList.item(i);
			element = (Element) nNode;
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				if (Pizzazo.equals("Pizza Hut")) {
					LoadPizzaQuery(doc, "1");
					break;
				}

				if (Pizzazo.equals("Pizza Bazis")) {
					LoadPizzaQuery(doc, "2");
					break;
					
				}
			}
		}
		sc.close();
	}
	//A kivalasztott Pizzazo Pizzainak kiiraasa
			public static void LoadPizzaQuery(Document doc, String id) throws TransformerException {
				NodeList nodeList = doc.getElementsByTagName("Pizza");
				int Pizza = 0;

				for (int i = 0; i < nodeList.getLength(); i++) {
					Node nNode = nodeList.item(i);
					Element element = (Element) nNode;
					String PizzazoID = element.getAttribute("PizzazoID");
					
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						
						if (id.equals(PizzazoID)) {
							Pizza+= 1;
						
							System.out.println(Pizza + ". Pizza adatai:");
							String PizzaID = element.getAttribute("id");
							DomReadMOIZHL.ReadPizzaById(doc, PizzaID);

						}
		}
				}
			}
}

