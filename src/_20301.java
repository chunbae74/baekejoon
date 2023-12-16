import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _20301 {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= N; i++) deque.offer(i);
		boolean reversed = false;
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while(deque.size() > 0) {
			
			for(int i = 0; i < K; i++) {
				if (reversed) {
					deque.offerFirst(deque.removeLast());			
				}
				else {
					deque.offerLast(deque.removeFirst());
				}
			}
			
			if (reversed) sb.append(deque.removeFirst()).append("\n");
			else sb.append(deque.removeLast()).append("\n");
			
			count ++;
			if (count == M) {
				count = 0;
				reversed = !reversed;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}