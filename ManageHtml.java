package webPage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ManageHtml {

	public String extractTableData(String FileName, String data) throws IOException{
		
		Boolean t = false;
		File input = new File(FileName);
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
		Elements elementsByTag = doc.getElementsByTag("td");
		for (Element ele : elementsByTag) {
			
			if(t==true){
				return ele.text();
			}
			if(ele.text().contains(data)){
				System.out.println("found");
				t=true;
			}
		}
		
		return null;
	}
	
	public String extractClassData(String Filename,String elem)throws IOException{
		
		File input = new File(Filename);
		Document doc = Jsoup.parse(input, "UTF-8", "http://www.studentadvisor.com/reviews/university-of-california-los-angeles-15838");
		
		Elements elementsByTag = doc.getElementsByClass("member-answer");
		
		for (Element ele : elementsByTag) {
			
			if(ele.text().contains(elem)){
				return ele.text();
			}
		}
		
		return "";
	}
	
	public List getRatingData(String Filename)throws IOException{
		
		List<String> val = new ArrayList<>();
		
		FileInputStream fstream = new FileInputStream(Filename);
		
		 DataInputStream in = new DataInputStream(fstream);
		 BufferedReader br = new BufferedReader(new InputStreamReader(in));
		 
		 String strLine;
		 
		 while ((strLine = br.readLine()) != null)   {
		     
			 if(strLine.contains("alt=\"Star\"")){
				 
				 int count = StringUtils.countMatches(strLine, "alt=\"Star\"");
				// System.out.println("count="+ count);
				 val.add(Integer.toString(count));
		   }
		
	}
		
		 return val;
}
	public String extractArraysData(String link,String elem)throws IOException{
		
		String line;
		String[] va2 = new String[100];
		String val = null;
		int idx;
		System.out.println("elem="+elem);
		URL url = new URL(link);
		 BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		 //BufferedWriter writer = new BufferedWriter (new FileWriter(b));
		 
		 while ((line = reader.readLine()) != null) {
			 if(line.contains(elem)){
			 idx = line.indexOf("<font size='1'>",line.indexOf(elem));
			 
			 val= line.substring(idx+15,idx+18);
			 
			  
		 
//				 va2 = line.split(",");
				    
				  // System.out.println("val = "+val);
				   break;
			 }
         
		 }
		 return val;
}
	
}
