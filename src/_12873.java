import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 시 발
 *
 */
public class _12873 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) queue.offer(i);
		
		int idx = 1;
		while(queue.size() > 1) {
			int num = (int)Math.pow(idx, 3);
			if (num > queue.size()) {
				if (queue.size() == 2) {
					num = (num % 2 == 0)?2:1;
				}
				else num %= queue.size();
			}
			for(int i = 0; i < num - 1; i++) queue.offer(queue.poll());
			queue.poll();
			idx ++;
		}
		bw.write(queue.peek() + "");
		bw.flush();
		bw.close();
	}

}
