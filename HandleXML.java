package webPage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class HandleXML {
	

	
	public void createXML(String fileName,ArrayList<String> elements,ArrayList<String> values){
		
		//String s = new String("C:\\Users\\admin\\workspace\\ResearchProject\\"+fileName);
		//System.out.println(s);
		
		try {
			
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			
			Element root = document.createElement(fileName);
			//root.appendChild(document.createTextNode(" "));
			document.appendChild(root);
			
			//String a = elements.get(0);
				//Element parameters = document.createElement(a);
			
			
		  for(int i=0;i<elements.size();i++){
				
				String a3 = (String)elements.get(i);
				//System.out.println("elemtn ="+a3);
				Element parameters = (Element)document.createElement(a3.replaceAll("[^\\p{L}]",""));
				parameters.appendChild(document.createTextNode(values.get(i)));
				root.appendChild(parameters);
			} 
			


			 // create the xml file
			//transform the DOM Object to an XML File
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(fileName));		

			transformer.transform(domSource, streamResult);
			StreamResult result = new StreamResult(System.out);



		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		

}
