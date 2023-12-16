import java.util.Scanner;
public class _2525 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int hour = input.nextInt();
		int min = input.nextInt();
		int time = input.nextInt();
		input.close();
		int h, m;
		h = time / 60;
		m = time % 60;
		hour += h;
		min += m;
		if (min >= 60) {
			hour ++;
			min -= 60;
		}
		if (hour >= 24) hour -= 24;
		System.out.println(hour + " " + min);
	}

}
