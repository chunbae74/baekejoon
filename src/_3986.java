import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _3986 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		int count = 0;
		Loop1: for(int i = 0; i < N; i++) {
			char[] cArray = br.readLine().toCharArray();
			Loop2: for(char c: cArray) {
				switch(c) {
				case 'A':
					if (stack.empty()) stack.add(c);
					else {
						if (stack.peek() == 'A') {
							stack.pop();
						} else stack.add(c);
					}
				case 'B':
					if (stack.empty()) stack.add(c);
					else {
						if (stack.peek() == 'B') {
							stack.pop();
						} else stack.add(c);						
					}
				}
			}
			if (stack.size() % 2 != 0) continue;
			for(int j = 0; j < stack.size() / 2; j++) {
				if (stack.get(j) == stack.get(stack.size() - j - 1)) {
					continue Loop1;
				}
			}
			count ++;
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
