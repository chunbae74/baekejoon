import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _27497 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Character> deque = new LinkedList<>();
		Deque<Integer> commandOrder = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		int command;
		char c = '\u2000';
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command = Integer.parseInt(st.nextToken());
			if (command != 3) c = st.nextToken().charAt(0);
			
			switch(command) {
			case 1:
				deque.offerLast(c);
				commandOrder.offer(1);
				break;
				
			case 2:
				deque.offerFirst(c);
				commandOrder.offer(2);
				break;
				
			case 3:
				if (deque.isEmpty()) break;
				else {
					int num = commandOrder.removeLast();
					if (num == 2) { // 앞부분에 추가했다면
						deque.removeFirst();
					}
					else { // 뒷부분에 추가했다면
						deque.removeLast();
					}
				}
				break;
			}
		}
		
		if (deque.size() == 0) bw.write("0");
		else {
			StringBuilder sb = new StringBuilder();
			for(char ch: deque) sb.append(ch);
			bw.write(sb.toString());			
		}
		bw.flush();
		bw.close();
	}

}
