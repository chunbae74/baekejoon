import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4740 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while (!(s = br.readLine()).equals("***")) {
			for (int i = 1; i <= s.length(); i++) {
				sb.append(s.charAt(s.length() - i));
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
