import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_12763 {
	int index;
	int time;
	int cost;
	
	Node_12763(int index, int time, int cost) {
		this.index = index;
		this.time = time;
		this.cost = cost;
	}
}

/*
 * T분 내에 최소 지출로 도착
 */
public class _12763 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		
		int N = Integer .parseInt(br.readLine());
		ArrayList<Node_12763>[] graph = new ArrayList[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 수업 출석까지 남은 시간 (1 <= T <= 10_000)
		int T = Integer.parseInt(st.nextToken());
		// 현재 가지고 있는 돈
		int M = Integer.parseInt(st.nextToken());
		// dist[i][j] : j시간 내에 i에 도착했을 때의 비용
		int[][] dist = new int[N][T + 1];
		
		for (int n = 0; n < N; n++) {
			graph[n] = new ArrayList<>();
			for (int t = 0; t < T + 1; t++) {
				dist[n][t] = INF;
			}
		}
		
		int L = Integer.parseInt(br.readLine());
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			// 이동시간
			int C = Integer.parseInt(st.nextToken());
			// 택시비
			int D = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_12763(B, C, D));
			graph[B].add(new Node_12763(A, C, D));
		}
		
		// { node, time, dist[node][time] }
		PriorityQueue<Node_12763> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[0][0] = 0;
		pq.offer(new Node_12763(0, 0, dist[0][0]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowTime = pq.peek().time;
			int nowMoneySpent = pq.peek().cost;
			pq.poll();
			
			// 제한된 시간내에 도착하지 못하는 케이스는 배제
			if (nowTime > T) continue;
			// 가지고 있는 돈으로 갈 수 없는 케이스는 배제
			if (nowMoneySpent > M) continue;
			
			if (dist[nowNode][nowTime] < nowMoneySpent) continue;
			
			for (Node_12763 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextTime = nowTime + next.time;
				int nextMoney = nowMoneySpent + next.cost;
				
				// 제한된 시간내에 도착하지 못하는 케이스는 배제
				if (nextTime > T) continue;
				// 가지고 있는 돈으로 갈 수 없는 케이스는 배제
				if (nextMoney > M) continue;
				
				if (dist[nextNode][nextTime] > nextMoney) {
					dist[nextNode][nextTime] = nextMoney;
					pq.offer(new Node_12763(nextNode, nextTime, dist[nextNode][nextTime]));
				}
			}
		}
		
		int min = INF;
		for (int t = 0; t < T + 1; t++) {
			min = Math.min(min, dist[N - 1][t]);
		}
		System.out.println(min == INF ? -1 : min);
	}

}
