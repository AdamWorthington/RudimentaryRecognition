package miniWat;

import java.io.*;
import java.net.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class getInfo {
	public static String link;
	public ArrayList<Integer> dates = new ArrayList<Integer>();

	public getInfo(String URL) {
		link = "http://en.wikipedia.org/wiki/" + URL;
		try {
			getText(link);
		} catch (IOException e) {
			System.out.println("ERROR: Failed at Constructor.");
			e.printStackTrace();
		}
	}

	public void readInfo() throws IOException {
		String infoBulk = "";
		URL url = new URL(link);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));
		String inputLine = "";
		while ((inputLine = in.readLine()) != null) {
			infoBulk = infoBulk + "\n" + inputLine;
		}
		System.out.print(infoBulk);

	}

	public void getText(String url) throws IOException {
		String info = "";
		Document doc = Jsoup.connect(url).get();
		Elements paragraphs = doc.select("p");
		for (Element p : paragraphs) {
			info += "\n" + p.text();
		}
		
		extractDate(info);
	}
	public void extractDate(String bulk){
		String totalDate = "";
		int counter = 0;
		if (bulk.contains("born")){
			int pos1 = bulk.indexOf("born");
			
			for(int i = 0; i < bulk.length(); i++){
				if(counter == 4){
					break;
				}
				else{
					if(bulk.charAt(pos1 + i) == '0' ||bulk.charAt(pos1 + i) == '1' || bulk.charAt(pos1 + i) == '2' ||bulk.charAt(pos1 + i) == '3' ||bulk.charAt(pos1 + i) == '4' ||bulk.charAt(pos1 + i) == '5' ||bulk.charAt(pos1 + i) == '6' ||bulk.charAt(pos1 + i) == '7' ||bulk.charAt(pos1 + i) == '8' ||bulk.charAt(pos1 + i) == '9'){
						counter += 1;
						totalDate = totalDate + bulk.charAt(pos1 + i);
						
					}
					else{
						counter = 0;
						totalDate = totalDate + bulk.charAt(pos1 + i);
						
					}
				}
			}
			System.out.println(totalDate);
		}
		
		
		
		
		
		
	}
}
