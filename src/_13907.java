import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_13907 {
	int index;
	int cost;
	
	Node_13907(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

/*
 * 참고ㅣ
 * https://wjdtn7823.tistory.com/19
 */
/*
 * 반례ㅣ
 * https://www.acmicpc.net/board/view/89579
 */
public class _13907 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// dist[i][j] : j개의 도시를 거쳐 i까지 가는 데 드는 비용
		int[][] dist = new int[N][N];
		ArrayList<Node_13907>[] graph = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				dist[i][j] = INF;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int START = Integer.parseInt(st.nextToken()) - 1;
		int END = Integer.parseInt(st.nextToken()) - 1;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_13907(B, C));
			graph[B].add(new Node_13907(A, C));
		}
		
		// [node, dist[node], 지나간 도시 개수]
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
		dist[START][0] = 0;
		pq.offer(new int[] { START, dist[START][0], 0 });
		while (!pq.isEmpty()) {
			int nowNode = pq.peek()[0];
			int nowCost = pq.peek()[1];
			int nowCount = pq.peek()[2];
			pq.poll();
			
			if (dist[nowNode][nowCount] < nowCost) continue;
			if (nowCount >= N - 1) continue;
			
			Loop1: for (Node_13907 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = nowCost + next.cost;
				
				for (int i = 0; i <= nowCount; i++) {
					if (dist[nextNode][i] <= nextCost) continue Loop1;
				}
				
				if (dist[nextNode][nowCount + 1] > nextCost) {
					dist[nextNode][nowCount + 1] = nextCost;
					pq.offer(new int[] { nextNode, dist[nextNode][nowCount + 1], nowCount + 1 });
				}
			}
		}
		
		int min = INF;
		for (int i = 0; i < N; i++) {
			min = Math.min(min, dist[END][i]);
		}
		
		System.out.println(min);
		
		int tax = 0;
		for (int k = 0; k < K; k++) {
			tax += Integer.parseInt(br.readLine());
			min = INF;
			for (int i = 0; i < N; i++) {
				min = Math.min(min, tax * i + dist[END][i]);
			}
			
			System.out.println(min);
		}
		
	}

}
