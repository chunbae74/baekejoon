import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 테케ㅣ
 * https://www.acmicpc.net/board/view/138073
 */
public class _3015 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		long ans = N - 1;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			while (!stack1.isEmpty() && arr[stack1.peek()] <= arr[i]) {
				if (stack1.peek() != i - 1) {
					ans ++;
				}
				
				stack1.pop();
			}

			while (!stack2.isEmpty() && arr[stack2.peek()] >= arr[i]) {
				if (stack2.peek() != i - 1) ans ++;
				stack2.pop();
			}
			
			stack1.add(i);
			stack2.add(i);
		}
		
		
		System.out.println(ans);
	}

}
