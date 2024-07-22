import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _10473 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 2;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double startX = Double.parseDouble(st.nextToken());
		double startY = Double.parseDouble(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		double endX = Double.parseDouble(st.nextToken());
		double endY = Double.parseDouble(st.nextToken());
		
		// 대포의 개수
		int N = Integer.parseInt(br.readLine());
		
		double[][] cordinate = new double[N + 2][2];
		
		cordinate[0] = new double[] { startX, startY };
		cordinate[N + 1] = new double[] { endX, endY };
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			cordinate[n] = new double[] { x, y };
		}
		
		double[] dist = new double[N + 2];
		double[][] graph = new double[N + 2][N + 2];
		
		// 노드별 거리 계산
		for (int y = 0; y < N + 2; y++ ) {
			dist[y] = INF;
			
			for (int x = 0; x < N + 2; x++) {
				if (x == y) graph[x][y] = graph[y][x] = 0;
				else {
					double sX = cordinate[y][0];
					double sY = cordinate[y][1];
					double eX = cordinate[x][0];
					double eY = cordinate[x][1];
					graph[y][x] = graph[x][y] = Math.sqrt(Math.pow(sX - eX, 2) + Math.pow(sY - eY, 2));
				}
			}
		}
		
		dist[0] = 0;
		// [nowNode, dist[nowNode]]
		PriorityQueue<double[]> pq = new PriorityQueue<>((e1, e2) -> Double.compare(e1[1], e2[1]));
		pq.offer(new double[] { 0.0, dist[0] });
		
		while (!pq.isEmpty()) {
			int nowNode = (int)pq.peek()[0];
			double nowCost = pq.peek()[1];
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			if (nowNode == N + 1) break;
			
			for (int nextNode = 0; nextNode < N + 2; nextNode++) {
				if (nowNode == nextNode) continue;
				double disBtw = graph[nowNode][nextNode];
				double nextCost = disBtw / 5;
				if (nowNode != 0) nextCost = Math.min(nextCost, 2 + (Math.abs(disBtw - 50) / 5));
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new double[] { nextNode, dist[nextNode] });
				}
			}
		}
		
		System.out.println(dist[N + 1]);
	}

}
