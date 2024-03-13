import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	/*
	 * 테스트케이스의 수 T
	 * 동전의 가지수 N 
	 * N개의 동전이 오름차순으로 정렬되어 주어지 
	 * 동전으로 만들어아햘 금액 M 이 주어짐
	 * 현재 주어진 것으로 무조건 나눔
	 * 만약 나누어 떨어진다면+1
	 * 하나씩 더해서 그 밑에있는 숫자들로 나누어주기
	 * 현재 동전  n원에서 m원을  만들 수 있는 경우의 수는 그전까지 m-n원에서 n원을 더한 값
	 * 즉 0원보다 큰 값에서 n의 배수를 뺀 경우의수를 다 더해주면됨 
	 */
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());
			
			int M = Integer.parseInt(br.readLine());
			
			int[] dp = new int[M+1];
			dp[0]= 1;
			for(int i=nums[0]; i<=M; i+=nums[0]) {
				dp[i] = 1;
			}
			
			for(int i=1; i<N; i++) {
				
				int curnum = nums[i];
				
				for(int num=nums[i]; num<=M; num++) {
					dp[num] = dp[num]+dp[num-curnum];
				}
					
			}
			sb.append(dp[M]+"\n");
		}
		System.out.println(sb);

	}

}
