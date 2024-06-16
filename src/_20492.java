import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20492 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		sb.append((int)(N * 0.78)).append(" ");
		sb.append((int)((N * 0.8) + (N * 0.2 * 0.78)));
		System.out.print(sb.toString());
	}

}
