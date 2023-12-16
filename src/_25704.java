import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25704 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int n1;
		if (N < 5) {
			System.out.println(P);
		} else if (5 <= N && N < 10) {
			if (P < 500) System.out.println("0");
			else System.out.println(P - 500);
		} else if (10 <= N && N < 15) {
			n1 = (int)Math.min(P - 500, P * 0.9);
			if (n1 < 0) System.out.println("0");
			else System.out.println(n1);
		} else if (15 <= N && N < 20) {
			n1 = (int) Math.min(P - 2000, (int)(P * 0.9));
			if (n1 < 0) System.out.println("0");
			else System.out.println(n1);
		} else if (20 <= N) {
			n1 = (int) Math.min(P - 2000, (int)(P * 0.75));
			if (n1 < 0) System.out.println("0");
			else System.out.println(n1);
		}
	}

}
