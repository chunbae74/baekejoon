import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class _1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			pQ.offer(Integer.parseInt(br.readLine()));
			
			Integer[] arr = (Integer[]) pQ.toArray();

			// 홀수면은
			if (pQ.size() % 2 == 1) {
				sb.append(arr[(pQ.size() / 2) + 1]).append("\n");
			}
			// 짝수면은
			else {
				sb.append(Math.min(arr[pQ.size() / 2 - 1], arr[pQ.size() / 2])).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
