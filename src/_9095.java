import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class _9095 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		int count = 1;
		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			int first = num;
			int second = 0;
			int third  = 0;
			int secondMax = num / 2;
			int thirdMax = num / 3;
			// 1, 2
			while (first >= 2 && second <= secondMax - 1) {
				first -= 2;
				second ++;
				count += fact(first + second) / (fact(first) * fact(second));
			}
			
			// 1, 3
			first = num;
			while (first >= 3 && third <= thirdMax - 1) {
				first -= 3;
				third ++;
				count += fact(first + third) / (fact(first) * fact(third));
			}
			
			// 2, 3
			second = secondMax;
			third = 0;
			while (second >= 6 && third <= thirdMax - 2) {
				second -= 6;
				third += 2;
				count += fact(third + second) / (fact(third) * fact(second));
			}
			
			// 1, 2, 3
			// ㅇ아아ㅏ앙ㄱ 모르겠어
			if (num >= 7) {
				int sum;	
				while (true) {
					sum = 2 * second + 3 * third;
					if (sum >= num) break;
					
				}
					
			}
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
	
	public static int fact(int n) {
		if (n == 1 || n == 0) return 1;
		else {
			int fact = n;
			for (int i = n - 1; i > 1; i--) {
				fact *= i;
			}
			return fact;
		}
	}

}
