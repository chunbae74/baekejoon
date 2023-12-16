import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10101 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a1 = Integer.parseInt(br.readLine());
		int a2 = Integer.parseInt(br.readLine());
		int a3 = Integer.parseInt(br.readLine());
		// 정삼각형 
		if (a1 == 60 && a2 == 60 && a3 == 60) bw.write("Equilateral");
		else { // 일반삼각형
			// 내각의 합 != 180
			if (a1 + a2 + a3 != 180) bw.write("Error");
			else { // 정상적인 삼각형
				// 이등변
				if (a1 == a2 || a1 == a3 || a2 == a3) bw.write("Isosceles");
				// 일반
				else bw.write("Scalene");
			}
		}
		bw.flush();
		bw.close();
	}
}
