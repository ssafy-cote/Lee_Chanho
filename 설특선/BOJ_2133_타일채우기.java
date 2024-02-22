package study0219;
import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	//11472kb 80ms
	public class BOJ_2133_타일채우기 {
	
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[31];
			dp[0] = 1;
			dp[2] = 3;
			
			for(int i=4; i<=N; i++) {
				dp[i] = dp[i-2]*3;
				for(int j=i-4; j>=0; j-=2) {
					dp[i] += dp[j]*2;
				}
			}
			System.out.println(dp[N]);
		}
	
	}