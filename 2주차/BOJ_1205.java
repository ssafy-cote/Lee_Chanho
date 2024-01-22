import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1205 {
	/*
	 * 노래마다 랭킹리스트가 있다. 위에서부터 몇번쨰있는 점수인지로 등수를 정하는데 위에서부터 같은점수면 그러한 점수의 등수중 가장 작은 등수를
	 * 공동으로 수여받음 ex)1등,2등,2등,4등 ---------------- 리스트에 있는 점수의 개수 N,태수의 점수,랭킹리스트에 올라갈
	 * 수 있는 점수의 개수 P 랭킹리스트에서 몇등하는지 구하는 프로그램 만약 랭킹에 못들면 -1출력 랭킹리스트가 꽉차있으면 무조건 최하 랭킹의
	 * 점수보다 높아야함(같으면안됨)
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int taesoo = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int[] scores = new int[N];
		int ans = 1;
		if (N > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
		}
		int temp = 0;
		for (int i = 0; i < N; i++) {
			if (scores[i] < taesoo) {
				if (temp != 0) {
					ans = temp;
					break;
				} else {
					ans = i + 1;
					break;
				}
			} else if (scores[i] == taesoo) {
				if (temp == 0)
					temp = i + 1;
			}
			if (i == N - 1) {
				if (N < P) {
					if (temp != 0) {
						ans = temp;
						break;
					} else
						ans = i + 2;
				} else
					ans = -1;
			}
		}

		System.out.println(ans);
	}

}
