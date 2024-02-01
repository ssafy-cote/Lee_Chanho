package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_조이스틱 {
	static int answer;
	static String s;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		answer = 0;
		int cnt = s.length()-1; //오른쪽으로 쭉달렸을때 커서변경 횟수 
		System.out.println(s.length()-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) - 'A' <= 13) { //알파벳 26개 반갈
				answer += s.charAt(i) - 'A';
			} else {
				answer += 'Z' - s.charAt(i) + 1;
			}
			
			int idx = i+1;
			while(idx<s.length()&&s.charAt(idx)=='A') { //다음알파벳이 인덱스인지 확인하고 A가 아닌게 나올때까지 idx++
				idx++;
			}
			//A가 연속인 배열을 만났을 때 오른쪽으로 갔다가 왼쪽으로 다시 꺾을 것인가 vs 왼쪽으로 먼저갔다가 오른쪽으로 꺾을것인가
			cnt = Math.min(cnt, Math.min(i*2+s.length()-idx, (s.length()-idx)*2+i));
		}
		answer+=cnt;
		System.out.println(answer);
	}

}