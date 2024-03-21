package algo0318;

import java.util.ArrayList;
import java.util.List;

/*
 * 후보키인지 검사 -> 부분집합으로 전부 검사하면 된다.
 * 파워셋으로 후보키를 하나 만들었다면? ->  그 열은 다음 검사에서 제외
 * 후보키 검사 과정:
 * 	행 갯수만큼 리스트배열 만들기
 * 	현재 검사중인 열을 리스트에 담아서 하나씩 중복체크
 * 	만약 중복이 있다면 리턴
 * 	중복이 없다면 선택한 열들을 이미 선택했다는 boolean배열에 넣어놓고 cnt+1하기
 * -----------------
 * 최소성이라는거는 이미 선택한걸 제외하는것이 아닌
 * 이미 선택된 것에서 더 선택된 것이 있는지 체크하는 것임
 * 즉 1부터 현재선택된 갯수의 -1까지 선택된 것이 있는지 체크해주면됨
 * 0 1 2 3 4
 * 01 02 03 04
 * 012 023 
 * 문자열의 contain 함수는 02가 이미 선택됐을 때 현재 선택한 칼럼이 012라면 비교가 안됨
 * 	->문자열 하나하나 다 비교하기 
 * 
 */
class Solution {
	static List<String>[] list; // 현재까지 선택했던 칼럼들
	static boolean[] selected; // 현재 선택한 컬럼
	static String[][] relation;
	static int ans;
	static String[] strings;

	public int solution(String[][] relation2) {
		relation = relation2;
		selected = new boolean[relation[0].length];

		strings = new String[relation.length];

		list = new List[relation[0].length + 1]; // 칼럼 갯수 기준으로 리스트 초기화
		for (int i = 1; i <= relation[0].length; i++) {
			list[i] = new ArrayList<>();
		}
		powerSet(0);

		return ans;
	}

	static boolean chk(String cur, String s, int depth) { //현재 선택된 칼럼들과 지금까지 선택해왔던 컬럼들 비교
		if (depth == s.length()) { //만약 끝까지 둘어왔다면 모든 문자열이 포함되는 것이므로 테이블의 최소화를 만족시키지 않음
			return true;
		}
		if (cur.contains(String.valueOf(s.charAt(depth)))) { //현재 인덱스의 문자열이 있다면 재귀로 들어가기
			return chk(cur, s, depth + 1); // 여기서 return 해줘야 안꼬임
		}
		return false;
	}

	static void powerSet(int depth) { // 부분집합 돌리기
		if (depth == relation[0].length) {
			int cnt = 0; // 열 갯수 체크
			String cursel = "";
			for (int i = 0; i < relation[0].length; i++) { // 먼저 그전에 선택됐었는지 체크
				if (selected[i]) {
					cnt++;
					cursel += i; // 문자열로 현재 선택된 칼럼들 담기
				}
			}
			if (cnt == 0)
				return; // 하나도 선택안했을시 리턴

			for (int i = 1; i < cnt; i++) { //칼럼 갯수 1부터 현재  선택된 칼럼갯수의 -1까지 선택된 것들 비교하기

				for (String s : list[i]) {
					if (chk(cursel, s, 0)) {
						return;
					}
				}
			}
			for (int i = 0; i < relation.length; i++) { //선택한 칼럼이 유일값인지 체크
				strings[i] = "";
				for (int j = 0; j < selected.length; j++) { // 스트링 배열에 선택한 튜플의 칼럼들 담기
					if (selected[j]) {
						strings[i] += relation[i][j]; // 선택됐다면 추가하기
					}
				}
				for (int k = 0; k < i; k++) {
					if (strings[k].equals(strings[i]))
						return;
				}
			}

			// 만약 다 중복없이 돌았다면 후보키
			list[cnt].add(cursel); // 리스트에 후보키의 칼럼 추가
			ans++;

			return;
		}
		
		selected[depth] = false;
		powerSet(depth + 1);
		selected[depth] = true;
		powerSet(depth + 1);

	}
}
