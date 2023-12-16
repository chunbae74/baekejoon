import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class _2161 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) queue.add(i);
		
		StringBuilder sb = new StringBuilder();
		
		while(queue.size() > 1) {
			sb.append(queue.poll()).append(" ");
			queue.offer(queue.poll());
		}
		sb.append(queue.poll()).append(" ");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

}
