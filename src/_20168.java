import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_20168 {
	int index;
	int cost;
	
	Node_20168(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

/*
 * N: 노드 개수
 * M: 골목 개수
 * START: 시작 노드
 * END: 도착 노드
 * MONEYIVGOT: 가진 돈
 */
public class _20168 {
	static final int INF = 1_000 + 1;
	static int N, M, START, END, MONEYIVGOT;
	static int[][] dist;
	static ArrayList<Node_20168>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		START = Integer.parseInt(st.nextToken()) - 1;
		END = Integer.parseInt(st.nextToken()) - 1;
		MONEYIVGOT = Integer.parseInt(st.nextToken());
		
		dist = new int[N][2];
		graph = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			dist[i] = new int[] { INF, INF };
			graph[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_20168(B, C));
			graph[B].add(new Node_20168(A, C));
		}
		
		int ans = -1;
		int start = 0;
		int end = INF;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (dikjstra(mid)) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(ans);
		
	}

	public static boolean dikjstra(int costStandard) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> {
			if (e1[1] > e2[1]) {
				return 1;
			} else if (e1[1] < e2[1]) {
				return -1;
			} else {
				return e1[2] - e2[2];
			}
		});
		for (int i = 0; i < N; i++) {
			dist[i] = new int[] { INF, INF };
		}
		
		dist[START] = new int[] { 0, 0 };
		pq.offer(new int[] { START, dist[START][0], dist[START][1] } );
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek()[0];
			int nowCost = pq.peek()[1];
			int sum = pq.peek()[2];
			pq.poll();
			
			if (sum > MONEYIVGOT) continue;
			if (dist[nowNode][0] < nowCost) continue;
			
			for (Node_20168 next: graph[nowNode]) {
				int nextNode = next.index;
				// costStandard보다 크면 1, 이하이면 0
				int nextCost = (next.cost > costStandard) ? 1 : 0;
				
				if (dist[nextNode][0] > dist[nowNode][0] + nextCost) {
					dist[nextNode][0] = dist[nowNode][0] + nextCost;
					dist[nextNode][1] = sum + next.cost;
					if (dist[nextNode][1] > MONEYIVGOT) continue;
					pq.add(new int[] { nextNode, dist[nextNode][0], dist[nextNode][1]});
				} else if (dist[nextNode][0] == dist[nowNode][0] + nextCost) {
					if (dist[nextNode][1] > sum + next.cost) {
						dist[nextNode][1] = sum + next.cost;
						if (dist[nextNode][1] > MONEYIVGOT) continue;
						pq.add(new int[] { nextNode, dist[nextNode][0], dist[nextNode][1]});
					}
				}
			}
		}
		
		return dist[END][0] == 0 && dist[END][1] <= MONEYIVGOT;
	}

}
