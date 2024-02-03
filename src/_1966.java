import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * T : 테스트 케이스 개수. 각 테스트케이스는 두 줄로 이루어져 있음
 * N : 문서의 개수 (1 <= N <= 100)
 * M : 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여있는지 나타냄
 * 맨 왼쪽은 0번째임.
 */
public class _1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N, M, count;
		
		
		Loop1: for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// [0] : 순서 | [1] : 중요도
			Queue<int[]> queue = new LinkedList<>();
			// 중요도를 담을 배열
			Integer[] arr = new Integer[N];
			count = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int importance = Integer.parseInt(st.nextToken());
				int[] a = new int[2];
				a[0] = j;
				a[1] = arr[j] = importance;
				
				queue.offer(a);
			}
			
			// 중요도 순으로 배치
			Arrays.sort(arr, Collections.reverseOrder());
			
			int idx = 0;
			while (!queue.isEmpty() && idx < arr.length) {
				// 지금 순서에 출력되어야 하는 문서
				int printNum = arr[idx];
				// 맨 앞에 있는 문서
				int[] nowDoc = queue.peek();
				
				// 해당 문서가 출력될 순서라면
				if (nowDoc[1] == printNum) {
					// 인쇄 count + 1
					count ++;

					// 만약 내가 알고싶은 문서라면
					if (nowDoc[0] == M) {
						sb.append(count).append("\n");
						continue Loop1;
					}
					// 내가 알고싶은 문서가 아니라면
					else {
						// 문서 큐에서 제거
						queue.poll();
						// 중요도 arr idx + 1
						idx ++;
					}
				}
				// 아직 해당 문서가 출력될 순서가 아니라면
				else {
					// 큐 맨 뒤로 추가
					queue.offer(queue.poll());
				}
			} // while문 끝
					
		} // 테스트케이스 끝
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
