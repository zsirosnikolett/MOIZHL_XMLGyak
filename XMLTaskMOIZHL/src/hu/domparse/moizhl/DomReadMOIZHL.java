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
			File xmlFile = new File("XMLmoizhl.xml"); // az XML fájl beolvasása
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //XML doksiból DOM doksi létrehozása
			DocumentBuilder dBuilder = factory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile); // a dokumentum lekérése
			doc.getDocumentElement().normalize();
			System.out.println("Pizzázó adatok lekérése:");
			Read(doc); //A programunk fő metódusa, itt hívódik meg Read fgv
			
			
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
		NodeList nList = doc.getElementsByTagName("Pizzazo"); // Pizzazo taggal rendelkezõ elemek lekérése listaba
																
		for (int i = 0; i < nList.getLength(); i++) { // listán végigmegyünk
			Node nNode = nList.item(i); // lekérjük a lista aktuális elemét, Elementé konvertáljuk
			Element element = (Element) nNode;
			// Lekérjük az attribútumokat, majd azok segítségével meghívjuk a definiált metódusokat
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				String Nev = element.getElementsByTagName("Nev").item(0).getTextContent(); // darabszám lekerdezese
				String Nyitvatartas = element.getElementsByTagName("Nyitvatartas").item(0).getTextContent();
				String Weboldal = element.getElementsByTagName("Weboldal").item(0).getTextContent();
				String Telefonszam = element.getElementsByTagName("Telefonszam").item(0).getTextContent();
				
				String BeszallitasID = element.getAttribute("BeszallitasID");
				
		
			
				System.out.println("\n-----------------------------------" + (i + 1)
						+ ". Pizzazo-----------------------------------");
				System.out.println("Pizzazo adatok: \n\tNév:\t" + Nev + "\n\tNyitvatartas:\t" + Nyitvatartas
						+ "\n\tWeboldal:\t" + Weboldal + "\n\tTelefonszám:\t" + Telefonszam);
			
			
				ReadBeszallitasById(doc, BeszallitasID);
			
			}
		}
	}
	
	public static void ReadFutarById(Document doc, String FutarID) {
		NodeList nList = doc.getElementsByTagName("Futarok"); 
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				if (element.getAttribute("FutarID").equals(FutarID)) { 
					String Nev = element.getElementsByTagName("Nev").item(0).getTextContent();
					String Telefonszam = element.getElementsByTagName("Telefonszam").item(0).getTextContent();
					
					String PizzaID = element.getAttribute("PizzaID");
					
					System.out.println("Futár adatok: \n\tNév:\t" + Nev + "\n\tTelefonszam:\t" + Telefonszam); //Konzolra kiírás
					
					
					ReadPizzaById(doc, PizzaID);
					
				}
			}
		}
	}

	public static void ReadBeszallitasById(Document doc, String BeszallitasID) {
		NodeList nList = doc.getElementsByTagName("Beszallitas"); 
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				if (element.getAttribute("BeszallitasID").equals(BeszallitasID)) { 
					String Datum = element.getElementsByTagName("Datum").item(0).getTextContent();
					String Hozzavalo = element.getElementsByTagName("Hozzavalo").item(0).getTextContent();
					System.out.println("Beszállítás adatok: \n\tDátum\t" + Datum + "\n\tHozzávaló:\t" + Hozzavalo);//Konzolra kiírás
					String BeszallitoID = element.getAttribute("BeszallitoID");
					
					ReadBeszallitoById(doc, BeszallitoID);
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
					String Iranyitoszam = element.getElementsByTagName("Iranyitoszam").item(0).getTextContent();
					String Varos = element.getElementsByTagName("Varos").item(0).getTextContent();
					String Utca = element.getElementsByTagName("Utca").item(0).getTextContent();
					String Hazszam = element.getElementsByTagName("Hazszam").item(0).getTextContent();
					
					System.out.println("Beszállító adatok: \n\tNév:\t" + Nev +  "\n\tIrányítószám:\t" + Iranyitoszam 
							+"\n\tVáros:\t" + Varos + "\n\tUtca:\t" + Utca + "\n\tHázszám:\t" + Hazszam); //Konzolra kiírás
					
					String FutarID = element.getAttribute("FutarID");
					
					ReadFutarById(doc, FutarID);
				}
			}
		}
	}
	
	public static void ReadPizzaById(Document doc, String PizzaID) {
		NodeList nList = doc.getElementsByTagName("Pizzak"); 
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
					
					String RendelesID = element.getAttribute("RendelesID");
					ReadRendelesbyId(doc, RendelesID);
					
					String VevoID = element.getAttribute("VevoID");
					
					ReadVevoById(doc, VevoID);
					
					
				}
			}
		}
	}
	
	public static void ReadRendelesbyId(Document doc, String RendelesID) {
		NodeList nList = doc.getElementsByTagName("Rendeles"); 
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				if (element.getAttribute("RendelesID").equals(RendelesID)) { 

					
					
				
				}
			}
		}
	}
	
	public static void ReadVevoById(Document doc, String VevoID) {
		NodeList nList = doc.getElementsByTagName("Vevok"); 
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			Element element = (Element) nNode;
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				if (element.getAttribute("VevoID").equals(VevoID)) { 
					String Nev = element.getElementsByTagName("Nev").item(0).getTextContent();
					String Telefonszam = element.getElementsByTagName("Telefonszam").item(0).getTextContent();
					String Iranyitoszam = element.getElementsByTagName("Iranyitoszam").item(0).getTextContent();
					String Varos = element.getElementsByTagName("Varos").item(0).getTextContent();
					String Utca = element.getElementsByTagName("Utca").item(0).getTextContent();
					String Hazszam = element.getElementsByTagName("Hazszam").item(0).getTextContent();
					System.out.println("Vevő adatok: \n\tNév:\t" + Nev + "\n\tTelefonszam:\t" + Telefonszam + 
							"\n\tIrányítószám:\t" + Iranyitoszam +"\n\tVáros:\t" + Varos + "\n\tUtca:\t" + Utca + 
							"\n\tHázszám:\t" + Hazszam); //Konzolra kiírás
					
					
				}
			}
		}
	}

	
	
}

