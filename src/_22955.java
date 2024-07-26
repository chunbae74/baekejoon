import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _22955 {
	static boolean isDebug = false;
	static final int INF = Integer.MAX_VALUE >> 1;
	static int X, Y;
	static int startX, startY, endX, endY;
	static int[][] graph;
	static int[][] dist;

	static PriorityQueue<int[]> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		/*
		 * -1: 媛뺤븘吏� 0 : 怨좎뼇�씠, �깉異쒓뎄 1 : �씪諛� 諛붾떏 2 : �궗�떎由� 3 : �븘�옒媛� �슟�젮�엳�뒗 怨듦컙
		 */
		graph = new int[Y][X];
		dist = new int[Y][X];

		for (int y = 0; y < Y; y++) {
			String input = br.readLine();
			for (int x = 0; x < X; x++) {
				dist[y][x] = INF;
				char c = input.charAt(x);
				if (c == 'C') {
					startX = x;
					startY = y;
					graph[y][x] = 0;
				} else if (c == 'D') {
					graph[y][x] = -1;
				} else if (c == 'E') {
					endX = x;
					endY = y;
					graph[y][x] = 0;
				} else if (c == 'F') {
					graph[y][x] = 1;
				} else if (c == 'L') {
					graph[y][x] = 2;
				} else if (c == 'X') {
					graph[y][x] = 3;
				}
			}
		}

		// { x, y, dist[y][x], direction }
		pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[2], e2[2]));
		dist[startY][startX] = 0;
		pq.offer(new int[] { startX, startY, dist[startY][startX], 0 });
		pq.offer(new int[] { startX, startY, dist[startY][startX], 1 });
		while (!pq.isEmpty()) {
			int nowX = pq.peek()[0];
			int nowY = pq.peek()[1];
			int nowCost = pq.peek()[2];
			int nowDirection = pq.peek()[3];
			pq.poll();

			if (dist[nowY][nowX] < nowCost)
				continue;

			if (graph[nowY][nowX] == -1 || graph[nowY][nowX] == 3)
				continue;

			if (nowX == endX && nowY == endY)
				break;

			move(nowX, nowY, nowCost, nowDirection);
		}

		if (isDebug) {
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					int a = dist[y][x];
					System.out.print((a == INF ? "-" : a) + "\t");
				}
				System.out.println();
			}
		}

		int ans = dist[endY][endX];
		System.out.println(ans == INF ? "dodo sad" : ans);
	}

	/**
	 * @param nowDirection : 0, 1 (left, right)
	 */
	public static void move(int nowX, int nowY, int nowCost, int direction) {
		int nextX = direction == 0 ? nowX + 1 : nowX - 1;
		int nextY = nowY;
		int nextCost = nowCost;

		while (true) {
			// go left
			if (direction == 0) {
				nextX--;
				if (nextX < 0)
					break;
			}
			// go right
			else if (direction == 1) {
				nextX++;
				if (nextX >= X)
					break;
			}

			if (graph[nextY][nextX] == -1)
				break;

			// if there's no reason to continue
			if (dist[nextY][nextX] < nextCost + 1 && graph[nextY][nextX] == 1)
				continue;
			
			if (nowX != nextX) nextCost++;

			// if there's a hole so you go fallen' down
			if (graph[nextY][nextX] == 3) {
				int arriveY = nextY;
				for (; arriveY < Y - 1 && (graph[arriveY][nextX] != 1 && graph[arriveY][nextX] != 2); arriveY++)
					;
				// it's not possible arriving
				if (arriveY == Y - 1 && (graph[arriveY][nextX] != 1 && graph[arriveY][nextX] != 2))
					return;
				if (dist[arriveY][nextX] > nextCost + 10) {
					dist[arriveY][nextX] = nextCost + 10;
					pq.offer(new int[] { nextX, arriveY, dist[arriveY][nextX], 0 });
					pq.offer(new int[] { nextX, arriveY, dist[arriveY][nextX], 1 });
				}
				return;
			}

			// if there's a ladder in a downfloor so you can go down
			if (nextY + 1 < Y && graph[nextY + 1][nextX] == 2) {
				if (dist[nextY + 1][nextX] > nextCost + 5) {
					dist[nextY + 1][nextX] = nextCost + 5;
					pq.offer(new int[] { nextX, nextY + 1, dist[nextY + 1][nextX], 0 });
					pq.offer(new int[] { nextX, nextY + 1, dist[nextY + 1][nextX], 1 });
				}
			}

			// if there's a ladder so you can go up
			if (graph[nextY][nextX] == 2) {
				// if there's no room to go
				if (nextY - 1 < 0)
					continue;

				if (graph[nextY - 1][nextX] != 3 && graph[nextY - 1][nextX] != -1) {
					if (dist[nextY - 1][nextX] > nextCost + 5) {
						dist[nextY - 1][nextX] = nextCost + 5;
						pq.offer(new int[] { nextX, nextY - 1, dist[nextY - 1][nextX], 0 });
						pq.offer(new int[] { nextX, nextY - 1, dist[nextY - 1][nextX], 1 });
					}
				}
			}

			if (dist[nextY][nextX] > nextCost) {
				dist[nextY][nextX] = nextCost;
			}
		}
	}

}
