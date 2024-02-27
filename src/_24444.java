import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N: 정점의 수
 * M: 간선의 수
 * R: 시작정점
 * 무방향 그래프
 */
public class _24444 {
	static int N, M, R;
	static ArrayList<Integer>[] al;
	static boolean[] visited;
	static int[] orderArr;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		al = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		orderArr = new int[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			al[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			al[u].add(v);
			al[v].add(u);
		}
		
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(al[i]);
		}
		
		bfs();
		
		for (int i = 1; i < N + 1; i++) sb.append(orderArr[i]).append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(R);
		visited[R] = true;
		
		int order = 1;
		orderArr[R] = order ++;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			
			for (int n: al[num]) {
				if (visited[n]) continue;
				
				orderArr[n] = order ++;
				queue.offer(n);
				visited[n] = true;
			}
		}
	}

}
