import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node_1238 {
	int index;
	int cost;
	
	Node_1238(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _1238 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<Node_1238>[] graph = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		int[] go = new int[N + 1];
		int[] back = new int[N + 1];
		int[] dist = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[s].add(new Node_1238(e, c));
		}
		
		for (int i = 1; i <= N; i++) {
			
		}
		
	}

}
