import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1074 {
	static int N, X, Y;
	static int count = 0;
	static boolean gotYa = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N);
		
		chunbae(0, 0, size);

		bw.write(count + "");
		bw.flush();
		bw.close();
	}
	
	public static void chunbae(int x, int y, int size) {
		if (gotYa) return;
		else {				
			if (size == 2) {
				// 제 2사분면
				if (x == X && y == Y) {
					gotYa = true;
					return;
				}
				// 제 1사분면
				else if (x + 1== X && y == Y) {
					gotYa = true;
					++ count;
					return; 
				}
				// 제 3사분면
				else if (x == X && y + 1 == Y) {
					gotYa = true;
					count += 2;
					return;
				}
				// 제 4사분면
				else if (x + 1 == X && y + 1 == Y) {
					gotYa = true;
					count += 3;
					return;
				}
			}
			

			size = size / 2;
			// 제 2사분면
			if (X < x + size && Y < y + size) {
				chunbae(x, y, size);				
			}
			// 제 1사분면
			else if (X >= x + size && Y < y + size) {
				count += (int)Math.pow(size, 2);
				chunbae(x + size, y, size);
			}
			// 제 3사분면
			else if (X < x + size && Y >= y + size) {
				count += (int)Math.pow(size, 2) * 2;
				chunbae(x, y + size, size);				
			}
			// 제 4사분면
			else if (X >= x + size && Y >= y + size) {
				count += (int)Math.pow(size, 2) * 3;
				chunbae(x + size, y + size, size);				
			}
		}
	}

}
