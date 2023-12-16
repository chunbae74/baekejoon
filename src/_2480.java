import java.util.Scanner;

public class _2480 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		if (num1 == num2 && num2 == num3 && num1 == num3) System.out.println(10000 + (num1 * 1000));
		else if (num1 != num2 && num1 != num3 && num2 != num3) {
			if (num1 < num2) num1 = num2;
			if (num1 < num3) num1 = num3;
			System.out.println(num1 * 100);
		} else {
			if (num1 == num2) System.out.println(1000 + (num1 * 100));
			else if (num1 == num3) System.out.println(1000 + (num1 * 100));
			else if (num2 == num3) System.out.println(1000 + (num2 * 100));
		}
		input.close();
	}

}
