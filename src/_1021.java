import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new LinkedList<>();
		for(int i = 1; i <= N; i++) deque.addLast(i);
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		Loop: for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int size = deque.size();
			int count = 0;
			while (true) {
				if (deque.peek() == num) {
					ans += Math.min(count, size - count);
					deque.pollFirst();
					continue Loop;
				}
				deque.addLast(deque.pollFirst());
				count ++;
			}
		}
		System.out.println(ans);
	}
}
