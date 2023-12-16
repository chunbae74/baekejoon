import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 질량 / 부피 = 밀도
// 혼합한 후의 부피 = 혼합 전 물질의 부피의 합
// 혼합한 후의 질량 = 혼합 전 물질의 질량의 합
public class _27963 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d1 = Integer.parseInt(st.nextToken()); // 밀도1
		int d2 = Integer.parseInt(st.nextToken()); // 밀도2
		int x = Integer.parseInt(st.nextToken()); // 밀도가 더 높은 쪽이 기념주화에서 차지하는 비율
		
	}

}
