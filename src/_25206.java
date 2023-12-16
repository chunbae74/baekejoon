/**
 * 과목명 학점 등급
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _25206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String subName = "";
		double score = 0.0;
		String grade = "";
		double avg = 0.0;
		double totalScore = 0.0;
		StringTokenizer st;
		for (int i = 0; i<20; i++) {
			st = new StringTokenizer(br.readLine());
			subName = st.nextToken();
			score = Double.parseDouble(st.nextToken());
			grade = st.nextToken();
			if (grade.equals("P")) continue;
			avg += score * chunbae(grade);
			totalScore += score;
		}
		avg /= totalScore;
		bw.write(String.format("%.6f", avg) + "");
		bw.flush();
		bw.close();
	}
	
	public static double chunbae(String grade) {
		double d = 0.0;
		switch(grade) {
		case "A+":
			d =  4.5;
			break;
		case "A0":
			d =  4.0;
			break;
		case "B+":
			d =  3.5;
			break;
		case "B0":
			d =  3.0;
			break;
		case "C+":
			d =  2.5;
			break;
		case "C0":
			d =  2.0;
			break;
		case "D+":
			d =  1.5;
			break;
		case "D0":
			d =  1.0;
			break;
		case "F":
			d =  0.0;
			break;
		}
		return d;
	}

}
