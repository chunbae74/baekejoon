import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class _1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		// 스택에 들어가는 수
		int stackIdx = 1;

		int n = Integer.parseInt(br.readLine());		
		
		// 주어진 순열을 저장할 arr
		int[] arr = new int[n];
		// arr idx
		int arrIdx = 0;
		
		// 결과를 담을 arr
		int[] result = new int[n];
		int resultIdx = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Loop1: while (true) {
			// 만약 모든 수를 스택에 집어넣어다면
			if (stackIdx > n) {
				while (!stack.isEmpty()) {
					result[resultIdx ++] = stack.pop();
					sb.append("-").append("\n");
				}
				break Loop1;
			}
			
			// 스택이 빈 상태라면
			if (stack.isEmpty()) {
				stack.add(stackIdx);
				sb.append("+").append("\n");
				stackIdx ++;
			}
			
			// 맨 위에 있는 스택
			int peekNum = stack.peek();
			// 지금 꺼낼 차례라면
			if (peekNum == arr[arrIdx]) {
				result[resultIdx ++] = stack.pop();
				sb.append("-").append("\n");
				arrIdx ++;
			} 
			// 지금 꺼낼 차례가 아니라면
			else {
				stack.add(stackIdx);
				sb.append("+").append("\n");
				stackIdx ++;
			}
		}
		
		if (isSame(arr, result))
			bw.write(sb.toString());			
		else
			bw.write("NO");
		
		bw.flush();
		bw.close();
	}
	
	public static boolean isSame(int[] a1, int[] a2) {
		boolean isSame = true;
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] != a2[i]) {
				isSame = false;
				break;
			}
		}
		
		return isSame;
	}

}
