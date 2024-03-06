import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _24479 {
	static int N, M, R;
	static ArrayList<Integer>[] al;
	static boolean[] visited;
	static int[] order;
	
	static int count = 2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		al = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		order = new int[N + 1];
		
		for (int i = 1; i <= N; i++) al[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			al[u].add(v);
			al[v].add(u);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(al[i]);			
		}
		
		order[R] = 1;
		visited[R] = true;
		dfs(R);

		for (int i = 1; i <= N; i++) {
			bw.write(order[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

	public static void dfs(int num) {
		
		for (int n: al[num]) {
			if (visited[n]) continue;
			visited[n] = true;
			order[n] = count ++;
			dfs(n);
		}
	}
}
