import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		boolean[] isOut = new boolean[n + 1];
		Stack<Integer> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			int startNum = 0;
			if (!stack.empty()) startNum = stack.peek();
			for (int j = startNum + 1; j <= num; j++) {
				if (!isOut[i]) {
					stack.add(j);
					sb.append("+\n");
				}
			}
			isOut[stack.pop()] = true;
			sb.append("-\n");
		}
		if (sb.length() == 0) bw.write("NO");
		else bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
