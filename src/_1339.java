import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class _1339 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] originArr = new String[N];
		
		for (int i = 0; i < N; i++) {
			originArr[i] = br.readLine();
		}
		
		HashMap<Character, Integer> hm = new HashMap<>();
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < originArr[i].length(); j++) {
				char c = originArr[i].charAt(j);
				hm.put(c, hm.getOrDefault(c, 0) + (int)Math.pow(10, originArr[i].length() - j - 1));
			}	
		}
		
		List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(hm.entrySet());
		entryList.sort(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		
		HashMap<Character, Integer> dic = new HashMap<>();
		int num = 9;
		for(Map.Entry<Character, Integer> entry : entryList){
			char key = entry.getKey();
			
			if (!dic.containsKey(key)) {
				dic.put(key, num);
				num--;
			}
		}

		
		int sum = 0;
		for (int i = 0; i < originArr.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < originArr[i].length(); j++) {
				sb.append(dic.get(originArr[i].charAt(j)));
			}
			
			sum += Integer.parseInt(sb.toString());
		}
		
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
		
	}

}
