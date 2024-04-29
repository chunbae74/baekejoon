import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _23843 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pQ = new PriorityQueue<>(1, Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pQ.offer(Long.parseLong(st.nextToken()));
		}
		
		long[] arr = new long[M];
		boolean isReverse = false;
		while (pQ.size() > 0) {
			int size = pQ.size();
			for (int i = 0; i < Math.min(size, M); i++) {
				int idx = isReverse ? M - i - 1 : i;
				arr[idx] += pQ.poll();
			}
			isReverse = !isReverse;
		}
		
		long max = 0;
		for (int i = 0; i < M; i++) {
			max = Math.max(max, arr[i]);
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
		
		
	}

}
