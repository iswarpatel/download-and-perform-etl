package webPage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

public class HandleCSV {

public void createCSV(String fileName,ArrayList<String> elements,ArrayList<String> values){
		
	try {
		
		String fname = fileName+".csv";
		BufferedWriter out = new BufferedWriter( new FileWriter(fname));
		
		for (int i=0;i<elements.size();i++){
			out.write(elements.get(i));
			out.write(",");
			
		}
		out.write("\n");
		for (int i=0;i<values.size();i++){
			System.out.println("i="+i+" "+values.get(i));
			out.write(values.get(i));
			out.write(",");
			
		}
		out.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}
}
