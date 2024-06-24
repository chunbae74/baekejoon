import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 반례 : https://bingorithm.tistory.com/2
// 80% 메모리초과 반례 : https://www.acmicpc.net/board/view/109356
public class _6087 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final boolean isDebug = false;
		final int INF = 101 * 101;
		final int[] dx = { 0, 0, -1, 1 };
		final int[] dy = { -1, 1, 0, 0 };
		final int[] nop = { 1, 0, 3, 2 };
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] dist = new int[Y][X];
		int[][] graph = new int[Y][X];
		boolean[][][] visited = new boolean[Y][X][4];
		int x1 = -1;
		int x2 = -1;
		int y1 = -1;
		int y2 = -1;
		
		// dist 값 초기화
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				dist[y][x] = INF;
			}
		}
		
		// graph 값 입력
		for (int y = 0; y < Y; y++) {
			String s = br.readLine();
			for (int x = 0; x < X; x++) {
				char c = s.charAt(x);
				if (c == '.') {
					graph[y][x] = 0;
				} else if (c == '*') {
					graph[y][x] = -1;
				} else if (c == 'C') {
					graph[y][x] = 0;
					if (x1 == -1) {
						x1 = x;
						y1 = y;
					} else {
						x2 = x;
						y2 = y;
					}
				}
			}
		}
		
		dist[y1][x1] = 0;
		// [cost, x,  y, arrow]
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[0],  e2[0]));
		for (int i = 0; i < 4; i++) {
			pq.offer(new int[] { dist[y1][x1], x1, y1, i });
		}
		while (!pq.isEmpty()) {
			int nowCost = pq.peek()[0];
			int nowX = pq.peek()[1];
			int nowY = pq.peek()[2];
			// 0: 상 / 1: 하 / 2: 좌 / 3: 우
			int nowNarrow = pq.peek()[3];
			pq.poll();
			
			if (dist[nowY][nowX] < nowCost) {
				continue;
			}
			
			if (visited[nowY][nowX][nowNarrow]) {
				continue;
			}
			
			visited[nowY][nowX][nowNarrow] = true;

			if (nowX == x2 && nowY == y2) {
				break;
			}

			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (0 <= nextX && nextX < X && 0 <= nextY && nextY < Y) {
					
					// 벽이면은 건너뛰기
					if (graph[nextY][nextX] == -1) {
						continue;
					}

					int nextCost = -1;
					if (nop[i] == i) continue;
					
					// 방향이 유지됨
					if (nowNarrow == i) {
						nextCost = 0;
					// 방향이 바뀜
					} else {
						nextCost = 1;
					}
					
					if (dist[nextY][nextX] >= dist[nowY][nowX] + nextCost) {
						dist[nextY][nextX] = dist[nowY][nowX] + nextCost;
						
						pq.offer(new int[] { dist[nextY][nextX], nextX, nextY, i });
					}
				}
			}
		} // while문 종료
		
		if (isDebug) {
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					if (dist[y][x] == INF) {
						System.out.print("- ");
					} else {
						System.out.print(dist[y][x] + " ");
					}
				}
				System.out.println();
			}
		}
		
		System.out.println(dist[y2][x2]);
		
	}

}
