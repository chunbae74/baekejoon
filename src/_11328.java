import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11328 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		TC: for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr1 = new int[26];
			int[] arr2 = new int[26];
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			for (char c: s1.toCharArray()) {
				arr1[c - 'a'] ++;
			}
			for (char c: s2.toCharArray()) {
				arr2[c - 'a'] ++;
			}
			
			for (int i = 0; i < 26; i++) {
				if (arr1[i] != arr2[i]) {
					sb.append("Impossible\n");
					continue TC;
				}
			}
			
			sb.append("Possible\n");
		}
		
		System.out.println(sb.toString());
	}

}
