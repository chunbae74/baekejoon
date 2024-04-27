import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class _11279 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Long> pQ = new PriorityQueue<>(1, Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			if (num > 0) pQ.offer(num);
			else sb.append((pQ.isEmpty()) ? "0" : pQ.poll()).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
