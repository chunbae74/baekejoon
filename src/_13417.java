import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class _13417 {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int N;
		Deque<Character> deque = new LinkedList<>();

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			deque.clear();
			char[] c = new char[N];
			String input = br.readLine();
			for(int j = 0; j < N; j++) c[j] = input.charAt(2 * j);
			
			deque.offer(c[0]);
			for(int j = 1; j < N; j++) {
				char cc = c[j];
				if (deque.peekFirst() >= cc) { // c a
					deque.offerFirst(cc);
				}
				else { // a c
					deque.offer(cc);
				}
			}
			for(char cc: deque) sb.append(cc);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}