import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1932 {
	static ArrayList<Integer>[] al;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		al = new ArrayList[n];
		
		for (int i = 0; i < n; i++) al[i] = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i; j++) {
				al[i - 1].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		max = al[0].get(0);
		
		dfs();
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs() {
		Stack<Integer> stack = new Stack<>();
	}
}
