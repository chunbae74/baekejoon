import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_5719 {
	int index;
	int cost;
	
	Node_5719(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

/*
 * 풀이 참고ㅣ
 * https://www.acmicpc.net/board/view/65679
 * https://loosie.tistory.com/599
 */

/*
 * 반례ㅣ
 * https://www.acmicpc.net/board/view/126030
 * https://www.acmicpc.net/board/view/103180
 * https://www.acmicpc.net/board/view/102349
 */
public class _5719 {
	static final int INF = Integer.MAX_VALUE >> 1;
	static int N, M, START, END;
	
	static ArrayList<Node_5719>[] graph;
	static ArrayList<Integer>[] backTracking;
	static boolean[][] isForbidden;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;

		while (!(input = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N];
			backTracking = new ArrayList[N];
			isForbidden = new boolean[N][N];
			
			// 초기화
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
				backTracking[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			START = Integer.parseInt(st.nextToken());
			END = Integer.parseInt(st.nextToken());
			
			// 경로 입력
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				graph[A].add(new Node_5719(B, C));
			}
			
			firstDijkstra();
			
			updateForbidden(START, END);
			
			int ans = finalDijkstra();

			System.out.println(ans == INF ? -1 : ans);
		} // 테스트케이스 종료
	}
	
	
	/**
	 * 최단거리 다익스트라
	 */
	public static void firstDijkstra() {
		int[] dist = new int[N];
		for (int i = 0; i < N; i++) {
			dist[i] = INF;
		}
		
		PriorityQueue<Node_5719> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[START] = 0;
		pq.offer(new Node_5719(START, dist[START]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_5719 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					
					// 경로 초기화 후 추가
					backTracking[nextNode] = new ArrayList<>();
					backTracking[nextNode].add(nowNode);
					pq.offer(new Node_5719(nextNode, dist[nextNode]));
				} else if (dist[nextNode] == dist[nowNode] + nextCost) {
					// 경로"만" 최신화. pq에 추가 ㄴㄴ
					backTracking[nextNode].add(nowNode);
				}
			}
		} //  다익스트라 종료
	}
	
	
	/**
	 * 최단거리 도로 봉쇄
	 */
	public static void updateForbidden(int start, int nowNode) {
		// 출발지점까지 다다름
		if (start == nowNode) return;
		for (int preNode: backTracking[nowNode]) {
			if (!isForbidden[preNode][nowNode]) {
				isForbidden[preNode][nowNode] = true;
				updateForbidden(start, preNode);
			}
		}
	}
	
	
	/**
	 * 거의 최단 거리다익스트라
	 * @return : dist[END]
	 */
	public static int finalDijkstra() {
		PriorityQueue<Node_5719> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		int[] dist = new int[N];
		for (int i = 0; i < N; i++) {
			dist[i] = INF;
		}

		dist[START] = 0;
		pq.offer(new Node_5719(START, dist[START]));

		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;

			if (nowNode == END) break;
			
			for (Node_5719 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				// 금지된 길이면 건너뛰기
				if (isForbidden[nowNode][nextNode]) continue;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_5719(nextNode, dist[nextNode]));
				}
			}
		} // 다익스트라 종료
		
		return dist[END];
	}
}
