import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

/**
 * n번 뒤로 옮기고 난 후의 카드 : n
 *
 */
public class _1835 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		deque.offer(N);
		for(int i = N-1; i > 0; i--) {
			deque.offerFirst(i);
			for (int j = 0; j < i; j++) {
				deque.offerFirst(deque.removeLast());
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int num: deque) sb.append(num).append(" ");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
