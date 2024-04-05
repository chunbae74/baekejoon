import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		switch (s) {
		case "NLCS":
			System.out.println("North London Collegiate School");
			break;

		case "BHA":
			System.out.println("Branksome Hall Asia");
			break;
		case "KIS":
			System.out.println("Korea International School");
			break;
			
		case "SJA":
			System.out.println("St. Johnsbury Academy");
			break;
		}
	}

}
