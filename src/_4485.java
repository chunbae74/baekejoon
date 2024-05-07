import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _4485 {
	static int[][] map;
	static boolean[][] visited;
	static int[][] dist;
	
	static int N;
	static final int[] dx = new int[] { 1, -1, 0, 0 };
	static final int[] dy = new int[] { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int idx = 1;
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			map = new int[N][N];
			dist = new int[N][N];
			
			for (int y = 0; y < N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
					dist[y][x] = Integer.MAX_VALUE;
				}
			}
			
			dijkstra();
			
			sb.append("Problem ").append(idx++).append(": ").append(dist[N-1][N-1]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
		
	public static void dijkstra() {
		boolean[][] visited = new boolean[N][N];
		dist[0][0] = map[0][0];
		// int[] = { x, y, cost }
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[2], e2[2]));
		pq.offer(new int[] { 0, 0, dist[0][0] });
		
		while (!pq.isEmpty()) {
			int nowX = pq.peek()[0];
			int nowY = pq.peek()[1];
			pq.poll();
			
			if (visited[nowY][nowX]) continue;
			
			if (nowX == (N - 1) && nowY == (N - 1)) {
				break;
			}
			
			visited[nowY][nowX] = true;
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				if (visited[nextY][nextX]) continue;
				
				int nextCost = map[nextY][nextX];
				if (dist[nextY][nextX] > dist[nowY][nowX] + nextCost) {
					dist[nextY][nextX] = dist[nowY][nowX] + nextCost;
					pq.offer(new int[] { nextX, nextY, dist[nextY][nextX] });
				}
			}
		}
	}

}
