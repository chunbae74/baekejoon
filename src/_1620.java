import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> keyIsName = new HashMap<>();
		String[] index = new String[N+1];
		int num = 1;
		String name;
		for(int i = 1; i<=N; i++) {
			name = br.readLine();
			keyIsName.put(name, num);
			index[i] = name;
			num ++;
		}
		StringBuilder sb = new StringBuilder();
		String input;
		for(int i = 0; i<M; i++) {
			input = br.readLine();
			char first = input.charAt(0);
			if ('A' <= first && first <= 'Z') {
				sb.append(keyIsName.get(input));
			} else {
				sb.append(index[Integer.parseInt(input)]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
