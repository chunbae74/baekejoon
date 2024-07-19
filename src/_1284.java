import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1284 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input;
		while (!(input = br.readLine()).equals("0")) {
			int cal = 0;
			int len = input.length();
			for (int i = 0; i < len; i++) {
				char c = input.charAt(i);
				
				if (c == '1') cal += 2;
				else if (c == '0') cal += 4;
				else cal += 3;
			}
			cal += len + 1;
			
			sb.append(cal).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
