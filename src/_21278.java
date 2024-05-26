import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _21278 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int INF = 987654321;
		
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
			// a <-> b 왕복 시간 : 2
			dist[a][b] = dist[b][a] = 1;
		}
		
		// 플로이드-워셜 알고리즘
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		// 왕복하는 최단 시간의 종합(최종)
		int result = Integer.MAX_VALUE;
		// 선택된 도시 town1, town2 (단, town1 < town2)
		int town1 = N;
		int town2 = N;

		// 첫 번째 도시후보 i
		for (int i = 0; i < N; i++) {
			// 두 번째 도시후보 j
			for (int j = 0; j < N; j++) {
				int sum = 0;
				// 한 도시만 선택되는 경우가 없도록.
				if (i == j) continue;
				// 두 치킨집에서 다른 모든 도시까지의 경우의 수
				for (int k = 0; k < N; k++) {
					// 치킨집 i와 치킨집j에서 k지역까지 가는 데 걸리는 시간 중 더 짧은 시간 더하기
					sum += Math.min(dist[i][k] << 1, Math.min(dist[j][k] << 1, dist[i][k] + dist[k][j]));
				}
				
				if (result >= sum) {
					int low = Math.min(i, j);
					int high = Math.max(i, j);
					result = sum;
					// 만약 작은 번호가 더 작아질 수 있다면
					if (town1 > low) {
						town1 = low;
						town2 = high;
					// 작은 번호가 같다면
					} else if (town1 == low) {
						// 큰 번호가 더 작은 것
						town2 = Math.min(town2, high);
					}
				}
			}
		}
		
		town1 ++;
		town2 ++;
		
		bw.write(town1 + " " + town2 + " " + (result));
		bw.flush();
		bw.close();
		br.close();
	}

}
