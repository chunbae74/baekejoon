import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 1 X ㅣ정수 X를 덱의 앞에 넣는다
 * 2 X ㅣ정수 X를 덱의 뒤에 넣는다
 * 3   ㅣ덱에 정수가 있다면 맨 앞의 정수를 빼고 출력, 없다면 -1을 출력한다
 * 4   ㅣ덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력, 없다면 -1을 출력한다
 * 5   ㅣ덱에 들어있는 정수의 개수를 출력한다
 * 6   ㅣ덱이 비어있으면 1, 아니면 0을 출력한다
 * 7   ㅣ덱에 정수가 있다면 맨 앞의 정수를 출력, 없다면 -1을 출력한다
 * 8   ㅣ덱에 정수가 있다면 맨 뒤의 정수를 출력, 없다면 -1을 출력한다
 */
public class _28279 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int X = -1;
			
			switch (command) {
			case 1:
				X = Integer.parseInt(st.nextToken());
				deque.addFirst(X);
				break;
				
			case 2:
				X = Integer.parseInt(st.nextToken());
				deque.addLast(X);
				break;
				
			case 3:
				sb.append((deque.isEmpty()) ? "-1" : deque.pollFirst()).append("\n");
				break;
				
			case 4:
				sb.append((deque.isEmpty()) ? "-1" : deque.pollLast()).append("\n");
				break;
				
			case 5:
				sb.append(deque.size()).append("\n");
				break;
				
			case 6:
				sb.append((deque.isEmpty()) ? "1" : "0").append("\n");
				break;
				
			case 7:
				sb.append((deque.isEmpty()) ? "-1" : deque.peekFirst()).append("\n");
				break;
				
			case 8:
				sb.append((deque.isEmpty()) ? "-1" : deque.peekLast()).append("\n");
				break;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
