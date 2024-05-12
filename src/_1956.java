import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * V: 마을의 개수 (정점의 개수)
 * E: 도로의 개수 (간선의 개수)
 */
public class _1956 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		final long INF = 987654321;
		long[][] dist = new long[V][V];
		
		for (int i = 0; i < V;i ++) {
			for (int j = 0; j < V; j++) {
				if (i == j) dist[i][j] = 0;
				else dist[i][j] = INF;
			}
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			dist[a][b] = cost;
		}
		
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		long min = Long.MAX_VALUE;
		/*
		 * i: 출발지
		 * j: 중간지점
		 */
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (i == j) continue;
				if (dist[i][j] == INF || dist[j][i] == INF) continue;
				min = Math.min(min, dist[i][j] + dist[j][i]);
			}
		}
	
		bw.write((min == Long.MAX_VALUE) ? "-1" : (min + ""));
		bw.flush();
		bw.close();
		br.close();
	}
	
}
