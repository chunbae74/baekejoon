import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		s = s.replaceAll("c=", "ㅋ");
		s = s.replaceAll("c-", "ㅋ");
		s = s.replaceAll("dz=", "ㅋ");
		s = s.replaceAll("d-", "ㅋ");
		s = s.replaceAll("lj", "ㅋ");
		s = s.replaceAll("nj", "ㅋ");
		s = s.replaceAll("s=", "ㅋ");
		s = s.replaceAll("z=", "ㅋ");
		
		bw.write(s.length() + "");
		bw.flush();
		bw.close();
	}

}
