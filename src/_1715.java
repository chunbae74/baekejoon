import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class _1715 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			pQ.offer(Integer.parseInt(br.readLine()));
		}
		
		long sum = 0;
		whileLoop: while (!pQ.isEmpty()) {
			int num = 0;
			for (int i = 0; i < 2; i++) {
				if (pQ.isEmpty()) break whileLoop;
				num += pQ.poll(); 
			}
			sum += num;
			pQ.offer(num);
		}
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
