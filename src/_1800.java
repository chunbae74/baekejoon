import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * P: 케이블선의 개수
 * K: 공짜로 제공하는 케이블선의 개수
 */

class Node_1800 {
	int index;
	int cost;
	
	Node_1800(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _1800 {
	static int N, K;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node_1800>[] graph;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N];
		dist = new int[N];
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int p = 0; p < P; p++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_1800(B, C));
			graph[B].add(new Node_1800(A, C));
		}
		
		long start = 0;
		long end = INF;
		int ans = -1;
		while (start <= end) {
			// mid : 원장쌤이 내는 금액
			long mid = (start + end) >> 1;
		
			// mid로 설치가 가능 -> mid값을 더 줄이기
			if (dikjstra(mid)) {
				ans = (int) mid;
				end = mid - 1;
			}
			// mid로 설치가 불가능 -> mid값 증가시키기
			else {
				start = mid + 1;
			}
		}
		
		System.out.println(ans + "");
	}
	
	public static boolean dikjstra(long costStandard) {
		for (int i = 0; i < N; i++) {
			dist[i] = INF;
		}
		
		PriorityQueue<Node_1800> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[0] = 0;
		pq.offer(new Node_1800(0, dist[0]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_1800 next: graph[nowNode]) {
				int nextNode = next.index;
				// costStandard 값보다 크면 1, 이하면은 0
				int nextCost = (next.cost > costStandard) ? 1 : 0;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_1800(nextNode, dist[nextNode]));
				}
			}
		}
		
		return dist[N - 1] <= K;
	}

}
