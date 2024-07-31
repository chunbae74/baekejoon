import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _22951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<int[]> deque = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < K; k++) {
				int num = Integer.parseInt(st.nextToken());
				deque.addLast(new int[] { num, n });
			}
		}
		
		while (deque.size() > 1) {
			int[] nowArr = deque.pollFirst();
			int nowNum = nowArr[0] - 1;
			int nowPerson = nowArr[1];
			int nowSize = deque.size();
			if (nowNum >= nowSize) {
				nowNum %= nowSize;
			}
			
			for (int i = 0; i < nowNum; i++) {
				deque.addLast(deque.pollFirst());
			}
		}
		
		System.out.println(deque.peek()[1] + " " + deque.peek()[0]);
	}

}
