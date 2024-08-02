import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3062 {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0 ; t < T; t++) {
			StringBuilder sb = new StringBuilder();
			String input = br.readLine();
			int n1 = Integer.parseInt(input);
			for (int i = input.length() - 1; i >= 0; i--) {
				sb.append(input.charAt(i));
			}
			int n2 = Integer.parseInt(sb.toString());
			
			String n3 = Integer.toString(n1 + n2);
			boolean isSame = true;
			for (int i = 0; i <= n3.length() / 2; i++) {
				char c1 = n3.charAt(i);
				char c2 = n3.charAt(n3.length() - i - 1);
				if (c1 != c2) {
					isSame = false;
					break;
				}
			}
			
			System.out.println(isSame ? "YES" : "NO");
		}
	}

}
