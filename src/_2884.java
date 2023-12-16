import java.util.Calendar;
import java.util.Scanner;
public class _2884 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int hour = input.nextInt();
		int min = input.nextInt();
		input.close();
		
		if (min >= 45) min -= 45;
		else {
			min = 60 - (45 - min);
			if (hour > 0) {
				hour --;
			} else {
				hour = 23;
			}
		}
		System.out.print(hour + " " + min);
	}

}
