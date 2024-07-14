import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 떡은 한 번에 한 개씩만
 * 가장 가까운 집부터 방문
 */
class Node_20007 {
	int index;
	int cost;
	
	Node_20007(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _20007 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		
		/*
		 * N: 노드 개수
		 * M: 간선 개수
		 * MAXLEN: 하루 최대 이동거리
		 * START: 성현이의 집
		 */
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int MAXLEN = Integer.parseInt(st.nextToken());
		int START = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[N];
		ArrayList<Node_20007>[] graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			dist[i] = INF;
			graph[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_20007(B, C));
			graph[B].add(new Node_20007(A, C));
		}
		
		// 다익스트라 1: 성현 집에서 이웃집까지의 최단거리 구하기
		PriorityQueue<Node_20007> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[START] = 0;
		pq.offer(new Node_20007(START, dist[START]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_20007 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_20007(nextNode, dist[nextNode]));
				}
			}
		}
		
		// 이웃집으로 갈 수 있는 길이 없는 경우
		for (int n: dist) {
			if (n == INF) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		
		// 가까운 곳부터 방문 고고
		int day = 1;
		int nowLen = 0;
		// 거리가 가까운 곳 부터 방문
		for (int i = 0; i < N; i++) {
			pq.offer(new Node_20007(i, dist[i]));
		}
		
		while (!pq.isEmpty()) {
			int nowCost = pq.peek().cost;
			pq.poll();
			
			// 이웃집에 모두 방문할 수 없는 경우
			if (nowCost << 1 > MAXLEN) {
				System.out.println(-1);
				System.exit(0);
			}
			
			if (nowLen + (nowCost << 1) > MAXLEN) {
				day ++;
				nowLen = 0;
			}

			nowLen += nowCost << 1;
		}
		
		System.out.println(day);
	}
}
