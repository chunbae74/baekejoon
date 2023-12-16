import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14215 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int n3 = Integer.parseInt(st.nextToken());
		// 정삼각형일때
		if (n1 == n2 && n2 == n3) bw.write((n1 * 3) + "");
		else {
			int[] arr = {n1, n2, n3};
			Arrays.sort(arr);
			if (arr[0] == arr[1]) { // 이등변 삼각형_1
				// 정상적인 이등변 삼각형일 때
				if (arr[0] + arr[1] > arr[2]) bw.write(arr[0] * 2 + arr[2] + "");
				// 비정상적 이등변 삼각형일 때
				else bw.write((arr[0] + arr[1]) * 2 - 1 + "");
			} else if (arr[1] == arr[2]) { // 이등변 삼각형_2
				bw.write(arr[1] * 2 + arr[0] + "");
			} else { // 세 변 모두 다른 길이일때
				if (arr[0] + arr[1] <= arr[2]) for(;arr[0] + arr[1] <= arr[2]; arr[2]--);
				bw.write(arr[0] + arr[1] + arr[2] + "");
			}
		}
		bw.flush();
		bw.close();
	}
}
