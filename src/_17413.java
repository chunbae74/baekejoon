import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		boolean notReversePart = false;
		StringBuilder nr = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		StringBuilder preSb = new StringBuilder();
		String[] input = br.readLine().split("");
		
		for (String s : input) {
			if (s.equals("<")) {
				notReversePart = true;
				if (preSb.length() != 0) sb.append(preSb.reverse().toString()); // 기존에 저장된 값 넣기
				sb.append(s);
				continue;
			}
			else if (s.equals(">")) {
				notReversePart = false;
				sb.append(s);
				preSb = new StringBuilder(); // preSb 초기화시키기
				continue;
			}
			
			if (notReversePart) sb.append(s);
			else {
				if (s.equals(" ")) {
					sb.append(preSb.reverse().toString()).append(" "); // 기존에 있던거 넘겨주고
					preSb = new StringBuilder(); // preSb 초기화하고
				} else preSb.append(s);
			}
		}
		if (preSb.length() != 0) sb.append(preSb.reverse().toString());
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
