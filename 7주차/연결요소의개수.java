import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N; // 1번부터 N번까지 존재
	static int M; // 간선 갯수
	//연결요소 구하기(연결요소는 서로 연결되어있는게 무엇인지 한 덩어리가 연결요소임
	static boolean[] visited;
	static List<Integer>[] list;
	static int ans;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		list = new List[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1; i<=N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			ans++;
			BFS(i);
			
		}
		System.out.println(ans);
		
		

	}
	public static void BFS(int start) {
		
		
		
		for(int numbers: list[start]) {
			if(visited[numbers]) continue;
			visited[numbers] = true;
			BFS(numbers);
		}
		
		
		
	}

}
