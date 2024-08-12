import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 반례ㅣ
 * https://www.acmicpc.net/board/view/118377
 */
public class _6198 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		long ans = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
				ans += stack.size();
			}
			
			stack.add(i);
		}
		
		while (!stack.isEmpty()) {
			stack.pop();
			ans += stack.size();
		}
		
		System.out.println(ans);
	}

}
