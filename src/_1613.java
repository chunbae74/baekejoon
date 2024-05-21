import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * N: 사건의 개수
 * K: 주어진 사건의 전후 관계의 개수
 * S: 사건의 전후 관계를 알고 싶은 사건 쌍의 수
 */
public class _1613 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		final int INF = 500;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// dist배열 선언 후 초기화
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				else dist[i][j] = INF;
			}
		}
		
		// 주어진 사건의 전후 관계 반영
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			// a는 b보다 먼저 일어남
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			dist[b][a] = 1;	
		}
		
		// 플로이드-워셜 알고리즘 시행
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					else dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		// 사건의 전후 관계를 알고싶은 사건 쌍의 수
		int S = Integer.parseInt(br.readLine());
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			// a가 b보다 먼저 일어남
			if (dist[b][a] != INF) sb.append("-1\n");
			// b가 a보다 먼저 일어남
			else if (dist[a][b] != INF) sb.append("1\n");
			// 순서를 알 수 없음
			else sb.append("0\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
