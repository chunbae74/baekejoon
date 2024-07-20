import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_1162 {
	int index;
	int cost;
	int sum;
	
	Node_1162(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
	
	Node_1162(int index, int cost, int sum) {
		this.index = index;
		this.cost = cost;
		this.sum = sum;
	}
}

public class _1162 {
	static final int INF = Integer.MAX_VALUE >> 1;
	static int N, M, K;
	static int[][] graph;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 포장할 수 있는 도로의 수
		K = Integer.parseInt(st.nextToken());
	
		graph = new int[N][N];
		dist = new int[N];
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (x == y) graph[y][x] = 0;
				graph[y][x] = INF;
			}
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			C = Math.min(C, Math.min(graph[A][B], graph[B][A]));
			graph[A][B] = graph[B][A] = C;
		}
		
		int l = 0;
		int r = INF;
		int ans = -1;
		
		while (l <= r) {
			int mid = (l + r) / 2;
			
			int[] di = dijkstra(mid);
			boolean tf = di[0] <= K;
			int sum = di[1];
			System.out.printf("l = %d\tr = %d\tmid = %d\ttf = %b \t sum = %d\n", l, r, mid, tf, sum);
			// mid 값을 좀 더 낮춰도 됨
			if (tf) {
				ans = sum;
				r = mid - 1;
			// mid 값을 좀 더 높혀도 됨
			} else {
				l = mid + 1;
			}
		}
		
		System.out.println(ans);
	}
	
	public static int[] dijkstra(int standard) {
		for (int i = 0; i < N; i++) {
			dist[i] = INF;
		}
		PriorityQueue<Node_1162> pq = new PriorityQueue<>((e1,e2) -> Integer.compare(e1.cost, e2.cost));
		dist[0] = 0;
		pq.offer(new Node_1162(0, dist[0], 0));
		int sum = -1;
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			int nowSum = pq.peek().sum;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			if (nowNode == N - 1) {
				sum = nowSum;
				break;
			}
			
			for (int nextNode = 0; nextNode < N; nextNode++) {
				if (nowNode == nextNode) continue;
				if (graph[nowNode][nextNode] == INF) continue;
				
				int nextCost = graph[nowNode][nextNode] >= standard ? 1 : 0;
				int nextSum = nowSum + (nextCost == 1 ? 0 : graph[nowNode][nextNode]);
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_1162(nextNode, dist[nextNode], nextSum));
				}
			}
		}
		
		return new int[] { dist[N - 1], sum };
	}
}
