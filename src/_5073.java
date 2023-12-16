import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5073 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			if (n1 == 0 && n2 == 0 && n3 == 0) break;
			if (n1 == n2 && n2 == n3) bw.write("Equilateral");
			else {
				int[] arr = {n1, n2, n3};
				Arrays.sort(arr);
				if (arr[0] == arr[1]) { // 이등변삼각형_1
					if (arr[0] + arr[1] > arr[2]) bw.write("Isosceles");
					else bw.write("Invalid");
				} else if (arr[1] == arr[2]) { // 이등변삼각형_2
					bw.write("Isosceles");
				} else {
					if (arr[0] + arr[1] > arr[2]) bw.write("Scalene");
					else bw.write("Invalid");
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
