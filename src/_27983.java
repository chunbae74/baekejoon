import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _27983 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		// n번째 {X, L, C}
		int[][] arr = new int[N][3];
		ArrayList<String> color = new ArrayList<>(
				Arrays.asList("R", "Y", "B")
				);
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < st.countTokens(); j++) {
				String s = st.nextToken();
				if (s.equals("R") || s.equals("Y") || s.endsWith("B")) {
					arr[j][i] = color.indexOf(s);
				}
				else arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		boolean isFound = false;
		int i, start = 0;
		Loop1: for (i = 0; i < N - 1; i++) {
			int x1 = arr[i][0];
			int l1 = arr[i][1];
			int c1 = arr[i][2];
			for (start = i + 1; start < N; start ++) {
				int x2 = arr[start][0];
				int l2 = arr[start][1];
				int c2 = arr[start][2];
				int dist = (int) Math.abs(x2 - x1);
				int len = l1 + l2;
				if (dist <= len && c1 != c2) {
					isFound = true;
					break Loop1;
				}
			}
		}
		bw.write(isFound?"YES\n":"NO\n");
		if (isFound) bw.write((i + 1) + " " + (start + 1));
		bw.flush();
		bw.close();
	}

}
