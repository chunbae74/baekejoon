import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _27982 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if (M < 7) bw.write("0");
		else {
			ArrayList<String> al = new ArrayList<>();
	
			for (int i = 0; i < M; i++) {
				al.add(br.readLine());
			}
			
			int count = 0;
			for (int i = 0; i < al.size(); i++) {
				int I = Integer.parseInt(al.get(i).split(" ")[0]);
				int J = Integer.parseInt(al.get(i).split(" ")[1]);
				int K = Integer.parseInt(al.get(i).split(" ")[2]);
				String s1 = (I - 1) + " " + J + " " +  K;
				String s2 = (I + 1) + " " + J + " " + K;
				String s3 = I + " " + (J - 1) + " " + K;
				String s4 = I + " " + (J + 1) + " " + K;
				String s5 = I + " " + J + " " + (K - 1);
				String s6 = I + " " + J + " " + (K + 1);
				if (al.contains(s1) && al.contains(s2) && al.contains(s3) && al.contains(s4) && al.contains(s5) && al.contains(s6)) count ++;
			}
			
			bw.write(count + "");
		}
		bw.flush();
		bw.close();
	}

}
