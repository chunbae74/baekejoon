import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringJoiner;

/**
 * D : 첫 번째 수를 버리는 하수
 * R : 배열에 있는 수의 순서를 뒤집는 함수.
 *
 */
public class _5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> deque = new LinkedList<>();

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int len; // 배열 길이
		Loop1: for(int i = 0; i < T; i++) {
			char[] command = br.readLine().toCharArray();
			len = Integer.parseInt(br.readLine());
			deque = StringToDeque(br.readLine());
			boolean isReversed = false;
			for(int j = 0; j < command.length; j++) {
				if (command[j] == 'D') {
					if (deque.size() == 0) {
						sb.append("error\n");
						continue Loop1;
					} 
					else {
						if (isReversed) deque.removeLast();
						else deque.removeFirst();
					}
				}
				else if (command[j] == 'R') {
					isReversed = !isReversed;
				}
			} // 한 줄 명령 끝
			if (isReversed) deque = reverse(deque);
			if (deque.size() == 0) sb.append("[]\n");
			else {
				StringJoiner sj = new StringJoiner(",");
				for(int num: deque) sj.add(Integer.toString(num));
				sb.append("[" + sj.toString() + "]").append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
	public static Deque StringToDeque(String s) {
		Deque<Integer> deque = new LinkedList<>();
		if (s.equals("[]")) return deque;
		int[] arr = Arrays.stream(s.substring(1, s.length() -1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		for (int i =0; i < arr.length; i++) {
			deque.add(arr[i]);
		}
		return deque;
	}
	
	
	public static Deque reverse(Deque<Integer> d) {
		Deque<Integer> newDeque = new LinkedList<>();
		int size = d.size();
		for (int i = 0; i < size; i++) {
			newDeque.offer(d.removeLast());
		}
		return newDeque;
	}
}
