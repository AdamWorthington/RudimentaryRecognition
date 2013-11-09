package miniWat;
import java.util.*;
public class miniWat {
	public static void main(String[] args){
		System.out.print("Ask me anything (with in reason(on wikipedia( with proper nouns(that are captialized)))): ");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		UserIn user = new UserIn(input);
		@SuppressWarnings("unused")
		getInfo f = new getInfo(user.getProperNoun(), user.getkeyWord(), user.getQuestionWord());
	}
}
