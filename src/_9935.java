import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		char[] cArr = br.readLine().toCharArray();
		String target = br.readLine();
		int len = target.length();
		
		for (char c: cArr) {
			stack.add(c);
			if (stack.size() >= len) {
				boolean isSame = true;
				for (int i = 0; i < len; i++) {
					if (stack.get(stack.size() - len + i) != target.charAt(i)) {
						isSame = false;
						break;
					}
				}
				
				if (isSame) {
					for (int i = 0; i < len; i++) {
						stack.pop();
					}
				}
			}
		}
		
		if (stack.isEmpty()) sb.append("FRULA");
		else {
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
