package study0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
	/*
	 * 기름통의 크기는 무제한
	 * 도로를 이동할때 1km에 1리터를 사용함
	 * 도시의 개수를 나타내는 정수 N(2<N<=100000)
	 * 다음줄에는 인접한 두 도시를 연결하는 도로의 길이가 N-1개의 자연수로 주어짐
	 * 다음줄에는 주유소의 리터당 가격이 제일 왼쪽 도시 순서대로 N개 주어짐
	 * 끝에 끝도시까지의 거리는 최대 10억, 리터당 가격은 최대 10억
	 * ---------
	 * 건너야 하는총 거리의 수는 배열 distance의 총합
	 * 현재 지점에서 자기보다 낮은 가격의 주유소가 있는지 탐색
	 * 나올때까지 탐색한다음 나온다면 거기까지의 거리만큼만 주유를함
	 * 다음 주유소에서도 그것을 반복 만약 끝까지 안나온다면 끝까지 주유를 하고 끝
	 * 모든 변수를 long으로 처리해야 안터질듯
	 */
	
	//42368kb, 364ms

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] distance = new long[N-1];
		long[] oil = new long[N];
		long ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			oil[i] = Integer.parseInt(st.nextToken());
		}
		int idx = 0;
	A:	while(idx < N) {
			int temp = 0; //현재까지의 거리 총합
			for(int i = idx; i<N; i++) {
				if (i==N-1) { // 만약 맵 끝에 도착했다면 
					ans += temp*oil[idx]; // 현재까지의 거리에다가 현재위치의 오일값을 곱해서 더해줌
					break A;
				}
				if (oil[idx]>oil[i]) { // 만약 현재 오일값보다 낮은 주유소를 발견했다면
					ans += temp*oil[idx]; //거기까지 가는 거리만 주유해줌
					idx = i; // 주유소이동
					continue A;
				}
				temp += distance[i]; // i가 현재 idx보다 기름값이 높다면 i다음까지 가는 거리를 더해줌
			}
			
			
			
		}
		System.out.println(ans);
	}

}
