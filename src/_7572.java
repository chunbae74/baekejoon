import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2013 = F9
public class _7572 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int n1 = N % 10;
		int n2 = N % 12;
		char[] alphabet = new char[] { 'I', 'J', 'K', 'L', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
		int[] num = new int[] { 6, 7, 8, 9, 0, 1, 2, 3, 4, 5 };
		System.out.println(alphabet[n2] + Integer.toString(num[n1]));
	}

}
