import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _23286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int INF = Integer.MAX_VALUE >> 1;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				dist[i][j] = INF;
			}
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			dist[A][B] = C;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j || i == k || j == k) continue;
					if (dist[i][k] == INF || dist[k][j] == INF) continue;
					dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));
				}
			}
		}
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			if (dist[start][end] == INF) {
				System.out.println(-1);
			} else {
				System.out.println(dist[start][end]);
			}
		}
		
	}

}
