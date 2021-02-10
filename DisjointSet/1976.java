import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// [백준 1976] 여행 가자
// https://blog.naver.com/tnwls0529/221805489573

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 도시의 수
		int country[][] = new int[N][N];
		
		int M = sc.nextInt(); // 여행 계획에 속한 도시의 수
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				country[i][j] = sc.nextInt();
			}
		}
		// 1 연결, 0 연결 x
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) {
					country[i][j] = 1;
				}
				
			}
		}
		// i->i 인 경우 반드시 연결
		
		Set<Integer> same = null;
		Set<Integer> management[] = new HashSet[N];
		
		int size = 0; // 처음 만들 때 집합의 개수
			
		for(int i=0; i<N; i++) {
			
			same = new HashSet<Integer>();
			for(int j=0; j<N; j++) {
				if(country[i][j]==1) {
					// 만약 연결 되어있다면
					same.add(i);
					same.add(j);
					// 둘 다 집합에 추가
				}
			}
			if(!same.isEmpty()) {
				// same이 비어있지 않다면 같은 집합으로 묶어야할 것이 있다는 의미
				management[size] = same;
				size++;
				// size는 현재 생성된 집합의 개수를 의미하며, 다음 집합이 위치할 인덱스 또한 의미함
			}
			
		}

		for(int i=0; i<size-1; i++) {
			if(management[i]==null) {
				// null인 경우 접근하지 못하도록 함
				continue;
			}
			for(int j=i+1; j<size; j++) {
				if(management[j]==null) {
					// null인 경우 접근하지 못하도록 함.
					continue;
				}
				Set<Integer> temp = new HashSet<Integer>(management[i]); // management[i] 수정 방지
				temp.retainAll(management[j]); // 교집합 확인
				if(!temp.isEmpty()) {
					// 교집합이 있다는 의미
					management[i].addAll(management[j]); // 합집합
					management[j] = null; // management[j]는 null로 비워서 합해진 것을 표시
				}
			}
		}

		Set<Integer> visit_country = new HashSet<Integer>();
		for(int i=0; i<M; i++) {
			// 방문하려는 도시 입력 받기
			visit_country.add(sc.nextInt()-1);
		}
		
		String result = "NO";
		for(int i=0; i<size; i++) {
			if(management[i] == null) {
				// null인 경우 접근하지 못하도록 함.
				continue;
			}
			else if(management[i].containsAll(visit_country)) {
				// 만약 management[i]가 visit_country 집합을 포함한다면 여행경로로 가능하다는 의미
				result = "YES";
			}
		}
		
		System.out.println(result);

	}

}
