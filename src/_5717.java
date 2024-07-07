import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5717 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String input;
		while (!(input = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(input);
			int M = Integer.parseInt(st.nextToken());
			int F = Integer.parseInt(st.nextToken());
			sb.append((M + F)).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
