import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class _1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> al = new ArrayList<>();
		String input;
		for(int i = 0; i < N; i++) {
			input = br.readLine();
			if (!al.contains(input)) al.add(input);
		}
		Collections.sort(al, (e1, e2) -> {
			if (e1.length() == e2.length()) {
				return e1.compareTo(e2);
				/*
				int num = 0;
				for(int i = 0; i < e1.length(); i++) {
					num =  e1.charAt(i) - e2.charAt(i);
					if (e1.charAt(i) == e2.charAt(i)) continue;
					else break;
				}
				return num;
				*/
			} else return e1.length() - e2.length();
		});
		for(int i = 0; i<al.size(); i++) bw.write(al.get(i) + "\n");
		bw.flush();
		bw.close();
	}

}
