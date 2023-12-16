import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class _2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= N; i++) deque.add(i);
		while(deque.size() != 1) {
			deque.removeFirst();
			deque.add(deque.removeFirst());
		}
		bw.write(deque.getFirst() + "");
		bw.flush();
		bw.close();
	}

}
