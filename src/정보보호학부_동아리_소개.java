import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Input : M, W, C, A, $ 중 하나
 * M : MatKor
 * W : WiCys
 * C : CyKor
 * A : AlKor
 * $ : $clear
 */
public class 정보보호학부_동아리_소개 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char input = br.readLine().charAt(0);
		
		switch (input) {
			case 'M':
				System.out.println("MatKor");
				break;
				
			case 'W':
				System.out.println("WiCys");
				break;
				
			case 'C':
				System.out.println("CyKor");
				break;
				
			case 'A':
				System.out.println("AlKor");
				break;
				
			case '$':
				System.out.println("$clear");
				break;		
		}
	}

}
