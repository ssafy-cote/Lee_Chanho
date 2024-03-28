import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	/*
	 * HashMap
	 * HashSet의 cnt순
	 * 해당단어의 길이순
	 * 알파벳 사전순 (compare)
	 */

	public static void main(String[] args) throws IOException{
		HashMap<String, Integer> hash = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String s= br.readLine();
			if(s.length()<M) continue;
			if(hash.get(s)==null)hash.put(s, 1);
			else hash.put(s, hash.get(s)+1);
			
		}
		
		List<String> keys = new ArrayList<>(hash.keySet());
		Collections.sort(keys, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(hash.get(o1)!=hash.get(o2)) {
					return hash.get(o2)-hash.get(o1);
				} else if (o2.length()!=o1.length()) {
					return o2.length()-o1.length();
				} else return o1.compareTo(o2);
				
			}
			
		});
		
		for(String s:keys) {
			sb.append(s+"\n");
		}
		System.out.println(sb);
		
		

	}

}
