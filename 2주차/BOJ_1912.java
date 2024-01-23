
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 연속된 양수의 수열이 최고합일 경우
 * 음수를 낀 수열이 최고합일경우
 * 처음부터 음수만 나올 경우
 */

public class BOJ_1912 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		int ans = -1001;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int temp = 0;
		for (int i=0; i<n; i++) {
			if (temp+nums[i]>=0) { //만약 더해도 0보단 클때
				if (temp>=0) temp+=nums[i]; //temp가 양수였을때만 더해줌
				else if(temp<0 && (nums[i]>=0)) temp = nums[i]; // temp가 음수이고 nums[i]가 양수면 해당값으로 초기화
				ans = Math.max(ans, temp); 
			}
			else {
				temp = nums[i]; // 만약 수열이 음수밖에 없다면 계속 값 비교
				ans = Math.max(ans,  temp);
			}			
			
		}
		System.out.println(ans);

	}

}
