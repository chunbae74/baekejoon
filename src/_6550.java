import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6550 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String l;
		while ((l = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(l);
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			int idx1 = 0;
			int idx2 = 0;
			while (idx1 < s1.length() && idx2 < s2.length()) {
				if (s1.charAt(idx1) == s2.charAt(idx2)) {
					idx1 ++;
					idx2 ++;
				} else {
					idx2 ++;
				}
			}
			
			sb.append(idx1 == s1.length() ? "Yes\n" : "No\n");
		}
		
		System.out.println(sb.toString());
	}

}
