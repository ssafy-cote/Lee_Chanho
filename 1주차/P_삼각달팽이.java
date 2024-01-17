import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int n = Integer.parseInt(br.readLine());

		int[][] snail = new int[n][]; // 일단 열값은 비워둠

		for (int i = 0; i < n; i++) {
			snail[i] = new int[i + 1];
		}

		int cnt = 1;
		int r = 0;
		int c = 0;

		int rlim = n - 1;
		int clim = n - 1;

		while (true) {

			if (snail[r][c] == 0) {// 0이면 기록해주기
				snail[r][c] = cnt;
				cnt++;
				if (r == rlim && c == clim) {// 대각 가야할때
					while (r - 1 >= 0 && c - 1 >= 0 && snail[r - 1][c - 1] == 0) {
						r--;
						c--;

						snail[r][c] = cnt;
						cnt++;
					}
					if (r <= 0 && c <= 0)
						break; // n이 1일때를 위해 먼저 체크해줌 (인덱스 에러 방지)
					else if (r >= rlim && c >= clim)
						break; // n이 2일때
					r++;
					rlim--;
					clim -= 2; // 열리미트는 -2해줘야함
				} else if (r == rlim) // r이 rlim까지 갔을때
					c++;
				else// c가 clim까지 안왔고 r도 rlim까지 안갔을 때
					r++;

			} else
				break;

		}
		int idx = 0;
		int [] ans = new int[cnt-1];
		for (int i=0; i<snail.length;i++) {
			for(int j=0;j<snail[i].length;j++) {
				ans[idx++] = snail[i][j];
			}
		}
        return ans;
    }
}