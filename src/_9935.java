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
		Stack<String> stack = new Stack<>();
		String input = br.readLine();
		for(String s: input.split("")) stack.add(s);
		
		String banWord = br.readLine();
		
		while(stack.peek().contains(banWord)) {
			stack.add(stack.peek().replaceAll(banWord, ""));
		}
		if (stack.peek().equals("")) bw.write("FRULA");
		else bw.write(stack.peek());
		bw.flush();
		bw.close();
	}

}
