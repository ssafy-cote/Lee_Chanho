import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//175484kb	2096ms      ->투포인터로 풀어보기
public class Main {
	/*
	 * M미터를 가지고 가기 위한 최대 높이값 구하기
	 * 높이가 H라면 H위의 나무들만 잘리고 그 차액만큼을 가지고갈 수 있다.
	 * 나무의 수는 1<=N<=1,000,000   나무의 길이 M은 1<=M<=20억
	 * M의 최댓값은 1조
	 * -------
	 * 일단 배열에다가 담고 배열을 정렬후에 역순으로 돌기
	 * 높이는 최댓값의 -1로 설정후 최댓값과 같은 값이 나온다면 그때까지의 임시값이 M이상인지 확인후 리턴
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		int height = nums[nums.length-1]-1;
		while(true) {	
			long temp = 0;
			
			for(int i=nums.length-1; i>=0; i--) {
				if(nums[i]<=height) break;
				temp+= nums[i]-height;				
			}
			if(temp>=M) break;
			height--;
		}
		
		System.out.println(height);

		

	}

}
