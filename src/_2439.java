import java.util.Scanner;

public class _2439 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int k = (n-i); k > 0; k--) System.out.print(" ");
			for (int j = 1; j <= i; j++) System.out.print("*");
			System.out.println();
		}
		input.close();
	}

}
