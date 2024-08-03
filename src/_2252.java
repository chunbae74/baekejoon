import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 24.08.03ㅣ 3% 메모리초과
 */
public class _2252 {
	static int N;
	static ArrayList<Integer>[] graph;
	static int[] parentNode;
	// { node, depth }
	static PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		parentNode = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			parentNode[i] = i;
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			graph[parent].add(child);
			parentNode[child] = parent;
		}
		
		for (int n = 1; n <= N; n++) {
			getRootNode(n);
		}
		
		for (int i = 1; i <= N; i++) {
			if (parentNode[i] == i) {
				pq.offer(new int[] { i, 0 });
				putPq(i, 0);
			}
		}
		
		boolean[] visited = new boolean[N + 1];
		while (!pq.isEmpty()) {
			int n = pq.poll()[0];
			if (!visited[n]) {
				visited[n] = true;
				System.out.print(n + " ");
			}
		}
	}
	
	/**
	 * 루트노드를 구하는 함수
	 * @param child 부모가 누군지 알고싶은 자식노드
	 * @return rootNode
	 */
	public static int getRootNode(int child) {
		if (parentNode[child] == child) return child;
		else return getRootNode(parentNode[child]);
	}

	public static void putPq(int node, int depth) {
		for (int child: graph[node]) {
			pq.offer(new int[] { child, depth + 1});
			putPq(child, depth + 1);
		}
	}

}
