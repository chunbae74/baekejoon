import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2617 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int INF = 100;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				else dist[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			// 무게: a > b
			dist[a][b] = 1;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int result = 0;
		// count[i]: i번 구슬보다 작은 구슬의 개수를 담는 배열
		int[] small = new int[N];
		int[] big = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (dist[i][j] == INF) continue;
				small[i] ++;
				big[j] ++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (small[i] >= (N + 1) / 2) {
				result ++;
				continue;
			} else if (big[i] >= (N + 1) / 2) {
				result++;
				continue;
			}
		}
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
