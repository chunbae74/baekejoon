import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty()) {
				/* 
				 * 내 앞에 탑이 나보다 크다면
				 * 해당 탑의 idx 출력 후 다음 탑으로 이동
				 */
				if (arr[stack.peek()] > arr[i]) {
					sb.append(stack.peek()).append(" ");
					break;
				/*
				 * 내 앞의 탑이 나보다 크지 않다면 하나씩 빼기
				 */
				} else {
					stack.pop();
				}
			}
			
			// 스택이 비어있다면, 즉 내 앞에 나보다 큰 탑이 없다면
			if (stack.isEmpty()) {
				sb.append("0 ");
			}
			stack.add(i);
		}
		
		System.out.println(sb.toString());
	}
}
