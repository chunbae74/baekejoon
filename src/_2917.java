import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 테케 : https://www.acmicpc.net/board/view/99430
 */
public class _2917 {
	static final boolean isDebug = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		final int[] dx = { 0, 0, 1, -1 };
		final int[] dy = { 1, -1, 0, 0 };
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		char[][] graph = new char[Y][X];
		int[][] dist = new int[Y][X];
		int[][] result = new int[Y][X];
		
		int startX, startY;
		int endX, endY;
		startX = startY = endX = endY = -1;
		
		// 그래프 값 입력
		for (int y = 0; y < Y; y++) {
			String input = br.readLine();
			for (int x = 0; x < X; x++) {
				graph[y][x] = input.charAt(x);
				if (graph[y][x] == 'V') {
					startX = x;
					startY = y;
				} else if (graph[y][x] == 'J') {
					endX = x;
					endY = y;
				}
				
				dist[y][x] = INF;
				result[y][x] = -1;
			}
		}
		
		// 나무와의 거리 계산
		// [x, y, dist[y][x]]
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[2], e2[2]));
		// 나무(=시작점) 모두 pq에 넣어주기
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				char c = graph[y][x];
				// 나무라면
				if (c == '+') {
					dist[y][x] = 0;
					pq.offer(new int[] { x, y, dist[y][x] });
				}
			}
		}
		
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
				
				if (dist[nextY][nextX] > dist[nowY][nowX] + 1) {
					dist[nextY][nextX] = dist[nowY][nowX] + 1;
					pq.offer(new int[] { nextX, nextY, dist[nextY][nextX] });
				}
			}
		}
		
		int min = dist[startY][startX];
		// 나무와의 거리의 최솟값이 가장 큰 경로로 이동
		pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e2[2], e1[2]));
		pq.offer(new int[] { startX, startY, dist[startY][startX] });
		while (!pq.isEmpty()) {
			int nowX = pq.peek()[0];
			int nowY = pq.peek()[1];
			int nowCost = pq.peek()[2];
			pq.poll();
			
			if (result[nowY][nowX] > nowCost) continue;
			
			if (nowX == endX && nowY == endY) break;
			
			min = Math.min(min, nowCost);
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y) continue;

				int nextCost = dist[nextY][nextX];
				
				if (result[nextY][nextX] < nextCost) {
					result[nextY][nextX] = nextCost;
					pq.offer(new int[] { nextX, nextY, result[nextY][nextX] });
				}
			}
		}
		
		if (isDebug) {
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					System.out.print(result[y][x] + " ");
				}
				System.out.println();
			}
		}
		
		System.out.println(min);
	}
}
