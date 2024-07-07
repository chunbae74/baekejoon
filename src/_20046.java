import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _20046 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE;
		final int[] dx = { 1, -1, 0, 0 };
		final int[] dy = { 0, 0, 1, -1 };
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[Y][X];
		int[][] graph = new int[Y][X];
		
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				dist[y][x] = INF;
				graph[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 시작지점이 -1인 경우..
		if (graph[0][0] == -1) {
			System.out.println("-1");
			System.exit(0);
		}
		
		// [x, y, dist[y][x]]
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[2], e2[2]));
		dist[0][0] = graph[0][0];
		pq.offer(new int[] { 0, 0, dist[0][0] });
		
		while (!pq.isEmpty()) {
			int nowX = pq.peek()[0];
			int nowY = pq.peek()[1];
			int nowCost = pq.peek()[2];
			pq.poll();
			
			if (dist[nowY][nowX] < nowCost) continue;
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (0 > nextX || X <= nextX || 0 > nextY || Y <= nextY) continue;
				int nextCost = graph[nextY][nextX];
				if (nextCost == -1) continue;
				
				if (dist[nextY][nextX] > dist[nowY][nowX] + nextCost) {
					dist[nextY][nextX] = dist[nowY][nowX] + nextCost;
					pq.offer(new int[] { nextX, nextY, dist[nextY][nextX] });
				}
			}
		}
		
		System.out.println((dist[Y - 1][X - 1] == INF ? -1 : dist[Y - 1][X - 1]) + "");
	}

}
