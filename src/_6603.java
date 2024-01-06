import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _6603 {
	static int N;
	static int[] num;
	static boolean[] visited;
	static int[] arr = new int[6];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s;
		
		while (!(s = br.readLine()).equals("0")) {
			st = new StringTokenizer(s, " ");
			N = Integer.parseInt(st.nextToken());
			num = new int[N];
			visited = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	
	public static void dfs(int startIdx, int depth) {
		if (depth == 6) {
			for (int n: arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for (int i = startIdx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = num[i];
				dfs(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}
}
