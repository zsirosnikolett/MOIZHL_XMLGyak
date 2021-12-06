package hu.domparse.moizhl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
 
public class DomModifyMOIZHL {
	 public static void main(String[] args) 
		 throws ParserConfigurationException, IOException, SAXException, TransformerException {
				File xmlFile = new File("XMLmoizhl.xml"); // xml fájl bekérése
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // az olvasast lehetove tesszuk
				DocumentBuilder dBuilder = factory.newDocumentBuilder();  //XML doksiból DOM doksi létrehozása
				Document doc = dBuilder.parse(xmlFile);
				doc.getDocumentElement().normalize();
				System.out.println("XML Módosítása");
				System.out.println("Adja meg mit szeretne módosítani: ");
				System.out.println("1 Beszállító módosítása\n2 Pizza módosítása\n3 Futár módosítása");
				Modify(doc);
			}
		 
		 
	 public static void ModifyXML(Document doc) throws TransformerException {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("XMLmoizhl.xml"));
			transformer.transform(source, result);
		}
	 
	 
	 public static void Modify(Document doc) throws TransformerException {
			int BeszallitokSzama = doc.getElementsByTagName("Beszallito").getLength(); // beszallitok számának lekérdezése
			int PizzakSzama = doc.getElementsByTagName("Pizza").getLength(); // pizzak számának lekérdezése
			int FutarokSzama = doc.getElementsByTagName("Futar").getLength(); // futarok számának lekérdezése
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Adja meg a sorszamot: ");
			int readCategory = scan.nextInt();
			switch (readCategory) {
			case 1:
				ModifyBeszallitok(doc, BeszallitokSzama);
				break;
			case 2:
				ModifyPizzak(doc, PizzakSzama);
				break;
			case 3:
				ModifyFutarok(doc, FutarokSzama);
				break;
		
			}
			scan.close();
		}
	 
	 public static String ReadId() {
			Scanner sc = new Scanner(System.in);
			System.out.print("\nid:");
			String id = sc.nextLine();
			return id;
		}
	 private static void ModifyBeszallitok(Document doc, int beszallitoszam) throws TransformerException {
			// Kiiratjuk a jelenlegi Beszállítókat, majd lekérdezzük melyiket kívánjuk módosítani.
		
			System.out.println("Melyik Beszállítónak az adatait szeretné módosítani?");
			
			for (int i = 1; i < beszallitoszam + 1; i++) {
				System.out.println(i + ". beszállító");
				DomReadMOIZHL.ReadBeszallitoById(doc, String.valueOf(i));
				System.out.println("----------------------------------------------");
			}
			String id = ReadId();
			// Bekérjük az új adatokat
			Scanner sc = new Scanner(System.in);
			System.out.print("Név: ");
			String Nev = sc.nextLine();
			System.out.print("Iranyitoszam: ");
			String Iranyitoszam = sc.nextLine();
			System.out.print("Varos: ");
			String Varos = sc.nextLine();
			System.out.print("Utca: ");
			String Utca = sc.nextLine();
			System.out.print("Hazszam: ");
			String Hazszam = sc.nextLine();
			sc.close();
			// lekérdezzük az Elementeket, majd setTextContent-el módosítjuk.
			NodeList nodeList = doc.getElementsByTagName("Beszallito");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					String sid = element.getAttribute("BeszallitoID");
					if (sid.equals(id)) {
						Node node1 = element.getElementsByTagName("Nev").item(0);
						node1.setTextContent(Nev);
						Node node2 = element.getElementsByTagName("Iranyitoszam").item(0);
						node2.setTextContent(Iranyitoszam);
						Node node3 = element.getElementsByTagName("Varos").item(0);
						node3.setTextContent(Varos);
						Node node4 = element.getElementsByTagName("Utca").item(0);
						node4.setTextContent(Utca);
						Node node5 = element.getElementsByTagName("Hazszam").item(0);
						node5.setTextContent(Hazszam);
						System.out.println("Sikeres módosítás");
					}
				}
			}
			ModifyXML(doc); // Létrehozzuk az XML-t
	 }
	 private static void ModifyPizzak(Document doc, int pizzaszam) throws TransformerException {
			System.out.println("Melyik pizzát kívánja módosítani?");
			for (int i = 1; i < pizzaszam + 1; i++) {
				System.out.println(i + ". pizza");
				DomReadMOIZHL.ReadPizzaById(doc, String.valueOf(i));
				System.out.println("----------------------------------------------");
			}
			String id = ReadId();
			// Bekérjük az új adatokat
			Scanner sc = new Scanner(System.in);
			System.out.print("Meret: ");
			String Meret = sc.nextLine();
			System.out.print("Teljes_ar: ");
			String Teljes_ar = sc.nextLine();
			System.out.print("Pizza_neve: ");
			String Pizza_neve = sc.nextLine();
			sc.close();
			// lekérdezzük az Elementeket, majd setTextContent-el módosítjuk.
			NodeList nodeList = doc.getElementsByTagName("Pizza");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					String sid = element.getAttribute("PizzaID");
					if (sid.equals(id)) {
						Node node1 = element.getElementsByTagName("Meret").item(0);
						node1.setTextContent(Meret);
						Node node2 = element.getElementsByTagName("Teljes_ar").item(0);
						node2.setTextContent(Teljes_ar);
						Node node3 = element.getElementsByTagName("Pizza_neve").item(0);
						node3.setTextContent(Pizza_neve);
						System.out.println("Sikeres módosítás");
					}
				}
			}
			ModifyXML(doc); // Létrehozzuk az XML-t
		}
	 private static void ModifyFutarok(Document doc, int futarszam) throws TransformerException {
			System.out.println("Melyik Futárt kívánja módosítani?");
			for (int i = 1; i < futarszam + 1; i++) {
				System.out.println(i + ". futar");
				DomReadMOIZHL.ReadFutarById(doc, String.valueOf(i));
				System.out.println("----------------------------------------------");
			}
			String id = ReadId();
			// Bekérjük az új adatokat
			Scanner sc = new Scanner(System.in);
			System.out.print("Nev: ");
			String Nev = sc.nextLine();
			System.out.print("Telefonszam: ");
			String Telefonszam = sc.nextLine();
			sc.close();
			// lekérdezzük az Elementeket, majd setTextContent-el módosítjuk.
			NodeList nodeList = doc.getElementsByTagName("Futar");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nNode;
					String sid = element.getAttribute("FutarID");
					if (sid.equals(id)) {
						Node node1 = element.getElementsByTagName("Nev").item(0);
						node1.setTextContent(Nev);
						Node node2 = element.getElementsByTagName("Telefonszam").item(0);
						node2.setTextContent(Telefonszam);
						System.out.println("Sikeres módosítás");
					}
				}
			}
			ModifyXML(doc); // Létrehozzuk az XML-t
		}
	 
	 
	 }