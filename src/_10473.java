import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
		
		double[][] cordinate = new double[N][2];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			cordinate[n] = new double[] { x, y };
		}
		
		double[] dist = new double[N + 2];
		double[][] graph = new double[N + 2][N + 2];
		
		for (int y = 0; y < N + 2; y++ ) {
			dist[y] = INF;
			
			for (int x = 0; x < N + 2; x++) {
				// a->대포
				if (y == 0) {
					// a -> a (제자리)
					if (x == 0) graph[y][x] = 0;
					// a -> b (걸어서만)
					else if (x == N + 1) {
						graph[y][x] = Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY- endY, 2)) / 5;
					}
					// a -> 대포 (걸어서만)
					else {
						double cannonX = cordinate[x - 1][0];
						double cannonY = cordinate[x - 1][0];
						graph[y][x] = Math.sqrt(Math.pow(startX - cannonX, 2) + Math.pow(startY - cannonY, 2));
					}
				}
				// b->대포
				else if (y == N + 1) {
					// b -> b (제자리)
					if (x == N + 1) continue;
					// b -> a (걸어서만)
					else if (x == 0) {
						graph[y][x] = Math.sqrt(Math.pow(startX - endX, 2) + Math.pow(startY- endY, 2)) / 5;
					}
					// b -> 대포 (걸어서만)
					else {
						double cannonX = cordinate[x - 1][0];
						double cannonY = cordinate[x - 1][0];
						graph[y][x] = Math.sqrt(Math.pow(endX - cannonX, 2) + Math.pow(endY - cannonY, 2));
					}
				}
				// 대포
				else {
					double nowX = cordinate[y - 1][0];
					double nowY = cordinate[y - 1][1];
					double tarX, tarY;
					
					if (x == 0) {
						tarX = startX;
						tarY = startY;
					} else if (x == N + 1) {
						tarX = endX;
						tarY = endY;
					} else {
						tarX = cordinate[x - 1][0];
						tarY = cordinate[x - 1][1];
					}
					
					double distance = Math.sqrt(Math.pow(nowX - tarX, 2) + Math.pow(nowY - tarY, 2));
					// 거리가 50m 이상이라면
					if (distance >= 50) {
						graph[y][x] = (distance - 50) / 5 + 2;
					}
					// 거리가 50m 이하라면
					else {
						// 그냥 쌩으로 걸어가기
						double cal1 = distance / 5;
						// 대포타고 날아간 뒤 걸어가기
						double cal2 = (50 - distance) / 5 + 2;
						graph[y][x] = Math.min(cal1, cal2);
					}
				}
			}
		} // 이중for문 끝
		
		dist[0] = 0;
		// [nowNode, dist[nowNode]]
		PriorityQueue<double[]> pq = new PriorityQueue<>((e1, e2) -> Double.compare(e1[1], e2[1]));
		pq.offer(new double[] { 0.0, dist[0] });
		
		while (!pq.isEmpty()) {
			int nowNode = (int)pq.peek()[0];
			double nowCost = pq.peek()[1];
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			for (int i = 0; i < N + 2; i++) {
				if (i == nowNode) continue;
				int nextNode = i;
				double nextCost = graph[nowNode][i];
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new double[] { nextNode, dist[nextNode] });
				}
			}
		}

		for (int y = 0; y < N + 2; y++ ) {
			for (int x = 0; x < N + 2; x++) {
				System.out.print(graph[y][x] + "\tㅣ\t");
			}
			System.out.println();
		}
		System.out.println(dist[N + 1]);
	}

}
