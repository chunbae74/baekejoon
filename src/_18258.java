import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _18258 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		String command = "";
		int num = 0; 
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if (command.equals("push")) num = Integer.parseInt(st.nextToken());
			
			switch(command) {
			case "push":
				deque.offer(num);
				break;
				
			case "pop":
				if (deque.isEmpty()) sb.append("-1\n");
				else sb.append(deque.poll()).append("\n");
				break;
				
			case "size":
				sb.append(deque.size()).append("\n");
				break;
				
			case "empty":
				sb.append(deque.isEmpty()?"1\n":"0\n");
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
