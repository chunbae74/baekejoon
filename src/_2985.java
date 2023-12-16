import java.util.Scanner;
public class _2985 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		input.close();
		if (num1 + num2 == num3) System.out.printf("%d+%d=%d",num1,num2,num3);
		else if (num1 - num2 == num3) System.out.printf("%d-%d=%d",num1,num2,num3);
		else if (num1 * num2 == num3) System.out.printf("%d*%d=%d",num1,num2,num3);
		else if (num1 / num2 == num3) System.out.printf("%d/%d=%d",num1,num2,num3);
		else if (num1 == num2 + num3) System.out.printf("%d=%d+%d",num1,num2,num3);
		else if (num1 == num2 - num3) System.out.printf("%d=%d-%d",num1,num2,num3);
		else if (num1 == num2 * num3) System.out.printf("%d=%d*%d",num1,num2,num3);
		else if (num1 == num2 / num3) System.out.printf("%d=%d/%d",num1,num2,num3);
	}

}
