import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int solution(int[][] graph) {
        int[][] visited = new int[graph.length][graph[0].length];
		int answer = -1;
		
		BFS(graph,0,0, visited);
		
		if(visited[graph.length-1][graph[0].length-1]==0) return answer;
		else return graph[graph.length-1][graph[0].length-1]+1;
		
		
		
		
		

	}
	static void BFS(int[][] map,int r , int c, int[][] visited) {
        visited[0][0] = 1;
		int[] dy = {0,1,0,-1};
		int[] dx = {1,0,-1,0};
		map[0][0] = 0;
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				if(ny>=0&&ny<map.length&&nx>=0&&nx<map[ny].length) {
					if(map[ny][nx]==1&&visited[ny][nx] == 0) {
                        visited[ny][nx]=1;
						q.offer(new int[] {ny, nx});
						map[ny][nx] = map[y][x]+1;
					}
				}
			}
		}
	}

}
