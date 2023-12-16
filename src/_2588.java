import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2588 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num1 = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split("");
		int num2_1 = Integer.parseInt(strArr[0]);
		int num2_2 = Integer.parseInt(strArr[1]);
		int num2_3 = Integer.parseInt(strArr[2]);
		int num3 = num1 * num2_3;
		int n4 = num1 * num2_2;
		int n5 = num1 * num2_1;
		int n6 = num3 + n4*10 + n5*100;
		bw.write(num3 + "\n");
		bw.write(n4 + "\n");
		bw.write(n5 + "\n");
		bw.write(n6 + "\n");
		bw.flush();
		bw.close();
	}

}
