import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _22255 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		final int[] dx1 = { 1, -1, 0, 0 };
		final int[] dy1 = { 0, 0, 1, -1 };
		final int[] dx2 = { 0, 0, };
		final int[] dy2 = { 1, -1 };
		final int[] dx3 = { 1, -1 };
		final int[] dy3 = { 0, 0 };
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[][] graph = new int[Y][X];
		// [3K, 3K+1, 3K+2]
		int[][][] dist = new int[Y][X][3];
		
		st = new StringTokenizer(br.readLine());
		int startY = Integer.parseInt(st.nextToken()) - 1;
		int startX = Integer.parseInt(st.nextToken()) - 1;
		int endY = Integer.parseInt(st.nextToken()) - 1;
		int endX = Integer.parseInt(st.nextToken()) - 1;
		
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				graph[y][x] = Integer.parseInt(st.nextToken());
				Arrays.fill(dist[y][x], INF);
			}
		}
		
		int ans = INF;
		// { x, y, k, dist[y][x][k] }
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[3], e2[3]));
		dist[startY][startX][0] = 0;
		pq.offer(new int[] { startX, startY, 0, dist[startY][startX][0] });
		int[] dx, dy;
		while (!pq.isEmpty()) {
			int nowX = pq.peek()[0];
			int nowY = pq.peek()[1];
			int nowK = pq.peek()[2];
			int nowCost = pq.peek()[3];
			pq.poll();
			
			if (dist[nowY][nowX][nowK] < nowCost) continue;
			
			if (nowX == endX && nowY == endY) {
				ans = Math.min(nowCost, ans);
				continue;
			}
			
			int nextK = (nowK + 1) % 3;
			
			if (nextK == 0) {
				dx = dx1;
				dy = dy1;
			} else if (nextK == 1) {
				dx = dx2;
				dy  = dy2;
			} else if (nextK == 2) {
				dx = dx3;
				dy = dy3;
			} else {
				System.out.println("an error occur!");
				break;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y) continue;
				
				if (graph[nextY][nextX] == -1) continue;
				
				int nextCost = dist[nowY][nowX][nowK] + graph[nextY][nextX];

				if (dist[nextY][nextX][nextK] > nextCost) {
					dist[nextY][nextX][nextK] = nextCost;
					pq.offer(new int[] { nextX, nextY, nextK, dist[nextY][nextX][nextK] });
				}
			}
		}
		
		System.out.println(ans == INF ? -1 : ans);
	}

}
