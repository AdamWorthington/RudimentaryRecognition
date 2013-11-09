package miniWat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserIn {
	private String properNoun;
	private String questionWord;
	private String keyWord;
	private String[] key = new String[] { "happened", "born", "happen" };

	public UserIn(String input) {
		this.properNoun = this.findPN(input);
		this.questionWord = this.findQW(input);
		this.keyWord = this.findKeyWord(input);
	}

	public String findQW(String in) {
		in = in.toLowerCase();
		if (in.contains("when")) {
			return "When";
		} else if (in.contains("where")) {
			return "Where";
		} else if (in.contains("what")) {
			return "What";
		} else if (in.contains("why")) {
			return "why";
		} else if (in.contains("how")) {
			return "How";
		}
		System.out.println("Was that even a real question???????");
		return null;
	}

	public String findPN(String in) {
		int start = 0;
		int end;
		int ch;
		int temp;
		String re = "";
		for (int i = 1; i <= in.length() - 1; i++) {
			ch = (int) in.charAt(i);
			if (ch == 65 || (ch > 65 && ch < 90) || ch == 90) {
				if (start == 0) {
					start = i;
				}
			}
			if ((ch == 32 || ch == 63) && start != 0) {
				if (ch == 32) {
					temp = (int) in.charAt(i + 1);
					if (!(temp >= 65 && temp <= 90)) {
						end = i;
						return re = in.substring(start, end);
					}
				}
				if (ch == 63) {
					end = i;
					return re = in.substring(start, end);
				}
			}
		}
		System.out.println("There arent any proper nouns, and if there are, you didnt captialize them.");
		return null;
	}

	public String findKeyWord(String in) {
		for (int i = 0; i < key.length; i++) {
			if (in.contains(key[i])) {
				return key[i];
			}
		}
		return null;
	}

	public void writer(String f) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("./fail.txt"));
			writer.append(f + "\n");
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.err.println(e);
				}

			}
		}
	}

	public String getProperNoun() {
		return this.properNoun.replace(' ', '_');
	}

	public String getQuestionWord() {
		return this.questionWord;
	}

	public String getkeyWord() {
		return this.keyWord;
	}

	public static void main(String[] args) {
		UserIn test = new UserIn("Abe Lincoln born banana?");
		System.out.println(test.questionWord);
		System.out.println(test.properNoun);
		System.out.println(test.keyWord);
	}
}
