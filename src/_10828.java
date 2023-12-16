import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st;
		String type;
		int num = 0;
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			type = st.nextToken();
			if (type.equals("push")) num = Integer.parseInt(st.nextToken());
			switch(type) {
			case "push":
				stack.push(num);
				break;
			
			case "pop":
				if (stack.empty()) sb.append("-1").append("\n");
				else sb.append(stack.pop()).append("\n");
				break;
				
			case "size":
				sb.append(stack.size()).append("\n");
				break;
				
			case "empty":
				sb.append(stack.empty()?"1":"0").append("\n");
				break;
				
			case "top":
				if (stack.empty()) sb.append("-1").append("\n");
				else sb.append(stack.peek()).append("\n");
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
