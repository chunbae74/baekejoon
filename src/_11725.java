import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11725 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		int[] parents = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			graph[A].add(B);
			graph[B].add(A);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			for (int nextNode: graph[nowNode]) {
				if (visited[nextNode]) continue;
				visited[nextNode] = true;
				parents[nextNode] = nowNode;
				queue.offer(nextNode);
			}
		}
		
		for (int i = 2; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}

}
