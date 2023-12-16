import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _25166 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 1 ~ 2023 사이의 숫자는 모두 가능. 
		if (S <= 1023) {
			bw.write("No thanks");
		}
		else {
			// 두 명의 돈을 모두 합쳐도 금액이 부족한 경우
			if (S > 2046) {
				bw.write("Impossible");
			}
			else {
				S -= 1023; // 아리의 돈은 다 쓰고
				int mask = 1;
				boolean possible = true;
				while (mask != 0) {
					if ((mask & S) != 0) {
						if ((mask & M) == 0) {
							possible = false;
							break;
						}
					}
					
					mask = mask << 1;
				}
				
				if (possible) {
					bw.write("Thanks");
				}
				else {
					bw.write("Impossible");
				}
			}
		}
	
		bw.flush();
		bw.close();
	}

}
