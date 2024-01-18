import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_모음사전 {
	/*
	 * {A,E,I,O,U}
	 * 처음에 A를 선택
	 * 그후 A를 한번더선택
	 * 이렇게 글자수가 5가 될때까지 먼저 내려감
	 * 글자수 5가 되면 리턴
	 * 다시 AAAA에서 이젠 모음[1]을 고름
	 * AAAAE도 아니라면 리턴
	 * 이렇게 재귀로 계속 들어가서 값이 나오면 리턴
	 */
	static int count = 0;
	static int ans = 0;
	static String[] str = {"A","E","I","O","U"};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target = br.readLine();
		
		DFS("",target,0);
		System.out.println(ans);
		
		
	}
	
	public static void DFS(String now, String target, int len) {
		if (len>5) return;
		if (now.equals(target)) {
			ans = count;
			return;
		}
		count++;
		
		for (int i=0; i<5; i++) {
			DFS(now+str[i],target,len+1);
			if (ans>0) return;
		}
		
		
		
		
		
		
	}
	
	

}
