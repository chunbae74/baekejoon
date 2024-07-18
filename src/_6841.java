import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _6841 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> hs = new HashMap<>();
		hs.put("CU", "see you");
		hs.put(":-)", "I’m happy");
		hs.put(":-(", "I’m unhappy");
		hs.put(";-)", "wink");
		hs.put(":-P", "stick out my tongue");
		hs.put("(~.~)", "sleepy");
		hs.put("TA", "totally awesome");
		hs.put("CCC", "Canadian Computing Competition");
		hs.put("CUZ", "because");
		hs.put("TY", "thank-you");
		hs.put("YW", "you’re welcome");
		hs.put("TTYL", "talk to you later");
		
		while (true) {
			String input = br.readLine();
			sb.append(hs.containsKey(input.toUpperCase()) ? hs.get(input.toUpperCase()) : input).append("\n");
			if (input.equals("TTYL")) break;
		}
		
		System.out.println(sb.toString());
	}

}
