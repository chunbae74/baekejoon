import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		char[] key = br.readLine().toCharArray();
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			stack.add(input[i]);
			
			if (stack.size() >= key.length) {
				boolean isContain = true;
				for (int j = 0; j < key.length; j++) {
					if (key[key.length - j - 1] != stack.get(stack.size() - j - 1)) {
						isContain = false;
						break;
					}
				}
				
				if (isContain) {
					stack.clear();
					count ++;
				}
			}
		}
		
		System.out.println(count);
	}

}
