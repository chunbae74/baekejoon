import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 테스트케이스 : https://www.acmicpc.net/board/view/128733
public class _2151 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = 51 * 51;
		final int[] dx = { 0, 0, -1, 1 };
		final int[] dy = { -1, 1, 0, 0 };
		final int[] nop = { 1, 0, 3, 2 };
			
		int N = Integer.parseInt(br.readLine());
		int[][][] dist = new int[N][N][4];
		
		// dist 그래프 초기화
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				for (int i = 0; i < 4; i++) {
					dist[y][x][i] = INF;
				}
			}
		}
		
		// -1 : 벽(*)
		// 0 : 빈공간(.)
		// 1 : 거울을 설치할 수 있는 위치(!)
		// 2 : 문(#)
		int[][] graph = new int[N][N];
		
		int x1 = -1;
		int x2 = -1;
		int y1 = -1;
		int y2 = -1;
		
		// graph 값 입력
		for (int y = 0; y < N; y++) {
			String s = br.readLine();
			for (int x = 0; x < N; x++) {
				char c = s.charAt(x);
				if (c == '*') {
					graph[y][x] = -1;
				} else if (c == '.') {
					graph[y][x] = 0;
				} else if (c == '!') {
					graph[y][x] = 1;
				} else if (c == '#') {
					if (x1 == -1) {
						x1 = x;
						y1 = y;
					} else {
						x2 = x;
						y2 = y;
					}
					graph[y][x] = 2;
				}
			}
		}
		
		// [dist[y][x], x, y, arrow]
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[0], e2[0]));
		for (int i = 0; i < 4; i++) {
			dist[y1][x1][i] = 0;
			pq.offer(new int[] { dist[y1][x1][i], x1, y1, i });
		}
		
		while (!pq.isEmpty()) {
			int nowCost = pq.peek()[0];
			int nowX = pq.peek()[1];
			int nowY = pq.peek()[2];
			int nowArrow = pq.peek()[3];
			pq.poll();
			
			if (dist[nowY][nowX][nowArrow] < nowCost) {
				continue;
			}
			
			// 상, 하, 좌, 우 순.
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (0 > nextX || nextX >= N || 0 > nextY || nextY >= N) {
					continue;
				}
				
				// 벽이면은 건너뛰기
				if (graph[nextY][nextX] == -1) {
					continue;
				}
				
				// (preX, preY) -> (nowX, nowY) -> (preX, preY)인 상황
				// = 제자리걸음
				if (nop[i] == i) continue;
				
				int nextCost = -1;
				
				//System.out.printf("nowX = %d\tnowY = %d\tnextX = %d\tnextY = %d\n", nowX, nowY, nextX, nextY);
				// 방향 유지된다면
				if (nowArrow == i) {
					nextCost = 0;
				// 방향이 유지되지 않는다면
				} else {
					// 거울이 위치할 수 있는 장소가 아니라면
					// = 방향을 틀을 수 없는 위치라면
					if (graph[nowY][nowX] != 1) {
						continue;
					}

					nextCost = 1;
				}
				
				if (dist[nextY][nextX][i] >= dist[nowY][nowX][nowArrow] + nextCost) {
					dist[nextY][nextX][i] = dist[nowY][nowX][nowArrow] + nextCost;
					pq.offer(new int[] { dist[nextY][nextX][i], nextX, nextY, i });
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			min = Math.min(min, dist[y2][x2][i]);
		}
		
		System.out.println(min);
	}

}
