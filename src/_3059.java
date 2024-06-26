import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3059 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			boolean[] visited = new boolean[26];
			char[] charArr = br.readLine().toCharArray();
			for (int i = 0; i < charArr.length; i++) {
				int idx = charArr[i] - 'A';
				visited[idx] = true;
			}
			
			int sum = 0;
			for (int i = 0; i < visited.length; i++) {
				if (!visited[i]) {
					sum += (65 + i);
				}
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
