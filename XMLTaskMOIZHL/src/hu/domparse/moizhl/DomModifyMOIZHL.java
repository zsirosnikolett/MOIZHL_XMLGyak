package hu.domparse.moizhl;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class DomModifyMOIZHL {
	 public static void main(String[] args) {
    NodeList nodeList;
    try{
        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        //Fájl beolvasása
        Document document=builder.parse(new File("XMLmoizhl.xml"));
        document.getDocumentElement().normalize();
        //Aktuális elem meghatározása
        nodeList=document.getElementsByTagName("");
        for(int i =0;i<nodeList.getLength();i++){
            Node node=nodeList.item(i);
            System.out.println("\nAktuális elem: " + node.getNodeName());
           
            if(node.getNodeType()==Node.ELEMENT_NODE){
                Element element=(Element) node;

                            
            }
        
    }

                Transformer transformer= TransformerFactory.newInstance().newTransformer();
                Source input=new DOMSource(document);
                Result output=new StreamResult(new File("XMLMOIZHLModify.xml"));
                transformer.transform(input,output);
                
            }catch (ParserConfigurationException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            
            }
}
}
