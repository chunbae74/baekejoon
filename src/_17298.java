import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 참고ㅣ
 * https://st-lab.tistory.com/196
 */
public class _17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		/*
		 * 최신화가 필요한 index값이 담길 stack.
		 */
		
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
	
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			
			stack.add(i);
		}
		
		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}
		
		for (int num: arr) {
			sb.append(num).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
