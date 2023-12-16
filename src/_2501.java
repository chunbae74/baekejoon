import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> al = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		al.add(1);
		for (int i = 2, count = 1; i < N; i++) {
			if (N % i == 0) {
				al.add(i);
				count++;
			}
			if (K <= count) break;
		}
		al.add(N);
		if (K > al.size()) bw.write("0");
		else bw.write(al.get(K-1) + "");
		bw.flush();
		bw.close();
	}

}
