import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 1 X ㅣ정수 X를 스택에 넣는다.
 * 2   ㅣ스택에 정수가 있다면 맨 위의 정수를 빼고 출력, 없으면 -1을 출력한다.
 * 3   ㅣ 스택에 들어있는 정수의 개수를 출력한다
 * 4   ㅣ스택이 비어있으면 1, 아니면 0을 출력한다
 * 5   ㅣ스택에 정수가 있따면 맨 위의 정수를 출력, 없다면 -1을 출력한다
 */
public class _28278 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			
			switch (command) {
			case 1:
				int X = Integer.parseInt(st.nextToken());
				stack.add(X);
				break;
				
			case 2:
				sb.append((stack.isEmpty()) ? "-1" : stack.pop()).append("\n");
				break;
				
			case 3:
				sb.append(stack.size()).append("\n");
				break;
				
			case 4:
				sb.append((stack.isEmpty()) ? "1\n" : "0\n");
				break;
				
			case 5:
				sb.append((stack.isEmpty()) ? "-1" : stack.peek()).append("\n");
				break;
			}
			
		} // for 문 끝
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
