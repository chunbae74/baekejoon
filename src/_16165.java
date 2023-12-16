import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 퀴즈 종류
 * 0 : 팀의 이름이 주어짐. 해당 팀에 속한 맴버의 이름을 사전순으로 출력
 * 1 : 맴버가 속한 팀의 이름을 출력
 *
 */
public class _16165 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 걸그룹 수
		int M = Integer.parseInt(st.nextToken()); // 맞춰야 할 문제 수
		HashMap<String, ArrayList<String>> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String team = br.readLine();
			int memNum = Integer.parseInt(br.readLine());
			ArrayList<String> mem = new ArrayList<>();
			for (int j = 0; j < memNum; j++) {
				mem.add(br.readLine());
			}
			Collections.sort(mem);
			hm.put(team, mem);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			int type = Integer.parseInt(br.readLine());
			switch(type) {
			case 0: // 팀 이름 주어짐
				for(String name: hm.get(s)) sb.append(name).append("\n");
				break;
			
			case 1: // 맴버 이름 주어짐
				for (Map.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
					if (entry.getValue().contains(s)) {
						sb.append(entry.getKey()).append("\n");
						break;
					}
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
