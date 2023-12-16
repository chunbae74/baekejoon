import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2490 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for (int j = 0; j < 3; j++) {
			st = new StringTokenizer(br.readLine());
			int count = 0;
			int num = 0;
			for (int i = 0; i < 4; i++) {
				num = Integer.parseInt(st.nextToken());
				if (num == 0) count ++;
			}
			
			// 0 : 배 (count)
			// 1 : 등 
			switch (count) {
			case 0:
				bw.write("E\n");
				break;
			case 1:
				bw.write("A\n");
				break;
			case 2:
				bw.write("B\n");
				break;
			case 3:
				bw.write("C\n");
				break;
			case 4:
				bw.write("D\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		
	}

}
