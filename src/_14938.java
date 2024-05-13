import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * N: 지역의 개수
 * M: 수색범위
 * R: 길의 개수(무방향)
 */
public class _14938 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int INF = 987654321;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 최단 거리
		int[][] dist = new int[N][N];
		int[] itemArr = new int[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				else dist[i][j] = INF;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			itemArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int l = Integer.parseInt(st.nextToken());
			dist[a][b] = dist[b][a] = l;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int max = 0;
		// i: 출발지
		// j: 도착지
		for (int i = 0; i < N; i++) {
			// i번 지역에 떨어졌을 때 얻을 수 있는 아이템 총 합
			int sum = 0;
			for (int j = 0; j < N; j++) {
				// 만약 i->j 거리가 M보다 작다면: j번 지역에 있는 아이템 줍줍
				if (dist[i][j] <= M) sum += itemArr[j];
			}
			max = Math.max(max, sum);
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
	

}
