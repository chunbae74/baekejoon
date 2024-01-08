import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2529 {
	static int k;
	static char[] inequality;
	static int[] arr;
	static boolean[] visited = new boolean[10];
	static StringBuilder sb = new StringBuilder();
	static String max, min;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		k = Integer.parseInt(br.readLine());
		
		inequality = new char[k];
		arr = new int[k + 1];
		
		String s = br.readLine();
		
		for (int i = 0; i < k; i++) {
			inequality[i] = s.charAt(i * 2);
		}
		
		dfs(0);
		
		bw.write(max + "\n" + min);
		bw.flush();
		bw.close();
	}
	
	
	public static void dfs(int depth) {
		if (depth == k + 1) {
			StringBuilder sb2 = new StringBuilder();
			for (int n: arr) sb2.append(n);
			String s = sb2.toString();
			if (max == null) max = s;
			if (min == null) min = s;
			if (max.compareTo(s) < 0) max = s;
			if (min.compareTo(s) > 0) min = s;
			return;
		}
		
		for (int i = 0; i <= 9; i++) {
			if (visited[i]) continue;
			
			if (depth != 0) {
				char next = inequality[depth - 1];
				if (next == '<') {
					if (arr[depth - 1] >= i) continue;
				}
				else if (next == '>') {
					if (arr[depth - 1] <= i) continue;
				}
			}
			visited[i] = true;
			arr[depth] = i;
			dfs(depth + 1);
			visited[i] = false;
				
		}
	}

}
