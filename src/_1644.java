/**
 * 포인터 사용
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _1644 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean[] isNotSosu = new boolean[N + 1];
		isNotSosu[0] = isNotSosu[1] = true;
		ArrayList<Integer> sosuList = new ArrayList<>();
		for(int i = 2; i<isNotSosu.length; i++) {
			if (!isNotSosu[i]) {
				sosuList.add(i);
				for (int j = i*2; j<isNotSosu.length; j+= i) isNotSosu[j] = true;
			}
		}
		int count = 0, sum = 0;
		int begin = -1, end = -1;
		while (true) {
			if (sum >= N) {
				begin++;
				if (begin >=  sosuList.size()) break;
				sum -= sosuList.get(begin);
			} else if (sum < N) {
				end++;
				if (end >= sosuList.size()) break;
				sum += sosuList.get(end);
			}
			if (sum == N) count++;
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
}
/**
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _1644 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean[] isNotSosu = new boolean[4_000_000*2 + 1];
		isNotSosu[0] = isNotSosu[1] = true;
		ArrayList<Integer> sosuList = new ArrayList<>();
		for(int i = 2; i<isNotSosu.length; i++) {
			if (!isNotSosu[i]) {
				sosuList.add(i);
				for (int j = i*2; j<isNotSosu.length; j+= i) isNotSosu[j] = true;
			}
		}
		int count = 0, sum = 0, j;
		for (int i = 0; ; i++) {
			sum = 0;
			j = i;
			if (sosuList.get(j) > N) break;
			while(true) {
				int now = sosuList.get(j);
				if (sum + now > N) break;
				sum += now;
				j++;
			}
			if (sum == N) count++;
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
}
*/