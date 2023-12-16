import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String firstNum = br.readLine();
		if(firstNum.length() != 2) firstNum = 0 + firstNum;
		String result = firstNum;
		int count = 0;
		do {
			int n1 = Integer.parseInt(result.split("")[0]);
			int n2 = Integer.parseInt(result.split("")[1]);
			int n3 = n1 + n2;
			if (n3 > 9) n3 %= powerOfTen(n3); 
			result = Integer.toString(n2) + Integer.toString(n3);
			count ++;
		} while(Integer.parseInt(firstNum) != Integer.parseInt(result));
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
	
	public static int powerOfTen(int n) {
		String s = Integer.toString(n);
		return (int)Math.pow(10,  s.length() - 1);
	}

}
