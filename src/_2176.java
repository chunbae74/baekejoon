import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node_2176 {
	int index;
	int cost;
	
	Node_2176(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _2176 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int INF = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Node_2176>[] graph = new ArrayList[N];
		int[][] dist = new int[N][N];
		
		for (int n = 0; n < N; n++) {
			graph[n] = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				dist[n][i] = INF;
			}
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_2176(B, C));
			graph[B].add(new Node_2176(A, C));
		}
		
		// 거리 구하기
		// [시작점, nowNode, dist[nowNode]]
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[2], e2[2]));
		for (int i = 0; i < N; i++) {
			dist[i][i] = 0;
			pq.offer(new int[] { i, i, dist[i][i] });
		}
		while (!pq.isEmpty()) {
			int start = pq.peek()[0];
			int nowNode = pq.peek()[1];
			int nowCost = pq.peek()[2];
			pq.poll();
			
			if (dist[start][nowNode] < nowCost) continue;
			
			for (Node_2176 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (dist[start][nextNode] > dist[start][nowNode] + nextCost) {
					dist[start][nextNode] = dist[nextNode][start] = dist[start][nowNode] + nextCost;
					pq.offer(new int[] { start, nextNode, dist[start][nextNode] });
				}
			}
		}
		
		int shortest = dist[0][1];
		int ans = 0;
		Queue<Node_2176> queue = new LinkedList<>();
		queue.offer(new Node_2176(0, 0));
		while (!queue.isEmpty()) {
			int nowNode = queue.peek().index;
			int nowCost = queue.peek().cost;
			queue.poll();
			
			if (nowNode == 1) {
				ans ++;
				continue;
			}
			
			for (Node_2176 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (shortest > dist[nextNode][1]) {
					queue.offer(new Node_2176(nextNode, nextCost));
				}
			}
		}
		
		System.out.println(ans);
	}

}
