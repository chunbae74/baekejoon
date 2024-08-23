import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3613 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		final int len = s.length();
		final String e = "Error!";
		char firstCharacter = s.charAt(0);
		// 소문자로 시작하지 않는다면
		if ('a' > firstCharacter || firstCharacter > 'z') {
			System.out.println(e);
			System.exit(0);
		}
		
		if (s.contains("_")) {
			if (s.startsWith("_") || s.endsWith("_")) {
				System.out.println(e);
				System.exit(0);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append(s.charAt(0));
			for (int i = 1; i < len; i++) {
				char c = s.charAt(i);
				if (c == '_') {
					if (s.charAt(i - 1) == '_') {
						System.out.println(e);
						System.exit(0);
					} else {
						continue;
					}
				}
				
				// 대문자가 포함된다면
				if ('a' > c || c > 'z') {
					System.out.println(e);
					System.exit(0);
				} else {
					char preC = s.charAt(i - 1);
					if (preC == '_') {
						c = (char) (c - 'a' + 65);
					}
					sb.append(c);
				}
			}
			
			System.out.println(sb.toString());
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(s.charAt(0));
			for (int i = 1; i < len; i++) {
				char c = s.charAt(i);
				if ('A' <= c && c <= 'Z') {
					sb.append("_").append((char) (c - 'A' + 97));
				} else {
					sb.append(c);
				}
			}
			
			System.out.println(sb.toString());
		}
	}

}
