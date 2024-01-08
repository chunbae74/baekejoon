import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10974 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visited = new boolean[N];
		
		dfs(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	
	public static void dfs(int depth) {
		if (depth == N) {
			for(int n: arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
			
		}
		
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
