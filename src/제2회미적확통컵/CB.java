package 제2회미적확통컵;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
/**
 * (a, b, c)
 * (e-sin-cos, e-cos-cos, e-sin-sin)
 * @author geo
 *
 */
public class CB {
	static int n;
	// 현재 있는 개수
	static double[] arr = {1.0, 0.0, 0.0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		
		chunbae(n);
		System.out.println(Arrays.toString(arr));
		int result = (int)(arr[0] + arr[1] + arr[2]);
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
	
	public static void chunbae(int loop) {
		if (loop == 0) return;
		
		double a = arr[0];
		double b = arr[1];
		double c = arr[2];
		
		double aa = 0;
		double bb = 0;
		double cc = 0;
		
		if (a != 0) {
			aa += a * 1;
			bb += a * 1;
			cc += a * -1;
		}
		if (b != 0) {
			aa += b * -2;
			bb += b * 1;
		}
		if (c != 0) {
			aa += c * 2;
			cc += c * 1;
		}

		arr[0] = aa;
		arr[1] = bb;
		arr[2] = cc;
		
		
		chunbae(--loop);
	}

}
