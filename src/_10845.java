import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Deque<Integer> deque = new LinkedList<>();
		String command;
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if (command.equals("push")) num = Integer.parseInt(st.nextToken());
			switch(command) {
			case "push":
				deque.add(num);
				break;
				
			case "pop":
				if (deque.isEmpty()) sb.append("-1").append("\n");
				else sb.append(deque.pop()).append("\n");
				break;
				
			case "size":
				sb.append(deque.size()).append("\n");
				break;
				
			case "empty":
				sb.append(deque.isEmpty()?"1":"0").append("\n");
				break;
				
			case "front":
				if (deque.isEmpty()) sb.append("-1").append("\n");
				else sb.append(deque.getFirst()).append("\n");
				break;
				
			case "back":
				if (deque.isEmpty()) sb.append("-1").append("\n");
				else sb.append(deque.getLast()).append("\n");
				break;
				
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
