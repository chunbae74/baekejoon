package 제2회미적확통컵;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int result = integrate(a, b-d, c-e, x1, x2);
		bw.write(result + "");
		bw.flush();
		bw.close();
	}

	/*
	 * l(ax^2 + bx + c)dx
	 */
	public static int integrate(int a, int b, int c, int x1, int x2) {
	    a = a/3;
	    b = b/2;
	    double sum = 0.0;
	    
	    sum += a * (Math.pow(x2, 3) - Math.pow(x1, 3));
	    
	    sum += b * (Math.pow(x2, 2) - Math.pow(x1, 2));
	    
	    sum += c * (x2- x1);
	    
	    return (int)sum;
	}
}

