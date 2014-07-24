package webPage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class UrlDownload {

   public static void main(String[] args) throws IOException { 
	   
	   String univ = "university-of-chicago";
	   String state_initials = "CA";
	   String univ_initials = "UCI";
	   String web = "http://www.studentsreview.com/IL/UC_c.html";
      
String a = "univ.txt";

String b = "univ2.html";

String c = "univ3.txt";

String xmlName = "psu.xml";

ArrayList<String> elements = new ArrayList<>();
ArrayList<String> values = new ArrayList<>();

ManageHtml hh = new ManageHtml();

HandleXML hx = new HandleXML();

//String web = "http://www.studentsreview.com/"+state_initials+"/"+univ_initials+"_c.html";
       

      try {
    	  
    	  
    	  String u1 = "http://www.collegeview.com/schoolfacts/"+univ+"/all?siteId=69";
    	  //String u1 = "http://www.collegeview.com/schoolfacts/washington-university-in-st-louis/all";
    	 

URL url = new URL(u1);
BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
BufferedWriter writer = new BufferedWriter (new FileWriter(a));

String line;

while ((line = reader.readLine()) != null) {
     if(line.contains("unweighted"))
    	 System.out.println(line);
     writer.write(line);
     writer.newLine();
}

//System.out.println("done");
reader.close();
writer.close();
   }catch (MalformedURLException e) {
             e.printStackTrace();
   } catch (IOException e) {
            e.printStackTrace();
   }
     
FileInputStream fstream = new FileInputStream("Parameters1.txt");
DataInputStream in = new DataInputStream(fstream);
BufferedReader br = new BufferedReader(new InputStreamReader(in));

String strLine;

while ((strLine = br.readLine()) != null)   {
    
     String data = hh.extractTableData(a,strLine);
     if(data==null)
    	 data = "NA";
     System.out.println("data ="+strLine+" "+data);
     elements.add(strLine.replaceAll("[^\\p{L}]",""));
     values.add(data);
   }


// URL url = new URL("http://www.studentadvisor.com/reviews/pennsylvania-state-university-main-campus-6331");
// BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
// BufferedWriter writer = new BufferedWriter (new FileWriter(b));
//
// String line;
// int count;
//
// while ((line = reader.readLine()) != null) {
// 
//     if(line.contains("alt=\"Star\"")){
//          int count1 = StringUtils.countMatches(line, "alt=\"Star\"");
//          System.out.println("count="+ count1);
//          values.add(Integer.toString(count1));  // Values are added for ratings present in Ratings.txt
//     }
//     writer.write(line);
//     writer.newLine();
// }
//
// fstream = new FileInputStream("Ratings.txt");
// in = new DataInputStream(fstream);
// br = new BufferedReader(new InputStreamReader(in));
//
// while ((strLine = br.readLine()) != null)   {
//    
//     elements.add(strLine);
//   }
//
// fstream = new FileInputStream("uclaParameters2.txt");
// in = new DataInputStream(fstream);
// br = new BufferedReader(new InputStreamReader(in));
//
// while ((strLine = br.readLine()) != null)   {
//     System.out.println("wohoo1");
//     String data = hh.extractClassData(b,strLine);
//     System.out.println("data= "+strLine.replaceAll("[^\\p{L}]",""));
//     elements.add(strLine.replaceAll("[^\\p{L}]",""));
//     values.add(data);
//   }
 


fstream = new FileInputStream("Parameters3.txt");
in = new DataInputStream(fstream);
br = new BufferedReader(new InputStreamReader(in));

while ((strLine = br.readLine()) != null)   {
   
     String data = hh.extractArraysData(web,strLine);
     System.out.println("data="+data);
     if(data ==null)
    	 data = "0";
     elements.add(strLine.replaceAll("[^\\p{L}]",""));
     values.add(data.replaceAll("[']",""));
  }

HandleCSV hc = new HandleCSV();
//hx.createXML(xmlName,elements,values);
hc.createCSV(univ, elements, values);
}

}
