import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1699 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int count = 100;
		for (int i = 1; i*i<=n; i++) {
//			System.out.println();
//			System.out.println("[for1] i = " + i);
			int c = 100;
			int time;
			for (time = 0; n-(i*i*time)>0; time++) c = getCount(n-(i*i*time));
			if (count > c+time) count = c + time;
		}
		if (n == 1) count = 1;
		System.out.println(count);
	}

	public static int getMaxI(int num) {
		int i;		
		for(i = 1; i*i<=num; i++);
//		System.out.println("[getMaxI] return "+(i-1) );
		return i-1;
	}
	
	public static int getCount(int num) {
		int count = 0;
		while(num > 0) {
			int i = getMaxI(num);
			num -= i*i;
			count++;
		}
//		System.out.println("[getCount] return " + count);
		return count;
	}
}
