package hu.domparse.moizhl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomReadMOIZHL {

	public static void main(String[] args) {
		try {
			File xmlFile = new File("XMLmoizhl.xml"); // fájlt beolvassa
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			Read(doc);
			//Kivételkezelés
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}

public static void Read(Document doc) {
	NodeList nList = doc.getElementsByTagName("Gyorsétterem"); //
	for (int i = 0; i < nList.getLength(); i++) {
		Node nNode = nList.item(i);
		Element element = (Element) nNode;
		if (nNode.getNodeType() == Node.ELEMENT_NODE) { //az ID-k kinyerése
			String PizzazoID = element.getAttribute("PizzazoID");
			String BeszallitoID = element.getAttribute("BeszallitoID");
			String FutarID = element.getAttribute("FutarID");
			String PizzaID = element.getAttribute("PizzaID");
			String VevoID = element.getAttribute("VevoID");
			
			ReadPizzazoById(doc, PizzazoID);
			ReadBeszallitoById(doc, BeszallitoID);
			ReadFutarById(doc, FutarID);
			ReadPizzaById(doc, PizzaID);
			ReadVevoById(doc, VevoID);
			
		}
	}
}

public static void ReadPizzazoById(Document doc, String PizzazoID) {
	NodeList nList = doc.getElementsByTagName("Pizzazo"); 
	for (int i = 0; i < nList.getLength(); i++) {
		Node nNode = nList.item(i);
		Element element = (Element) nNode;
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			if (element.getAttribute("PizzazoID").equals(PizzazoID)) { 
				String Elerhetoseg = element.getElementsByTagName("Elerhetoseg").item(0).getTextContent();
				String Nyitvatartas = element.getElementsByTagName("Nyitvatartas").item(0).getTextContent();
				String Nev = element.getElementsByTagName("Nev").item(0).getTextContent();
				String Cim = element.getElementsByTagName("Cim").item(0).getTextContent();
				System.out.println("Pizzazo adatok: \n\tNév:\t" + Nev + "\n\tNyitvatartas:\t" + Nyitvatartas
						+ "\n\tElérhetõség:\t" + Elerhetoseg + "\n\tCim:\t" + Cim); //Konzolra kiírás
				
				
				
			}
		}
	}
}

public static void ReadBeszallitoById(Document doc, String BeszallitoID) {
	NodeList nList = doc.getElementsByTagName("Beszallito"); 
	for (int i = 0; i < nList.getLength(); i++) {
		Node nNode = nList.item(i);
		Element element = (Element) nNode;
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			if (element.getAttribute("BeszallitoID").equals(BeszallitoID)) { 
				String Nev = element.getElementsByTagName("Nev").item(0).getTextContent();
				String Cim = element.getElementsByTagName("Cim").item(0).getTextContent();
				System.out.println("Beszállító adatok: \n\tNév:\t" + Nev +  "\n\tCím:\t" + Cim); //Konzolra kiírás
				
			}
		}
	}
}

public static void ReadPizzaById(Document doc, String PizzaID) {
	NodeList nList = doc.getElementsByTagName("Pizza"); 
	for (int i = 0; i < nList.getLength(); i++) {
		Node nNode = nList.item(i);
		Element element = (Element) nNode;
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			if (element.getAttribute("PizzaID").equals(PizzaID)) { 
				String Meret = element.getElementsByTagName("Meret").item(0).getTextContent();
				String Teljes_ar = element.getElementsByTagName("Teljes_ar").item(0).getTextContent();
				String Pizza_neve = element.getElementsByTagName("Pizza_neve").item(0).getTextContent();
				System.out.println("Pizza adatok: \n\tMeret:\t" + Meret + "\n\tTeljes_ar:\t" + Teljes_ar
						+ "\n\tPizza_neve:\t" + Pizza_neve); //Konzolra kiírás
				
				String PizzazoID = element.getAttribute("PizzazoID");
				ReadPizzazoById(doc, PizzazoID);
			}
		}
	}
}

public static void ReadFutarById(Document doc, String FutarID) {
	NodeList nList = doc.getElementsByTagName("Futar"); 
	for (int i = 0; i < nList.getLength(); i++) {
		Node nNode = nList.item(i);
		Element element = (Element) nNode;
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			if (element.getAttribute("FutarID").equals(FutarID)) { 
				String Nev = element.getElementsByTagName("Nev").item(0).getTextContent();
				String Telefonszam = element.getElementsByTagName("Telefonszam").item(0).getTextContent();
				System.out.println("Futar adatok: \n\tNév:\t" + Nev + "\n\tTelefonszam:\t" + Telefonszam); //Konzolra kiírás
				String PizzazoID = element.getAttribute("PizzazoID");
				ReadPizzazoById(doc, PizzazoID);
				
			}
		}
	}
}

public static void ReadVevoById(Document doc, String VevoID) {
	NodeList nList = doc.getElementsByTagName("Vevo"); 
	for (int i = 0; i < nList.getLength(); i++) {
		Node nNode = nList.item(i);
		Element element = (Element) nNode;
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			if (element.getAttribute("VevoID").equals(VevoID)) { 
				String Nev = element.getElementsByTagName("Nev").item(0).getTextContent();
				String Cim = element.getElementsByTagName("cim").item(0).getTextContent();
				String Telefonszam = element.getElementsByTagName("Telefonszam").item(0).getTextContent();
				System.out.println("Vevo adatok: \n\tNev:\t" + Nev + "\n\tCim:\t" + Cim + "\n\tTelefonszam:\t" + Telefonszam); //Konzolra kiírás
			}
		}
	}
}
}