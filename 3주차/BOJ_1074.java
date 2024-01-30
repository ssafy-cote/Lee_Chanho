package Study;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
	
	private static void DFS(int N, int y, int x, int num) {
		int ny;
		int nx;
		int newnum;

		
		
		int dir = -1;
		if (y<Math.pow(2, N-1)&&x<Math.pow(2,N-1)) { //블록을 4등분했을 때 왼쪽 위
			dir = 0;
			ny = y;
			nx = x;
			newnum = num;
		}
		else if(y<Math.pow(2, N-1)&& x>=Math.pow(2, N-1)) { //블록을 4등분 했을 때 오른쪽 위
			dir = 1;
			ny = y;
			nx = x-(int)(Math.pow(2, N-1)); //4등분한 블럭을 새로운 블럭으로 봤을때 y좌표와 x좌표 조정
			newnum = num+(int)(Math.pow(2, N-1)*Math.pow(2, N-1)*dir); // 블럭을 4등분했을때 해당하는 값을 넘겨줘야함			
		}
		else if(y>=Math.pow(2, N-1)&& x<Math.pow(2, N-1)) { // 블록을 4등분 했을 때 왼쪽 아래 
			dir = 2;
			ny = y-(int)(Math.pow(2, N-1));
			nx = x;
			newnum = num+(int)(Math.pow(2, N-1)*Math.pow(2, N-1)*dir);
		}
		else { 												// 블록을 4등분 했을 때 오른쪽 아래
			dir = 3;
			ny = y-(int)(Math.pow(2, N-1));
			nx = x-(int)(Math.pow(2, N-1));
			newnum = num+(int)(Math.pow(2, N-1)*Math.pow(2, N-1)*dir);
		}
		if (N==1){
			System.out.println(num+dir);
			return;
		}		
		DFS(N-1, ny, nx, newnum);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		DFS(N, r, c, 0);

	}

}
