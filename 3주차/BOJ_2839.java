package Study;
import java.util.Scanner;

public class BOJ_2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

//		int five = 0;
//		int three = 0;
//		int remain = N;
//		five = N / 5;
//		remain = N % 5;
//		three = remain / 3;
//		remain = remain % 3;
//		while (remain != 0) {
//			if (five >= 1) {
//				remain += 5;
//				five--;
//				three += (remain / 3);
//				remain %= 3;
//				if (three-five >= 5)
//					break;
//			} else break;
//
//		}
		int cnt = 0;
		while(N>=0) {
			if (N%5==0) {
				System.out.println(N/5+cnt);
				return;
			}
			N -=3;
			cnt++;
		}
		System.out.println(-1);
		
		

	}

}
