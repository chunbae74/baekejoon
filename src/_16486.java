import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _16486 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int d1 = Integer.parseInt(br.readLine());
		int d2 = Integer.parseInt(br.readLine());
		br.close();
		
		final double pi = 3.141592;
		double cal = 2 * d1 + 2 * d2 * pi;
		System.out.println(cal);
	}

}
