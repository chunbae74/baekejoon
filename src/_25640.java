import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25640 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String MBTI = br.readLine();
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (br.readLine().equals(MBTI)) count++;
		}
		System.out.println(count);
	}

}
