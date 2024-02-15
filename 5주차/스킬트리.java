package study0213;

public class 스킬트리 {
	/*
	 *	스킬트리가 주어진다 거기서 몇개가 가능한지만 리턴하면됨
	 *	안되는 경우는 스킬트리 순서대로 안배울때이고
	 *	만약 스킬중 어느 하나를 안배우거나 다른스킬을 도중에 찍는 것은 상관없음 오직 스킬트리만 중요
	 *  스킬트리 배열을 하나씩 꺼내서 초기 idx를 0으로 지정, 문자열에서 문자를 하나하나 꺼낸다음 스킬트리의 인덱스찾기를 이용해서
	 *  현재 idx보다 높은 값이 나온다면 안됨, 만약 다 돌았는데도 문제가 없으면 경우의수 +1
	 */
	public static void main(String[] args) {
		String skill= "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		int answer = 0;
		
	A:	for(String s: skill_trees) {
			int idx = 0;
			for(int i=0; i<s.length(); i++) {
				if (idx<skill.indexOf(s.charAt(i))) {
					continue A;
				}
				else if(idx==skill.indexOf(s.charAt(i))) {
					idx++;
				}
			}
			answer+=1;
		}
		System.out.println(answer);
		
		
		

	}

}
