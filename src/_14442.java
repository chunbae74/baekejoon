import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14442 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int INF = Integer.MAX_VALUE >> 1;
		final int[] dx = new int[] { 1, -1, 0, 0 };
		final int[] dy = new int[] { 0, 0, 1, -1 };

		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] graph = new int[Y][X];
		int[][][] dist = new int[Y][X][K + 1];

		for (int y = 0; y < Y; y++) {
			String l = br.readLine();
			for (int x = 0; x < X; x++) {
				Arrays.fill(dist[y][x], INF);
				char c = l.charAt(x);
				graph[y][x] = c - '0';
			}
		}

		// { x, y, k, dist[y][x][k] }
		Queue<int[]> queue = new LinkedList<>();
		dist[0][0][0] = 1;
		queue.offer(new int[] { 0, 0, 0, dist[0][0][0] });
		int min = INF;
		
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			int nowK = queue.peek()[2];
			int nowCost = queue.peek()[3];
			queue.poll();

			if (dist[nowY][nowX][nowK] < nowCost)
				continue;

			if (nowK > K)
				continue;

			if (nowX == X - 1 && nowY == Y - 1) {
				min = Math.min(min, nowCost);
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				int nextCost = nowCost + 1;
				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y)
					continue;

				if (graph[nextY][nextX] == 0) {
					if (dist[nextY][nextX][nowK] > nextCost) {
						dist[nextY][nextX][nowK] = nextCost;
						queue.offer(new int[] { nextX, nextY, nowK, dist[nextY][nextX][nowK] });
					}
				} else if (graph[nextY][nextX] == 1) {
					int nextK = nowK + 1;
					if (nextK <= K && dist[nextY][nextX][nextK] > nextCost) {
						dist[nextY][nextX][nextK] = nextCost;
						queue.offer(new int[] { nextX, nextY, nextK, dist[nextY][nextX][nextK] });
					}
				}
			}
		}
		
		System.out.println(min == INF ? -1 : min);
	}

}
