import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_23793 {
	int index;
	int cost;
	
	Node_23793(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _23793 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int INF = Integer.MAX_VALUE >> 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] distToY = new int[N];
		int[] distFromY = new int[N];
		int[] distWithoutY = new int[N];
		ArrayList<Node_23793>[] graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
			distToY[i] = distFromY[i] = distWithoutY[i] = INF;
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_23793(B, C));
		}
		
		st = new StringTokenizer(br.readLine());
		int START = Integer.parseInt(st.nextToken()) - 1;
		int Y = Integer.parseInt(st.nextToken()) - 1;
		int END = Integer.parseInt(st.nextToken()) - 1;
		
		// 1. X -> Y
		PriorityQueue<Node_23793> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		distToY[START] = 0;
		pq.offer(new Node_23793(START, distToY[START]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();

			if (distToY[nowNode] < nowCost) continue;
			
			if (nowNode == Y) break;
			
			for (Node_23793 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (distToY[nextNode] > distToY[nowNode] + nextCost) {
					distToY[nextNode] = distToY[nowNode] + nextCost;
					pq.offer(new Node_23793(nextNode, distToY[nextNode]));
				}
			}
		}
		
		// 2. Y -> Z
		pq.clear();
		distFromY[Y] = 0;
		pq.offer(new Node_23793(Y, distFromY[Y]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();

			if (distFromY[nowNode] < nowCost) continue;
			
			if (nowNode == END) break;
			
			for (Node_23793 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (distFromY[nextNode] > distFromY[nowNode] + nextCost) {
					distFromY[nextNode] = distFromY[nowNode] + nextCost;
					pq.offer(new Node_23793(nextNode, distFromY[nextNode]));
				}
			}
		}
		
		// 3. X -> Z (without Y)
		pq.clear();
		distWithoutY[START] = 0;
		pq.offer(new Node_23793(START, distWithoutY[START]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (distWithoutY[nowNode] < nowCost) continue;
			
			if (nowNode == Y) continue;
			
			if (nowNode == END) break;
			
			for (Node_23793 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				if (nextNode == Y) continue;
				
				if (distWithoutY[nextNode] > distWithoutY[nowNode] + nextCost) {
					distWithoutY[nextNode] = distWithoutY[nowNode] + nextCost;
					pq.offer(new Node_23793(nextNode, distWithoutY[nextNode]));
				}
			}
		}
		
		if (distToY[Y] == INF || distFromY[END] == INF) {
			System.out.print("-1 ");
		} else {
			System.out.print((distToY[Y] + distFromY[END]) + " ");
		}
		
		if (distWithoutY[END] == INF) {
			System.out.print("-1");
		} else {
			System.out.print(distWithoutY[END]);
		}
		
		
	}

}
