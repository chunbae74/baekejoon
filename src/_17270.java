import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 반례|https://www.acmicpc.net/board/view/60330
 * 	  https://www.acmicpc.net/board/view/71071
 */
public class _17270 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int INF = Integer.MAX_VALUE >> 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dist = new int[V][V];
		
		// 배열 초기화
		for (int y = 0; y < V; y++) {
			for (int x = 0; x < V; x++) {
				if (x == y) continue;
				dist[y][x] = INF;
			}
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			dist[A][B] = dist[B][A] = Math.min(Math.min(dist[A][B], dist[B][A]), C);
		}
		
		// 플로이드-워셜
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		// 지헌이의 위치
		int A = Integer.parseInt(st.nextToken()) - 1;
		// 성하의 위치
		int B = Integer.parseInt(st.nextToken()) - 1;
		
		int min = INF;
		for (int i = 0; i < V; i++) {
			// 조건 1.  지헌이의 출발 위치와 성하의 출발 위치는 새로운 약속 장소가 될 수 없다.
			if (i == A || i == B) continue;
			
			// 지헌이 혹은 성하가 이동할 수 없는 정점은 제외한다.
			if (dist[i][A] == INF || dist[i][B] == INF) continue;
			
			min = Math.min(min, dist[i][A] + dist[i][B]);
		}
		
		int dis = INF;
		int ans = -1;
		for (int i = 0; i < V; i++) {
			// 조건 1.  지헌이의 출발 위치와 성하의 출발 위치는 새로운 약속 장소가 될 수 없다.
			if (i == A || i == B) continue;
			
			// 지헌이 혹은 성하가 이동할 수 없는 정점은 제외한다.
			if (dist[i][A] == INF || dist[i][B] == INF) continue;
			
			// 조건 2.지헌이가 걸리는 최단 시간과 성하가 걸리는 최단 시간의 합이 최소
			if (min == dist[i][A] + dist[i][B]) {
				// 조건 3. 조건 1,2 만족하는 곳 중 지헌이가 성하보다 늦게 도착하는 곳은 약속 장소가 될 수 없다.
				if (dist[i][A] > dist[i][B]) continue;

				// 조건 4. 조건 1,2,3 만족하는 곳 중 지헌이로부터 가장 가까운 곳이 최종 약속 장소
				if (dis > dist[i][A]) {
					dis = dist[i][A];
					ans = i + 1;
				}
			}
		}
		
		System.out.println(ans);
	}

}
