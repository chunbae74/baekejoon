import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14461 {
	static final boolean isDebug = false;
	static final int INF = Integer.MAX_VALUE >> 1;
	static final int[] dx = { 1, -1, 0, 0 };
	static final int[] dy = { 0, 0, 1, -1 };

	static int N, T;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		graph = new int[N][N];
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				graph[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dikjstra());
	}
	
	public static int dikjstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[2], e2[2]));
		int[][][] dist = new int[N][N][3];
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				for (int t = 0; t < 3; t++) {
					if (x == 0 && y == 0) continue;
					dist[y][x][t] = INF;
				}
			}
		}
		
		pq.offer(new int[] { 0, 0, dist[0][0][0], 0 });
		while (!pq.isEmpty()) {
			int nowX = pq.peek()[0];
			int nowY = pq.peek()[1];
			int nowCost = pq.peek()[2];
			int nowCount = pq.peek()[3];
			pq.poll();
			
			if (dist[nowY][nowX][nowCount] < nowCost) continue;
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (0 > nextX || N <= nextX || 0 > nextY || N <= nextY) continue;
				
				// 길 건너는데 걸리는 시간 T
				int nextCost = T;
				int nextCount = nowCount + 1;
				// 길을 세 번 건널 때마다 풀을 먹어야 함
				if (nextCount >= 3) {
					nextCost += graph[nextY][nextX];
					nextCount = 0;
				}
				
				if (dist[nextY][nextX][nextCount] > dist[nowY][nowX][nowCount] + nextCost) {
					dist[nextY][nextX][nextCount] = dist[nowY][nowX][nowCount] + nextCost;
					pq.offer(new int[] { nextX, nextY, dist[nextY][nextX][nextCount], nextCount });
				}
			}
		}
		
		if (isDebug) {
			for (int t = 0; t < 3; t++) {
				System.out.printf("\n\nt = %d\n", t);
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						System.out.print(dist[y][x][t] + " ");
					}
					System.out.println();
				}
				
			}
		}
		
		return Math.min(dist[N - 1][N - 1][0], Math.min(dist[N - 1][N - 1][1], dist[N - 1][N - 1][2]));
	}
}
