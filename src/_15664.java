import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15664 {
	static int N, M;
	static int[] num;
	static int[] arr;
	static boolean[] visited;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		arr = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		dfs(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
	public static void dfs(int idx, int depth) {
		if (depth == M) {
			for (int n: arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1;
		for (int i = idx; i < N; i++) {
			if (visited[i] || prev == num[i]) continue;
			prev = num[i];
			visited[i] = true;
			arr[depth] = num[i];
			dfs(i + 1, depth + 1);
			visited[i] = false;
		}
	}

}
