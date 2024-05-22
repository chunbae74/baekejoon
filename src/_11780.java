import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11780 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		final long INF = 10_000_000_000L;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		long[][] dist = new long[N][N];
		ArrayList<Integer>[][] history = new ArrayList[N][N];
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				history[i][j] = new ArrayList<>();
				if (i == j) continue;
				else dist[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			if (dist[a][b] > c) {
				dist[a][b] = c;
				history[a][b] = new ArrayList<>();
				history[a][b].add(a);
				history[a][b].add(b);
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						history[i][j] = new ArrayList<>();
						for (int num: history[i][k]) {
							history[i][j].add(num);
						}
						
						for (int num: history[k][j]) {
							if (num == k) continue;
							history[i][j].add(num);
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dist[i][j] == INF) sb.append("0 ");
				else sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 시작도시와 도착도시가 같은 경우는 없으므로.
				if (i == j) sb.append("0\n");
				else {
					if (dist[i][j] == INF) {
						sb.append("0\n");
					}
					else {
						sb.append(history[i][j].size()).append(" ");
						for (int num: history[i][j]) {
							sb.append(num + 1).append(" ");
						}
						sb.append("\n");
					}
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
