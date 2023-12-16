import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 메모리초과
 *
 */
public class _2346 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<>();
		Deque<Integer> deque = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			hm.put(i, num);
			deque.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		int how = hm.get(1);
		sb.append(deque.removeFirst()).append(" ");
		while(deque.size() > 0) {
			if (how < 0) {
				how = -1 * how - 1;
				for (int i = 0; i < how; i++) {
					deque.offerFirst(deque.removeLast());
				}
			}
			else {
				for (int i = 0; i < how; i++) {
					deque.offerLast(deque.removeFirst());
				}
			}
			int n = deque.removeLast();
			how = hm.get(n);
			sb.append(n).append(" ");
		}
	
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
