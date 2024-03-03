import java.util.Scanner;

public class _31495 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		
		if (s == null || s.equals("")) {
			System.out.println("CE");
			System.exit(0);
		}
		if (s.startsWith("\"") && s.endsWith("\"")) {
			s = s.substring(1, s.length() - 1);
			if (s.length() < 1) System.out.println("CE");
			else System.out.println(s);;
		} else {
			System.out.println("CE");;
		}
	}

}
