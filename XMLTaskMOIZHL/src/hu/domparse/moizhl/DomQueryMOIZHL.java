package hu.domparse.moizhl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class DomQueryMOIZHL {
	

	 public static void main(String[] args) {
	        try {
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            // fájl beolvasása
	            Document document = builder.parse(new File("XMLmoizhl.xml"));
	            document.getDocumentElement().normalize();
	            //Xpath készítése
	            XPath xPath= XPathFactory.newInstance().newXPath();
	            
	           // String expression=;
	            
	            NodeList nodeList=(NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
	            
	            for (int i=0;i<nodeList.getLength();i++){
	                Node node=nodeList.item(i);
	                System.out.println ("\nAktuális elem: " + node.getNodeName());
	                
	                if(node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("")){
	                    Element element=(Element) node;
	                    System.out.println("" + element.getAttribute(""));
	                    System.out.println("" + element.getAttribute(""));
	                    System.out.println(" " + element.getAttribute(""));
	                    System.out.println(""
	                            + element.getElementsByTagName("").item(0).getTextContent());

	                }
	            }
	        } catch (ParserConfigurationException | XPathExpressionException | IOException | SAXException e){
	            e.printStackTrace();
	        }
	    }
	}