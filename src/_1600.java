import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1600 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final int INF = Integer.MAX_VALUE >> 1;
		final int[] dx1 = new int[] { 1, -1, 0, 0 };
		final int[] dy1 = new int[] { 0, 0, 1, -1 };
		final int[] dx2 = new int[] { -2, -2, -1, -1, 1, 1, 2, 2 };
		final int[] dy2 = new int[] { -1, 1, -2, 2, -2, 2, -1, 1 };

		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] graph = new int[Y][X];
		int[][][] dist = new int[Y][X][K + 1];

		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				graph[y][x] = Integer.parseInt(st.nextToken());
				Arrays.fill(dist[y][x], INF);
			}
		}

		// { x, y, k, dist[y][x][k] }
		Queue<int[]> queue = new LinkedList<>();
		dist[0][0][0] = 0;
		queue.offer(new int[] { 0, 0, 0, dist[0][0][0] });
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			int nowK = queue.peek()[2];
			int nowCost = queue.peek()[3];
			queue.poll();

			if (nowK > K)
				continue;

			if (dist[nowY][nowX][nowK] < nowCost)
				continue;

			for (int i = 0; i < dx1.length; i++) {
				int nextX1 = nowX + dx1[i];
				int nextY1 = nowY + dy1[i];
				int nextCost = nowCost + 1;
				if (0 > nextX1 || nextX1 >= X || 0 > nextY1 || nextY1 >= Y)
					continue;

				if (graph[nextY1][nextX1] == 1)
					continue;

				if (dist[nextY1][nextX1][nowK] > nextCost) {
					dist[nextY1][nextX1][nowK] = nextCost;
					queue.offer(new int[] { nextX1, nextY1, nowK, nextCost });
				}
			}

			for (int i = 0; i < dx2.length; i++) {
				int nextX2 = nowX + dx2[i];
				int nextY2 = nowY + dy2[i];
				int nextK = nowK + 1;
				int nextCost = nowCost + 1;
				if (nextK > K)
					continue;
				if (0 > nextX2 || nextX2 >= X || 0 > nextY2 || nextY2 >= Y)
					continue;
				if (graph[nextY2][nextX2] == 1)
					continue;
				if (dist[nextY2][nextX2][nextK] > nextCost) {
					dist[nextY2][nextX2][nextK] = nextCost;
					queue.offer(new int[] { nextX2, nextY2, nextK, nextCost });
				}
			}
		}

		int min = INF;
		for (int k = 0; k <= K; k++) {
			min = Math.min(min, dist[Y - 1][X - 1][k]);
		}

		System.out.println(min == INF ? -1 : min);
	}

}
