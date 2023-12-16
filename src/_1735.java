import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1735 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numberator1 = Integer.parseInt(st.nextToken());
		int denominator1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int numberator2 = Integer.parseInt(st.nextToken());
		int denominator2 = Integer.parseInt(st.nextToken());
		
		int totalNumberator = (numberator1 * denominator2) + (numberator2 * denominator1);
		int totalDenominator = denominator1 * denominator2;
		
		int gcd = gcd(Math.min(totalDenominator, totalNumberator), Math.max(totalDenominator, totalNumberator));
		
		bw.write((totalNumberator / gcd) + " " + (totalDenominator / gcd));
		bw.flush();
		bw.close();
	}
	
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a%b);
	}

}
