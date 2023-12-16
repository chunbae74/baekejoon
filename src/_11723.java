import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String type;
		int x = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			type = st.nextToken();
			if (!type.equals("all") && !type.equals("empty")) x = Integer.parseInt(st.nextToken());
			switch(type) {
			case "add":
				set.add(x);
				break;
				
			case "remove":
				if(set.contains(x)) set.remove(x);
				break;
				
			case "check":
				bw.write(set.contains(x)?"1":"0");
				bw.write("\n");
				break;
				
			case "toggle":
				if(set.contains(x)) set.remove(x);
				else set.add(x);
				break;
				
			case "all":
				set.clear();
				for(int j = 1; j<=20; j++) set.add(j);
				break;
				
			case "empty":
				set.clear();
				break;
				
			}
		}
		bw.flush();
		bw.close();
	}

}
