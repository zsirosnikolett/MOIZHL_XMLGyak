package xpathmoizhl1109;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class xPathMOIZHL {
	
	public static void main(String[] args)  {
		  
		  File xmlFile = new File("E:\\Egyetem\\XML\\XML\\MOIZHL_1109\\studentMOIZHL.xml");
		 try { 
		  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		  DocumentBuilder dBuilder = factory.newDocumentBuilder();
		  
		  Document doc = dBuilder.parse(xmlFile);
		  
		  doc.getDocumentElement().normalize();
		  
		  //az Path készítése
		  XPath xPath = XPathFactory.newInstance().newXPath();
		  
		  //Meg kell adni az elérési út kifejezését és a csomópont listát
		  //String expression = "class";
		  
		 // String expression = "class/student";
		  
		 // String expression = "class/student[@id='01']";
		   String expression = "//student";
		  
		  NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
		  
		  for (int i = 0; i < nodeList.getLength(); i++) {
	            Node node = nodeList.item(i);
			
	            System.out.println("\n Aktuális elem " + node.getNodeName());
	            
	            if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
	            	Element element = (Element)node;
	            	
	            	
	            	 System.out.println("Hallgató ID: "+ element.getAttribute("id"));
	            	 
	            	 System.out.println("Keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
	            	 System.out.println("Vezetéknév : " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());

	                 System.out.println("Becenév : " + element.getElementsByTagName("becenev").item(0).getTextContent());

	                 System.out.println("Kor : " + element.getElementsByTagName("kor").item(0).getTextContent());

	            }
	            
	          
	            		
		  }
					
	           
	            
		 }catch (SAXException e) {
			// TODO: handle exception
			 e.printStackTrace();
		 }catch (IOException e) {
				// TODO: handle exception
				 e.printStackTrace();
		 }catch (ParserConfigurationException e) {
				// TODO: handle exception
				 e.printStackTrace();
		 }catch (XPathExpressionException e) {
				// TODO: handle exception
				 e.printStackTrace();
		}
	}
}
	            
	            
			
			