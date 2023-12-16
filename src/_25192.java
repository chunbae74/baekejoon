import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class _25192 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		int count = 0;
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			if (input.endsWith("ENTER")) {
				hs.clear();
			}
			else {
				if (!hs.contains(input)) {
					count ++;
					hs.add(input);
				}
			}
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
