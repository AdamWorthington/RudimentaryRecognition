package miniWat;

import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class getInfo {
	public static String link;
	public ArrayList<Integer> dates = new ArrayList<Integer>();
	public String[] Months = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	public getInfo(String URL, String SUBJECT, String QUESTION) {
		link = "http://en.wikipedia.org/wiki/" + URL;
		try {
			getText(link, SUBJECT, QUESTION);
		} catch (IOException e) {
			System.out.println("ERROR: Failed at Constructor.");
			e.printStackTrace();
		}
		
	}

	/***********************************************************************
	 * Currently Unused method because it returns the HTML code of the site*
	 * *********************************************************************
	 * public void readInfo() throws IOException { String infoBulk = ""; URL url
	 * = new URL(link); BufferedReader in = new BufferedReader(new
	 * InputStreamReader( url.openStream())); String inputLine = ""; while
	 * ((inputLine = in.readLine()) != null) { infoBulk = infoBulk + "\n" +
	 * inputLine; } System.out.print(infoBulk);
	 * 
	 * }
	 */
	public void getText(String url, String subject, String question) throws IOException {
		String info = "";
		Document doc = Jsoup.connect(url).get();
		Elements paragraphs = doc.select("p");
		for (Element p : paragraphs) {
			info += "\n" + p.text();
		}
		if (subject == "born"){
			bornDate(info);
		}
		else if(subject == "happened" || subject == "happen"){
			eventDate(info);
		}
		else{
			System.out.println("Failed on getText");
		}
	}
	public void bornDate(String bulk) {
		String totalDate = "";
		int counter = 0;
		if (bulk.contains("born")) {
			int pos1 = bulk.indexOf("born");
			for (int i = 0; i < bulk.length(); i++) {
				if (counter == 4) {
					break;
				} else {
					if (bulk.charAt(pos1 + i) == '0'
							|| bulk.charAt(pos1 + i) == '1'
							|| bulk.charAt(pos1 + i) == '2'
							|| bulk.charAt(pos1 + i) == '3'
							|| bulk.charAt(pos1 + i) == '4'
							|| bulk.charAt(pos1 + i) == '5'
							|| bulk.charAt(pos1 + i) == '6'
							|| bulk.charAt(pos1 + i) == '7'
							|| bulk.charAt(pos1 + i) == '8'
							|| bulk.charAt(pos1 + i) == '9') {
						counter += 1;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					} else {
						counter = 0;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					}
				}
			}
			System.out.println(totalDate);
		}
	}

	public void eventDate(String bulk) {
		String firstPara = bulk.substring(0, 1500);
		String totalDate = "";
		int counter = 0;
		int counter2 = 0;
		if (firstPara.contains("began on")) {
			int pos1 = firstPara.indexOf("began on");
			for (int i = 0; i < firstPara.length(); i++) {
				if (counter == 4) {
					break;
				} else {
					if (bulk.charAt(pos1 + i) == '0'
							|| bulk.charAt(pos1 + i) == '1'
							|| bulk.charAt(pos1 + i) == '2'
							|| bulk.charAt(pos1 + i) == '3'
							|| bulk.charAt(pos1 + i) == '4'
							|| bulk.charAt(pos1 + i) == '5'
							|| bulk.charAt(pos1 + i) == '6'
							|| bulk.charAt(pos1 + i) == '7'
							|| bulk.charAt(pos1 + i) == '8'
							|| bulk.charAt(pos1 + i) == '9') {
						counter += 1;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					} else {
						counter = 0;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					}
				}
			}
		} else if (firstPara.contains("lasted from")) {
			int pos1 = firstPara.indexOf("lasted from");
			for (int i = 0; i < firstPara.length(); i++) {
				if (counter == 4 && counter2 == 1) {
					break;	
				} 
				else {
					if(counter == 4){
						counter2 = 1;
						counter = 0;
					}
					if (bulk.charAt(pos1 + i) == '0'
							|| bulk.charAt(pos1 + i) == '1'
							|| bulk.charAt(pos1 + i) == '2'
							|| bulk.charAt(pos1 + i) == '3'
							|| bulk.charAt(pos1 + i) == '4'
							|| bulk.charAt(pos1 + i) == '5'
							|| bulk.charAt(pos1 + i) == '6'
							|| bulk.charAt(pos1 + i) == '7'
							|| bulk.charAt(pos1 + i) == '8'
							|| bulk.charAt(pos1 + i) == '9') {
						counter += 1;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					} else {
						counter = 0;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					}
				}
			}
		} else if (firstPara.contains("happened on")) {
			int pos1 = firstPara.indexOf("happened on");
			for (int i = 0; i < firstPara.length(); i++) {
				if (counter == 4) {
					break;
				} else {
					if (bulk.charAt(pos1 + i) == '0'
							|| bulk.charAt(pos1 + i) == '1'
							|| bulk.charAt(pos1 + i) == '2'
							|| bulk.charAt(pos1 + i) == '3'
							|| bulk.charAt(pos1 + i) == '4'
							|| bulk.charAt(pos1 + i) == '5'
							|| bulk.charAt(pos1 + i) == '6'
							|| bulk.charAt(pos1 + i) == '7'
							|| bulk.charAt(pos1 + i) == '8'
							|| bulk.charAt(pos1 + i) == '9') {
						counter += 1;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					} else {
						counter = 0;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					}
				}
			}
		} else if (firstPara.contains("-")) {
			int pos1 = firstPara.indexOf("-");
			
			String firstSec = "";
			for(int j = 0; j < 25; j++){
				firstSec = firstPara.substring( pos1 - j, pos1);
				if(firstSec.contains(Months[0]) || firstSec.contains(Months[1]) || firstSec.contains(Months[2]) || firstSec.contains(Months[3]) || firstSec.contains(Months[4]) || firstSec.contains(Months[5]) || firstSec.contains(Months[6]) || firstSec.contains(Months[7]) || firstSec.contains(Months[8]) || firstSec.contains(Months[9]) || firstSec.contains(Months[10]) || firstSec.contains(Months[11])){
					break;
				}
			}
			for (int i = 0; i < firstPara.length(); i++) {
				if (counter == 4) {
					totalDate = firstSec + totalDate;
					break;
				} else {
					if (bulk.charAt(pos1 + i) == '0'
							|| bulk.charAt(pos1 + i) == '1'
							|| bulk.charAt(pos1 + i) == '2'
							|| bulk.charAt(pos1 + i) == '3'
							|| bulk.charAt(pos1 + i) == '4'
							|| bulk.charAt(pos1 + i) == '5'
							|| bulk.charAt(pos1 + i) == '6'
							|| bulk.charAt(pos1 + i) == '7'
							|| bulk.charAt(pos1 + i) == '8'
							|| bulk.charAt(pos1 + i) == '9') {
						counter += 1;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					} else {
						counter = 0;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					}
				}
			}
		}

		else if (firstPara.contains("on")) {
			int pos1 = bulk.indexOf("on");
			for (int i = 0; i < firstPara.length(); i++) {
				if (counter == 4) {
					break;
				} else {
					if (bulk.charAt(pos1 + i) == '0'
							|| bulk.charAt(pos1 + i) == '1'
							|| bulk.charAt(pos1 + i) == '2'
							|| bulk.charAt(pos1 + i) == '3'
							|| bulk.charAt(pos1 + i) == '4'
							|| bulk.charAt(pos1 + i) == '5'
							|| bulk.charAt(pos1 + i) == '6'
							|| bulk.charAt(pos1 + i) == '7'
							|| bulk.charAt(pos1 + i) == '8'
							|| bulk.charAt(pos1 + i) == '9') {
						counter += 1;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					} else {
						counter = 0;
						totalDate = totalDate + bulk.charAt(pos1 + i);
					}
				}
			}
		} else {
			System.out
					.print("Shit failed, yo. Try entering the question phrased differently.");
		}
		System.out.println(totalDate);
	}
}
