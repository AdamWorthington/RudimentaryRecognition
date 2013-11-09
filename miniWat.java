package miniWat;
import java.util.*;
public class miniWat {
	public static void main(String[] args){
		System.out.print("Enter the name of the article: ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String url = in.nextLine();
		@SuppressWarnings("unused")
		getInfo f = new getInfo(url);
	}
}
