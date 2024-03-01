import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _2346 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Deque<int[]> deque = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			deque.addLast(new int[] { i, num });
		}
		
		int next = 1;
		while(!deque.isEmpty()) {
			for (int i = 0; i < Math.abs(next); i++) {
				if (next > 0) {
					deque.offerLast(deque.pollFirst());
				}
				else if (next < 0){
					deque.offerFirst(deque.pollLast());
				}
			}
			
			int[] arr = new int[2];
			if (next > 0) {
				arr = deque.pollLast();
			}
			else if (next < 0) {
				arr = deque.pollFirst();
			}
			
			int order = arr[0];
			next = arr[1];
			
			sb.append(order).append(" ");
		}
	
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
