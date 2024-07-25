import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _22955 {
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
		 * -1: 강아지 0 : 고양이, 탈출구 1 : 일반 바닥 2 : 사다리 3 : 아래가 뚫려있는 공간
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
		pq.offer(new int[] { startX, startY, dist[startY][startX], 2 });
		pq.offer(new int[] { startX, startY, dist[startY][startX], 3 });
		while (!pq.isEmpty()) {
			int nowX = pq.peek()[0];
			int nowY = pq.peek()[1];
			int nowCost = pq.peek()[2];
			int nowDirection = pq.peek()[3];
			pq.poll();

			if (dist[nowY][nowX] < nowCost)
				continue;

			if (nowX == endX && nowY == endY)
				break;

			move(nowX, nowY, nowCost, nowDirection);
		}

		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				int a = dist[y][x];
				System.out.print((a == INF ? "-" : a) + " ");
			}
			System.out.println();
		}
		int ans = dist[endY][endX];
		System.out.println(ans == INF ? "dodo sad" : ans);
	}

	/**
	 * @param nowDirection : 0123(상하좌우)
	 */
	public static void move(int nowX, int nowY, int nowCost, int direction) {
		// 좌
		if (direction == 2) {
			int nextY = nowY;
			int nextCost = nowCost;
			for (int nextX = nowX; nextX >= 0; nextX--) {
				// 강아지를 만났을 경우
				if (graph[nextY][nextX] == -1)
					break;

				if (dist[nextY][nextX] < nextCost + 1)
					continue;
				
				nextCost++;

				if (dist[nextY][nextX] > nextCost) {
					dist[nextY][nextX] = nextCost;
				}

				if (graph[nextY][nextX] == 1)
					continue;

				// 사다리1 (고양이 칸에 사다리있음, 위칸으로 이동 가능)
				if (graph[nextY][nextX] == 2) {
					if (nextY - 1 < 0)
						continue;

					if (dist[nextY - 1][nextX] > nextCost + 5) {
						dist[nextY - 1][nextX] = nextCost + 5;
						pq.offer(new int[] { nextX, nextY - 1, dist[nextY - 1][nextX], 2 });
						pq.offer(new int[] { nextX, nextY - 1, dist[nextY - 1][nextX], 3 });
					}
					continue;
				}

				// 사다리2 (고양이 아래칸에 사다리있음, 아래칸으로 이동 가능)
				if (nextY + 1 < Y && graph[nextY + 1][nextX] == 2) {
					if (dist[nextY + 1][nextX] > nextCost + 5) {
						dist[nextY + 1][nextX] = nextCost + 5;
						pq.offer(new int[] { nextX, nextY + 1, dist[nextY + 1][nextX], 2 });
						pq.offer(new int[] { nextX, nextY + 1, dist[nextY + 1][nextX], 3 });
					}
					continue;
				}

				// 뚫려있는 바닥
				if (graph[nextY][nextX] == 3) {
					if (nextY + 1 >= Y)
						return;

					if (dist[nextY + 1][nextX] > nextCost + 10) {
						dist[nextY + 1][nextX] = nextCost + 10;
						pq.offer(new int[] { nextX, nextY + 1, dist[nextY + 1][nextX], 2 });
						pq.offer(new int[] { nextX, nextY + 1, dist[nextY + 1][nextX], 3 });
					}
					return;
				}
			}
		}

		// 우
		else if (direction == 3) {
			int nextY = nowY;
			int nextCost = nowCost;
			for (int nextX = nowX; nextX < X; nextX++) {
				// 강아지를 만났을 경우
				if (graph[nextY][nextX] == -1)
					break;

				nextCost++;
				if (dist[nextY][nextX] < nextCost)
					continue;

				if (dist[nextY][nextX] > nextCost) {
					dist[nextY][nextX] = nextCost;
				}

				if (graph[nextY][nextX] == 1)
					continue;

				// 사다리1 (고양이 칸에 사다리있음, 위칸으로 이동 가능)
				if (graph[nextY][nextX] == 2) {
					if (nextY - 1 < 0)
						continue;

					if (dist[nextY - 1][nextX] > nextCost + 5) {
						dist[nextY - 1][nextX] = nextCost + 5;
						pq.offer(new int[] { nextX, nextY - 1, dist[nextY - 1][nextX], 2 });
						pq.offer(new int[] { nextX, nextY - 1, dist[nextY - 1][nextX], 3 });
					}
					continue;
				}

				// 사다리2 (고양이 아래칸에 사다리있음, 아래칸으로 이동 가능)
				if (nextY + 1 < Y && graph[nextY + 1][nextX] == 2) {
					if (dist[nextY + 1][nextX] > nextCost + 5) {
						dist[nextY + 1][nextX] = nextCost + 5;
						pq.offer(new int[] { nextX, nextY + 1, dist[nextY + 1][nextX], 2 });
						pq.offer(new int[] { nextX, nextY + 1, dist[nextY + 1][nextX], 3 });
					}
					continue;
				}

				// 뚫려있는 바닥
				if (graph[nextY][nextX] == 3) {
					if (nextY + 1 >= Y)
						return;

					if (dist[nextY + 1][nextX] > nextCost + 10) {
						dist[nextY + 1][nextX] = nextCost + 10;
						pq.offer(new int[] { nextX, nextY + 1, dist[nextY + 1][nextX], 2 });
						pq.offer(new int[] { nextX, nextY + 1, dist[nextY + 1][nextX], 3 });
					}
					return;
				}
			}
		}
	}

}
