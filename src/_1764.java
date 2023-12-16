import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> hm1 = new HashMap<>();
		ArrayList<String> al = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0; i<N; i++) {
			hm1.put(br.readLine(), 1);
		}
		for(int i = 0; i<M; i++) {
			String name = br.readLine();
			hm1.put(name, hm1.getOrDefault(name, 0) + 1);
			if (hm1.get(name) == 2) al.add(name);
		}
		Collections.sort(al);
		StringBuilder sb = new StringBuilder();
		sb.append(al.size()).append("\n");
		for(String name: al) sb.append(name).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
