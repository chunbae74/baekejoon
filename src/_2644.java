import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2644 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken()) - 1;
		int n2 = Integer.parseInt(st.nextToken()) - 1;
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] graph = new ArrayList[N];
		boolean[] visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken()) - 1;
			int child = Integer.parseInt(st.nextToken()) - 1;
			graph[parent].add(child);
			graph[child].add(parent);
		}
		
		Queue<int[]> queue = new LinkedList<>();
		visited[n1] = true;
		queue.offer(new int[] { n1, 0 });
		while (!queue.isEmpty()) { 
			int nowNode = queue.peek()[0];
			int nowCost = queue.peek()[1];
			queue.poll();
			
			if (nowNode == n2) {
				System.out.println(nowCost);
				System.exit(0);
			}
			
			for (int nextNode: graph[nowNode]) {
				if (visited[nextNode]) continue;
				visited[nextNode] = true;
				queue.offer(new int[] { nextNode, nowCost + 1 });
			}
		}
		
		System.out.println(-1);
	}

}
