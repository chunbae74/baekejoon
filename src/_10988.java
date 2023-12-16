import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10988 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(br.readLine());
		bw.write(sb.toString().equals(sb.reverse().toString())?"1":"0");
		/*
		String s = br.readLine();
		boolean isRight = true;
		if (s.length()%2 == 0) { // 단어개수 짝수개 lool
			for (int i = 0; i < s.length()/2; i++) {
				if (!s.split("")[i].equals(s.split("")[s.length()-1-i])) {
					isRight = false;
					break;
				}
			}
		} else { // 단어개수 홀수개 level
			for (int i = 0; i < (s.length()-1)/2; i++) {
				if (!s.split("")[i].equals(s.split("")[s.length()-1-i])) {
					isRight = false;
					break;
				}
			}
		}
		bw.write(isRight?"1":"0");
		*/
		bw.flush();
		bw.close();
	}

}
