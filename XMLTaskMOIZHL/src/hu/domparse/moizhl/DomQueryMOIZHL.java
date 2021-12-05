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
		
		File xmlFile = new File("XMLmoizhl.xml"); // xml fájl bekérése
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // olvasás lehetové tétele
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		System.out.println("Root elem: " + doc.getDocumentElement().getNodeName());
		System.out.println("--------------------------------------");
		LoadPizzazoQuery(doc);
	
	}
	//Kilistázza az összes Pizzázó nevét
	public static void LoadPizzazoQuery(Document doc) throws TransformerException {
		NodeList nodeList = doc.getElementsByTagName("Pizzazo"); // Pizzázó elemek listázása
		String Pizzazo;
		Element element = null;
		Node nNode = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			nNode = nodeList.item(i);
			element = (Element) nNode;
			String Nev = element.getElementsByTagName("Nev").item(0).getTextContent();
			System.out.println((i + 1) + ") " + Nev);

	
		}
	
		
		System.out.println("Írja be annak a Pizzázónak a nevét, amelyikbõl látni szeretné a Beszállítói adatait:");
		Scanner sc = new Scanner(System.in);
		Pizzazo = sc.nextLine();
		for (int i = 0; i < nodeList.getLength(); i++) {
			nNode = nodeList.item(i);
			element = (Element) nNode;
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				if (Pizzazo.equals("Pizza Hut")) {
					LoadBeszallitoQuery(doc, "01");
					break;
				}

				if (Pizzazo.equals("Pizza Bazis")) {
					LoadBeszallitoQuery(doc, "02");
					break;
				}
			}
		}
		sc.close();
	}
		//A kiválasztott Pizzázó Beszallitoinak kiírása
		public static void LoadBeszallitoQuery(Document doc, String id) throws TransformerException {
			NodeList nodeList = doc.getElementsByTagName("Beszallito");
			int Beszallito = 0;

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				Element element = (Element) nNode;
				String PizzazoID = element.getAttribute("BeszallitoID");
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					if (id.equals(PizzazoID)) {
						Beszallito+= 1;
						System.out.println(Beszallito + ". Beszallitók adatai:");
						String BeszallitoID = element.getAttribute("BeszallitoID");
						DomReadMOIZHL.ReadBeszallitoById(doc, BeszallitoID);

					}
	}
			}
		}
}
