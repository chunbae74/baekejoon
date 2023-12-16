import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) stack.pop();
			else stack.add(num);
		}
		
		int sum = 0;
		for(int n: stack) sum += n;
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}

}
