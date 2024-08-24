import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		String l = br.readLine();
		int count = 0;
		for (int i = 0; i < l.length(); i++) {
			char c = l.charAt(i);
			if (c == '(') {
				stack.add(c);
				continue;
			}
			else {
				char preC = l.charAt(i - 1);
				stack.pop();
				// 레이저라면
				if (preC == '(') {
					count += stack.size();
				} else {
					count ++;
				}
			}
		}
		
		System.out.println(count);
	}

}
