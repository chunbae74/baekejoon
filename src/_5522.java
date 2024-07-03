import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5522 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += Long.parseLong(br.readLine());
		}
		
		System.out.println(sum);
	}

}
