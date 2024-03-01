import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _12789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int order = 1;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// 자기 차례라면
			if (order == num) {
				order ++;
				continue;
			}
			
			// 자기 차례가 아니라면
			else {
				while (!stack.isEmpty() && stack.peek() == order) {
					stack.pop();
					order ++;
				}
				
				if (order == num) {
					order ++;
					continue;
				}
				else {
					stack.add(num);
					continue;
				}
			}
		}

		boolean success = true;
		
		while (!stack.isEmpty()) {
			int peek = stack.peek();
			// 자기 차례라면
			if (peek == order) {
				stack.pop();
				order ++;
			}
			else {
				success = false;
				break;
			}
		}
		
		bw.write(success ? "Nice" : "Sad");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
