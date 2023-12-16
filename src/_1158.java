import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class _1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i ++) queue.add(i);
		
		StringJoiner sj = new StringJoiner(", ");
		
		while (queue.size() > 0) {
			for (int i = 0; i < K - 1; i++) queue.offer(queue.poll());
			sj.add(Integer.toString(queue.poll()));
		}
		bw.write("<" + sj.toString() + ">");
		bw.flush();
		bw.close();
	}

}
