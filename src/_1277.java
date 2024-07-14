import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class _1277 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final double INF = Double.MAX_VALUE;
		final int X = 200_001;
		final int Y = 200_001;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 발전소 개수
		int N = Integer.parseInt(st.nextToken());
		// 이미 연결되어 있는 전선의 개수
		int W = Integer.parseInt(st.nextToken());
		// 줄의 제한길이
		double M = Double.parseDouble(br.readLine());
		
		int[][] cor = new int[N][2];
		double[] dist = new double[N];
		for (int i = 0; i < N; i++) {
			dist[i] = INF;
		}
		
		int startX, startY, endX, endY;
		startX = startY = endX = endY = -1;
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) + 100_000;
			int y = Integer.parseInt(st.nextToken()) + 100_000;
			
			cor[n] = new int[] { x, y };
			
			if (n == 0) {
				startX = x;
				startY = y;
			} else if (n == N - 1) {
				endX = x;
				endY = y;
			}
		}
		
		// 발전기 간 새로 필요한 전선의 길이
		double[][] graph = new double[N][N];
		// i : 시작지점 발전기
		for (int i = 0; i < N; i++) {
			// j : 도착지점 발전기
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				graph[i][j] = graph[j][i] = Math.sqrt(Math.pow(cor[i][0] - cor[j][0], 2) + Math.pow(cor[i][1] - cor[j][1], 2));
			}
		}

		for (int w = 0; w < W; w++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			graph[A][B] = graph[B][A] = 0.0;
		}
		
		// [node, dist[node]]
		PriorityQueue<double[]> pq = new PriorityQueue<>((e1, e2) -> Double.compare(e1[1], e2[1]));
		dist[0] = 0;
		pq.offer(new double[] { 0, dist[0] });
		while (!pq.isEmpty()) {
			int nowNode = (int)pq.peek()[0];
			double nowCost = pq.peek()[1];
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			if (nowNode == N - 1) break;
			
			for (int nextNode = 0; nextNode < N; nextNode++) {
				if (nextNode == nowNode) continue;
				double nextCost = graph[nowNode][nextNode];
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.add(new double[] { nextNode, dist[nextNode] });
				}
			}
		}
		
		int result = (int) (dist[N - 1] * 1000);
		System.out.println(result);
	}

}
