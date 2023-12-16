import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _17103 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] isNotSosu= new boolean[1_000_000 + 1];
		isNotSosu[0] = isNotSosu[1] = true;
		for(int i = 2; i*i <= isNotSosu.length; i++) {
			if (!isNotSosu[i]) {
				for(int j = i*i; j < isNotSosu.length; j+= i) isNotSosu[j] = true;				
			}
		}
	
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			int num = Integer.parseInt(br.readLine());
			int count = 0;
			for(int j = 2; j <= num/2; j++) {
				int num2 = num - j;
				if (!isNotSosu[j] && !isNotSosu[num2]) count++;
			}
			sb.append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
