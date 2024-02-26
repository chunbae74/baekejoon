import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * V: 마을의 개수 (정점의 개수)
 * E: 도 로의 개수 (간선의 개수)
 */
public class _1956 {
	static int[][] arr;
	static boolean[] visited;
	static int INF = Integer.MAX_VALUE >> 2;
	static ArrayList<Integer>[] al;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		arr = new int[V][V];
		al = new ArrayList[V];
		result = new int[V];
		
		for (int i = 0; i < V;i ++) {
			for (int j = 0; j < V; j++) {
				arr[i][j] = INF;
			}
			al[i] = new ArrayList<>();
			result[i] = INF;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			arr[a][b] = cost;
			al[a].add(b);
		}
		
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		
		for (int i = 0; i < V; i++) {
			visited = new boolean[V];
			Collections.sort(al[i]);
			dfs(i, i, 0);
		}
		
		Arrays.sort(result);
		bw.write((result[0] == INF) ? "-1" : (result[0] + ""));
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int start, int now, int sum) {
		for (int n: al[now]) {
			
			// 이미 방문한 도시라면 건너뛰기
			if (visited[n]) continue;
			
			sum += arr[now][n];
			
			// System.out.printf("start = %d\tnow = %d\tn = %d\tsum = %d\tcost = %d\n", start, now, n, sum, arr[now][n]);
			// 시작지점으로 되돌아왔다면
			if (n == start) {
				result[start] = Math.min(result[start], sum);
				return;
			}
			
			visited[n] = true;
			dfs(start, n, sum);
		}
		
	}
	
}
