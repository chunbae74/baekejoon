import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_1584 {
	int index;
	int cost;
	
	Node_1584(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _1584 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int INF = Integer.MAX_VALUE >> 1;
		final int[] dx = new int[] { 0, 0, 1, -1 };
		final int[] dy = new int[] { 1, -1, 0, 0 };
		
		int[][] dist = new int[501][501];
		boolean[][] visited = new boolean[501][501];
		int[][] graph = new int[501][501];

		// 위험지역
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X_1 = Integer.parseInt(st.nextToken());
			int Y_1 = Integer.parseInt(st.nextToken());
			int X_2 = Integer.parseInt(st.nextToken());
			int Y_2 = Integer.parseInt(st.nextToken());
			int X1 = Math.min(X_1, X_2);
			int X2 = Math.max(X_1, X_2);
			int Y1 = Math.min(Y_1, Y_2);
			int Y2 = Math.max(Y_1, Y_2);
			
			for (int x = X1; x <= X2; x++) {
				for (int y = Y1; y <= Y2; y++) {
					graph[y][x] = 1;
				}
			}
		}	
		
		// 죽음지역
		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X_1 = Integer.parseInt(st.nextToken());
			int Y_1 = Integer.parseInt(st.nextToken());
			int X_2 = Integer.parseInt(st.nextToken());
			int Y_2 = Integer.parseInt(st.nextToken());
			int X1 = Math.min(X_1, X_2);
			int X2 = Math.max(X_1, X_2);
			int Y1 = Math.min(Y_1, Y_2);
			int Y2 = Math.max(Y_1, Y_2);
			for (int x = X1; x <= X2; x++) {
				for (int y = Y1; y <= Y2; y++) {
					graph[y][x] = INF;
				}
			}
		}
		
		// { x, y, cost }
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[2], e2[2]));
		pq.offer(new int[] { 0, 0, 0 });
		
		while (!pq.isEmpty()) {
			int nowX = pq.peek()[0];
			int nowY = pq.peek()[1];
			int nowCost = pq.peek()[2];
			pq.poll();
			
			// 죽음지역이면 건너뛰기
			if (graph[nowY][nowX] == INF) continue;
			// 이미 방문했으면 건너뛰기
			if (visited[nowY][nowX]) continue;
		
			// 방문처리
			visited[nowY][nowX] = true;
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				// 범위 바깥은 continue;
				if (nextX < 0 || nextY < 0 || nextX > 500 || nextY > 500) continue;
				// 다음 지역이 죽음지역이면 건너뛰기
				if (graph[nextY][nextX] == INF) continue;
				
				dist[nextY][nextX] = nowCost + 1;
				pq.offer(new int[] { nextX, nextY, nowCost + 1 });
			}
		}
		
		bw.write(dist[500][500] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
