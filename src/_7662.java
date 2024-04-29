import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 테케모음 : https://www.acmicpc.net/board/view/127182 
 */
public class _7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			PriorityQueue<Integer> upToDownPQ = new PriorityQueue<>(1, Collections.reverseOrder());
			PriorityQueue<Integer> downToUpPQ = new PriorityQueue<>();
			int K = Integer.parseInt(br.readLine());
			int delCount = 0;
			int insertCount = 0;
			for (int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				if (command == 'I') {
					insertCount = insertCount + 1;
					upToDownPQ.offer(num);
					downToUpPQ.offer(num);
				} 
				else if (command == 'D') {
					// 최댓값 삭제
					if (num == 1) {
						if (!upToDownPQ.isEmpty()) {
							int n = upToDownPQ.poll();
							downToUpPQ.remove(n);
							delCount = delCount + 1;
						}
					}
					// 최솟값 삭제
					else if (num == -1) {
						if (!downToUpPQ.isEmpty()) {
							int n = downToUpPQ.poll();
							upToDownPQ.remove(n);
							delCount = delCount + 1;
						}
					}
				}
			}
			if (insertCount <= delCount) {
				sb.append("EMPTY");
			} else {
				sb.append(upToDownPQ.poll()).append(" ").append(downToUpPQ.poll());
			}
			sb.append("\n");
		} // 테스트케이스 종료
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
