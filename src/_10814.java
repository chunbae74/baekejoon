import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10814 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		// 0 : 나이
		// 1 : 이름
		String[][] arr = new String[N][3];
		
		StringTokenizer st;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		
		// compare 메소드에서 나이가 같을 경우 두 객체의 위치를 바꾸지 않기 때문에 자연스럽게 입력순서로 정렬이 된다.
		Arrays.sort(arr, ((e1, e2) -> {
			return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
		}));
		
		for(String[] a:arr) bw.write(a[0] + " " + a[1] + "\n");
		bw.flush();
		bw.close();
	}

}
