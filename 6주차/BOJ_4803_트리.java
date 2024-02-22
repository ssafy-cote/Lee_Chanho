package study0219;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4803_트리 {
	/*
	 * 트리의 조건
	 * 정점은 N개 간선은 N-1개, 즉 간선0개의 고립되어있는 정점도 하나의 트리임
	 * 정점은 사이클이 없다, 즉 두 정점에 대해서 경로가 유일하다.
	 * 그말은BFS를 돌 때 중복이 없다면 그건 하나의 트리라는 것임
	 * for문으로 정점 N개를 다 BFS를 돈다(방문안한것만)
	 * BFS를 돌 때 만약 visited체크한 것을 한번 더 방문하면 트리가 아니다.
	 * 하지만 다 돌긴해야한다
	 * 만약 고립되어있는 정점이라면 큐에 정보가 안들어가므로 큐에서 빠져나올때 cnt+1
	 */
	
	
	//63388kb, 424ms
	static StringBuilder sb = new StringBuilder();
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 1;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());//정점의 개수
			int M = Integer.parseInt(st.nextToken());//간선의 개수
			if(N==0&&M==0) break;//종료조건
			ans = 0;
			
			adjList = new List[N+1];
			visited = new boolean[N+1];
			for(int i=1; i<=N; i++) {
				adjList[i] = new ArrayList<>();
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);	
				adjList[to].add(from);
			}
			
			for(int i=1; i<=N; i++) {
				if(!visited[i])	BFS(i);
			}
//			for(int i=1; i<=N; i++) {
//				if(!visited[i]) BFS(i);
//			}
			if (ans==1) {
				sb.append("Case "+tc+": There is one tree.\n");
			} else if(ans==0) {
				sb.append("Case "+tc+": No trees.\n");
			} else {
				sb.append("Case "+tc+": A forest of "+ans+" trees.\n");
			}
			tc++;		
			
		}
		System.out.println(sb);
		

	}
	
	public static void BFS(int start) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start, 0});
		visited[start]= true;
		int flag = 0;
		int before = 0;
		
		while(!q.isEmpty()) {
			int from = q.peek()[0];
			before = q.peek()[1];
			q.poll();
			for(int to:adjList[from]) {
				if(to==before) continue;
				if(visited[to]) {
					flag = 1;
				} else {
					visited[to] = true;
					q.offer(new int[] {to, from});
				}
			}
			
		}
		if (flag==0) {
			ans++;
			return;
		}
		return;
		
		
		
	}

}