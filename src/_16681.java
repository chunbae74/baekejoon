import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * N: 노드 개수
 * M: 길 개수
 * D: 거리 비례 체력 소모량
 * E: 높이 비례 성취감 획득량
 */
/*
 * 얻은 성취감(E * h)가 크고, 
 * 소모한 체력 (1 * D)가 작아야 함
 */
class Node_16681 {
	int index;
	int cost;
	
	Node_16681(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _16681 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[] distOfClimb = new int[N];
		int[] height = new int[N];
		ArrayList<Node_16681>[] graph = new ArrayList[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			distOfClimb[i] = INF;
			height[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_16681(B, C));
			graph[B].add(new Node_16681(A, C));
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
		distOfClimb[0] = 0;
		pq.offer(new int[] {0, distOfClimb[0] });
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek()[0];
			int nowCost = pq.peek()[1];
			pq.poll();
			
			if (distOfClimb[nowNode] < nowCost) continue;
			
			for (Node_16681 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost;
				
				if ()
			}
		}
	}

}
