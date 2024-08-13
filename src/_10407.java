import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10407 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();
		System.out.println(input.equals("1") ? 2 : 1);
	}

}
