import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/**
 * 진짜약수 : 1과 N 자신이 아닌 N의 약수
 *
 */
public class _1037 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine()); // 진짜약수 개수
		ArrayList<Long> al = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < count; i++) al.add(Long.parseLong(st.nextToken()));
		Collections.sort(al);
		bw.write(al.get(0) * al.get(al.size() -1) + "");
		bw.flush();
		bw.close();
	}

}
