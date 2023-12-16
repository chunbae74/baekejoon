import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _11004 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> al = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) al.add(Integer.parseInt(st.nextToken()));
		Collections.sort(al);
		bw.write(al.get(K - 1) + "");
		bw.flush();
		bw.close();
	}

}
