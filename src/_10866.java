import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _10866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String command = "";
		int num = 0;
		StringTokenizer st;
		Deque<Integer> deque = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if (command.equals("push_back") || command.equals("push_front")) num = Integer.parseInt(st.nextToken());
			switch(command) {
			case "push_front":
				deque.addFirst(num);
				break;
				
			case "push_back":
				deque.addLast(num);
				break;
				
			case "pop_front":
				if (deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.removeFirst()).append("\n");
				break;
				
			case "pop_back":
				if (deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.removeLast()).append("\n");
				break;
				
			case "size":
				sb.append(deque.size()).append("\n");
				break;
				
			case "empty":
				sb.append(deque.isEmpty()?"1":"0").append("\n");
				break;
				
			case "front":
				if (deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.getFirst()).append("\n");
				break;
				
			case "back":
				if (deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.getLast()).append("\n");
				break;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
