import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_16118 {
	int index;
	int cost;
	
	Node_16118(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _16118 {
	static int N;
	static final int INF = 4_000 * 100_000 * 2 + 1;
	static ArrayList<Node_16118>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i ++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			C *= 2;
			graph[A].add(new Node_16118(B, C));
			graph[B].add(new Node_16118(A, C));
		}
		int[] distOfFox = dikjstraForFox(1);
		int[][] distOfWolf = dikjstraForWolf(1);
		
		int count = 0;
		for (int i = 2; i < N + 1; i++) {
			if (distOfFox[i] < Math.min(distOfWolf[i][0], distOfWolf[i][1])) {
				count ++;
			}
		}
		
		System.out.println(Arrays.deepToString(distOfWolf));
		System.out.println(count);
	}
	
	public static int[] dikjstraForFox(int start) {
		int[] dist = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			dist[i] = INF;
		}
		
		dist[start] = 0;
		PriorityQueue<Node_16118> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		pq.offer(new Node_16118(start, dist[start]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) {
				continue;
			}
			
			for (Node_16118 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;

				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_16118(nextNode, dist[nextNode]));
				}
			}
			
		}
		return dist;
	}
	
	public static int[][] dikjstraForWolf(int start) {
		int[][] dist = new int[N + 1][2];
		boolean[][] visited = new boolean[N + 1][2];
		for (int i = 1; i < N + 1; i++) {
			dist[i] = new int[] { INF, INF };
		}
		
		dist[start] = new int[] { 0, 0 };
		// [node, dist[node][index], index]
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
		pq.offer(new int[] { start, dist[start][0], 1 });

		while (!pq.isEmpty()) {
			int nowNode = pq.peek()[0];
			int nowCost = pq.peek()[1];
			// 0 : preNode -> nowNode 시간 1/2배
			// 1 : preNode -> nowNode 시간 2배
			int nowIdx = pq.peek()[2];
			pq.poll();
			
			if (visited[nowNode][nowIdx]) {
				continue;
			}
			
			visited[nowNode][nowIdx] = true;
			
			for (Node_16118 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				int nextIdx = (nowIdx == 0) ? 1 : 0;
				if (nowIdx == 0) {
					nextCost /= 2;
				} else {
					nextCost *= 2;
				}
				
				int distOfNowNode = Math.min(dist[nowNode][0], dist[nowNode][1]);
				if (dist[nextNode][nextIdx] > distOfNowNode + nextCost) {
					dist[nextNode][nextIdx] = distOfNowNode + nextCost;
					pq.offer(new int[] { nextNode, dist[nextNode][nextIdx], nextIdx });
				}
			}
		}
		
		return dist;
	}

}
