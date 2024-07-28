import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1267 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cal1 = 0;
		int cal2 = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			int y = num / 30;
			int m = num / 60;
			cal1 += (y + 1) * 10;
			cal2 += (m + 1) * 15;
		}
		
		if (cal1 < cal2) {
			System.out.println("Y " + cal1);
		} else if (cal1 > cal2){
			System.out.println("M " + cal2);
		} else {
			System.out.println("Y M " + cal1);
		}
	}

}
