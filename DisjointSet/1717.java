import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// [백준 1717] 집합의 표현
// https://blog.naver.com/tnwls0529/221803389383

public class Main {
	
	static int find(int[] set,int element) {
		// 부모를 찾아서 반환하는 메소드. 음수를 반환하면 자기자신이 루트
		int parent = set[element];
		while(parent >= 0) {
			if(set[parent]<0) {
				// parent의 부모가 -1이면 parent가 root라는 의미이므로 break
				break;
			}
			else {
				set[element] = find(set, parent);
				element = parent;
				parent = set[parent];
				
				// -1이 아니라면 현재 parent가 root가 아니라는 의미이므로 parent 수정
			}
			
		}
		return parent;
	}
	
	static void combine(int[] set, int element1, int element2) {
		// 사이즈도 기억하도록 해야겠네
		int parent1 = find(set, element1);
		int parent2 = find(set, element2);
		if(parent1<0 && parent2<0) {
			// 둘 다 루트인 경우
			if(parent1<parent2) {
				// parent1에 더 많은 자식
				set[element2] = element1; // 부모 수정
				set[element1] += parent2; // 사이즈 수정
			}
			else {
				set[element1] = element2; // 부모 수정
				set[element2] += parent1; // 사이즈 수정
			}
		}
		else if(parent1<0) {
			// 첫번째만 루트인 경우
			int size2 = find(set, parent2); // 두번째 것 사이즈 갖고오기
			if(element1 == parent2) {
				// 이미 같은 집합인가
			}
			else if(parent1<size2) {
				// parent1에 더 많은 자식
				set[parent2] = element1; // 부모 수정
				set[element1] += size2; // 사이즈 수정
			}
			else {
				set[element1] = parent2; // 부모 수정
				set[parent2] += parent1; // 사이즈 수정
			}
		}
		else if(parent2<0) {
			// 두번째만 루트인 경우
			int size1 = find(set, parent1); // 첫번째 것 사이즈 갖고오기
			if(parent1 == element2) {
				// 이미 같은 집합인가
			}
			if(size1<parent2) {
				// parent1에 더 많은 자식
				set[element2] = parent1; // 부모 수정
				set[parent1] += parent2; // 사이즈 수정
			}
			else {
				set[parent1] = element2; // 부모 수정
				set[element2] += size1; // 사이즈 수정
			}
		}
		else if(parent1 == parent2) {
			// 부모가 같은가 -> 아무 것도 하지 않음
		}		
		else {
			// 부모가 같지 않고 둘 다 루트가 아닌 경우
			int size1 = find(set, parent1); // 첫번째 것 사이즈 갖고 오기
			int size2 = find(set, parent2); // 두번째 것 사이즈 갖고오기
			if(size1<size2) {
				// parent1에 더 많은 자식
				set[parent2] = parent1; // 부모 수정
				set[parent1] += size2; // 사이즈 수정
			}
			else {
				set[parent1] = parent2; // 부모 수정
				set[parent2] += size1; // 사이즈 수정
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		String[] temp;
		try {
			s = br.readLine();
			temp = s.split(" ");
			
			int number = Integer.parseInt(temp[0]); // 0 - number 까지 집합을 이룸
			int line = Integer.parseInt(temp[1]); // 수식의 수
			
			int set[] = new int[number+1];
			for(int i=0; i<number+1; i++) {
				set[i] = -1; // 모두 자신이 루트인 것으로 초기화
			}
			
			
			for(int i=0; i<line; i++) {
				s = br.readLine();
				temp = s.split(" ");
				int operator = Integer.parseInt(temp[0]); // 0이면 합, 1이면 확인
				int operand_1 = Integer.parseInt(temp[1]); // 첫 번째 원소
				int operand_2 = Integer.parseInt(temp[2]); // 두 번째 원소
				String result = ""; // 출력할 결과
				
				if(operator == 0) {
					if(operand_1 != operand_2) {
						combine(set, operand_1, operand_2);
					}
					// 만약 두 operand가 같다면 부모를 수정할 필요가 없음
				}
				else if(operator == 1) {
					int parent_1 = find(set, operand_1);
					int parent_2 = find(set, operand_2);
					if(parent_1<0 && parent_2<0) {
						// 둘 다 루트
						if(operand_1 == operand_2) {
							result = "YES";
						}
						else {
							result = "NO";
						}
					}
					
					else if(parent_1<0) {
						// 첫 번째만 루트
						if(operand_1 == parent_2) {
							result = "YES";
						}
						else {
							result = "NO";
						}
					}
					else if(parent_2<0) {
						// 두 번째만 루트
						if(parent_1 == operand_2) {
							result = "YES";
						}
						else {
							result = "NO";
						}
					}
					else {
						// 둘 다 루트 아님
						if(parent_1 == parent_2) {
							result = "YES";
						}
						else {
							result = "NO";
						}
					}
					
					System.out.println(result);
				}			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
