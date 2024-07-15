import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _22116 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final boolean isDebug = false;
		final int INF = Integer.MAX_VALUE;
		final int[] dx = { 0, 0, 1, -1 };
		final int[] dy = { 1, -1, 0, 0 };
		
		int N = Integer.parseInt(br.readLine());
		int[][] graph = new int[N][N];
		int[][] dist = new int[N][N];

		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				dist[y][x] = INF;
				graph[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[2], e2[2]));
		dist[0][0] = 0;
		pq.offer(new int[] { 0, 0, dist[0][0] });
		while (!pq.isEmpty()) {
			int nowX = pq.peek()[0];
			int nowY = pq.peek()[1];
			int nowCost = pq.peek()[2];
			pq.poll();
			
			if (dist[nowY][nowX] < nowCost) continue;
			
			if (nowX == N - 1 && nowY == N - 1) break;
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if (0 > nextX || nextX >= N || 0 > nextY || nextY >= N) continue;
				
				int nextCost = Math.max(nowCost, Math.abs(graph[nextY][nextX] - graph[nowY][nowX]));
				if (dist[nextY][nextX] > nextCost) {
					dist[nextY][nextX] = nextCost;
					pq.offer(new int[] { nextX, nextY, dist[nextY][nextX] });
				}
			}
		}
		
		if (isDebug) {
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					System.out.print(dist[y][x] + " ");
				}
				System.out.println();
			}
		}
		
		System.out.println(dist[N - 1][N - 1]);
	}

}
