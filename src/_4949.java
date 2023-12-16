import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String s = br.readLine();
			if (s.equals(".")) break;
			sb.append(check(s)?"yes":"no").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static boolean check(String s) {
		Stack<Character> stack = new Stack<>(); // ()
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != '[' && c != ']' && c != '(' && c != ')') continue;
			switch(c) {
			case '[' :
				stack.add(c);
				break;
				
			case ']' :
				if (stack.isEmpty()) {
					return false;
				}
				else {
					if (stack.peek() != '[') {
						return false;
					}
					else {
						stack.pop();
					}
				}
				break;
				
			case '(':
				stack.add(c);
				break;
				
			case ')' :
				if (stack.isEmpty()) {
					return false;
				}
				else {
					if (stack.peek() != '(') {
						return false;
					}
					else {
						stack.pop();						
					}
				}
				break;
			}
		}
		
		return stack.isEmpty();
	}

}
