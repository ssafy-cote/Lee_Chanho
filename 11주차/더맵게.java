import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<scoville.length; i++) {
			pq.offer(scoville[i]);
		}
		
		int answer = 0;
		while(!pq.isEmpty()) {
			if(pq.peek()>=K) break; // 최소값이 K를 넘을 때
			else if(pq.peek()<K&&pq.size()<2) { // 최소값이 K를 못넘는데 하나밖에 안남았을 때
				answer = -1;
				break;
			} else { //최소값이 K를 못넘고 K가 2개이상 남았을 때
				pq.offer(pq.poll()+(pq.poll()*2));
				answer++;		
			}
			
		}
		return answer;
    }
}
