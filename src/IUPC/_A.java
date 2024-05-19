package IUPC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * @: 로봇
 * #: 박스
 * !: 깃발
 */
public class _A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		
		int robot = -1;
		int box = -1;
		int flag = -1;
		for (int i = 0; i < 10; i++) {
			char c = input.charAt(i);
			if (c == '@') robot = i;
			else if (c == '#') box = i;
			else if (c == '!') flag = i;
		}
		
		int count = 0;
		// 깃발이 로봇과 박스 사이에 있는 경우
		if ((robot <= flag && flag < box) || box < flag && flag <= robot) {
			count = -1;
		}
		// 로봇이 깃발과 박스 사이에 있는 경우
		else if ((flag <= robot && robot < box) || (box < robot && robot <= flag)) {
			count = -1;
		}
		// 박스가 맨 끝에 있는 경우
		else if (box == 0 || box == 9) {
			count = -1;
		}
		else {
			// 인접한 빈칸으로 이동한다 명령어 수행
			count += Math.abs(box - robot) - 1;
			// 인접한 칸의 박스를 밀고 박스가 있던 칸으로 이동한다 명령어 수행
			count += Math.abs(flag - box);
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
