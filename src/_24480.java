import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _24480 {
	static ArrayList[] al;
	static int[] index;
	static int order = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점의 수
		int N = Integer.parseInt(st.nextToken());
		// 간선의 수
		int M = Integer.parseInt(st.nextToken());
		// 시작정점
		int R = Integer.parseInt(st.nextToken());
		al = new ArrayList[N + 1];
		index = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			al[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			al[A].add(B);
			al[B].add(A);
		}
		
		for (int i = 1; i <= N; i++) {
			Collections.sort(al[i], Collections.reverseOrder());
		}
		
		dfs(R);
		
		for (int i = 1; i <= N; i++) {
			sb.append(index[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int R) {
		index[R] = order++;
		for (int i = 0; i < al[R].size(); i++) {
			int num = (int) al[R].get(i);
			if (index[num] == 0) dfs(num);
		}
	}

}
