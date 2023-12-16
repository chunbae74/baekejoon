import java.util.Scanner;
public class _12981 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		input.close();
		int count = 0;
		count += num1 / 3;
		count += num2 / 3;
		count += num3 / 3;
		num1 %= 3;
		num2 %= 3;
		num3 %= 3;
		if ((num1 != 0 && num2 == 0 && num3 == 0) || (num1 == 0 && num2 != 0 && num3 == 0) || (num1 == 0 && num2 == 0 && num3 != 0)) count ++;
		else {
			if (num1 < num2) num1 = num2;
			if (num1 < num3) num1 = num3;
			count += num1;
		}
		System.out.println(count);
	}

}
