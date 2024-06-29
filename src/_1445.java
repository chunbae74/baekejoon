import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1445 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 2;
		final int[] dx = { 0, 0, 1, -1 };
		final int[] dy = { 1, -1, 0, 0 };
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		// 0: 지나가는 쓰레기 개수
		// 1: 쓰레기 옆을 지나가는 칸의 개수
		int[][][] dist = new int[Y][X][2];
		int[][] graph = new int[Y][X];
		int startX, startY, endX, endY;
		startX = startY = endX = endY = 0;
		
		for (int y = 0; y < Y; y++) {
			String input = br.readLine();
			for (int x = 0; x < X; x++) {
				dist[y][x] = new int[] { INF, INF };
				char c = input.charAt(x);
				
				if (c == '.') {
					graph[y][x] = 0;
				} else if (c == 'g') {
					graph[y][x] = 1;
				} else if (c == 'S') {
					startX = x;
					startY = y;
				} else if (c == 'F') {
					endX = x;
					endY = y;
				}
			} 
		}
		
		dist[startY][startX] = new int[] { 0, 0 };

		// [x, y, dist[y][x][0], dist[y][x][1]]
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
			if (e1[2] > e2[2]) {
				return 1;
			} else if (e1[2] < e2[2]) {
				return -1;
			} else {
				return Integer.compare(e1[3], e2[3]);
			}
		});
		
		pq.offer(new int[] { startX, startY, dist[startY][startX][0], dist[startY][startX][1] });
		
		while (!pq.isEmpty()) {
			int nowX = pq.peek()[0];
			int nowY = pq.peek()[1];
			int nowCost0 = pq.peek()[2];
			int nowCost1 = pq.peek()[3];
			pq.poll();
				
			if (dist[nowY][nowX][0] < nowCost0) continue;
			if (dist[nowY][nowX][1] < nowCost1) continue;
		
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y) continue;
				
				int nextCost0 = graph[nextY][nextX];
				int nextCost1 = 0;
				for (int j = 0; j < 4; j++) {
					if ((nextX == startX && nextY == startY) || (nextX == endX && nextY == endY)) break;
					else if (graph[nextY][nextX] != 0) break;
					int nx = nextX + dx[j];
					int ny = nextY + dy[j];
					if (0 > nx || nx >= X || 0 > ny || ny >= Y) continue;
					if (graph[ny][nx] == 1) nextCost1 = 1;
				}
				
				if (dist[nextY][nextX][0] > dist[nowY][nowX][0] + nextCost0) {
					dist[nextY][nextX][0] = dist[nowY][nowX][0] + nextCost0;
					if (dist[nextY][nextX][1] > dist[nowY][nowX][1] + nextCost1) {
						dist[nextY][nextX][1] = dist[nowY][nowX][1] + nextCost1;
					}
					pq.offer(new int[] { nextX, nextY, dist[nextY][nextX][0], dist[nextY][nextX][1] });
				} else if (dist[nextY][nextX][0] == dist[nowY][nowX][0] + nextCost0) {
					if (dist[nextY][nextX][1] > dist[nowY][nowX][1] + nextCost1) {
						dist[nextY][nextX][1] = dist[nowY][nowX][1] + nextCost1;
						pq.offer(new int[] { nextX, nextY, dist[nextY][nextX][0], dist[nextY][nextX][1] });
					}
				}
			}
		}
		
		System.out.println(dist[endY][endX][0] + " " + dist[endY][endX][1]);
		
	}

}
