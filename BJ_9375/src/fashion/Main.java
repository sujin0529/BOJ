package fashion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> clothes;
		
		int N = Integer.parseInt(sc.nextLine());
		for(int i=0; i<N; i++) {
			clothes = new HashMap<String, Integer>();
			int number = Integer.parseInt(sc.nextLine()); // 의상의 수
			
			for(int j=0; j<number; j++) {
				// 의상 입력받고 종류 구별하는 것까지
				String s = sc.nextLine();
				String[] item = s.split(" ");
				if(clothes.containsKey(item[1])) {
					// 만약 이미 있는 종류라면
					clothes.put(item[1], clothes.get(item[1])+1);
					// 값 1 증가
				}
				else {
					clothes.put(item[1], 1);
				}
			}
			int size = clothes.size(); // 의상의 종류 수
			int all_clothes[] = new int[size];
			Set<String> key = clothes.keySet();
			Iterator<String> iter = key.iterator();
			int index = 0;
			while(iter.hasNext()) {
				all_clothes[index] = clothes.get(iter.next());
				index++;
			}
			// 의상의 종류에 따라 그 개수를 모두 배열로 옮김
			
			int total = 0;
			int mul = 1;
			for(int j=0; j<size; j++) {
				mul *= (all_clothes[j]+1);
			}
			total = mul-1;
			
//			for(int s = 1; s<=size; s++) {
//				index = 0;
//				while(index < size) {
//					int mul = 1; // 경우의 수 구하는데 곱이 쓰이기 때문에 사용하는 변수
//					for(int k=index; k<s+index; k++) {
//						mul *= all_clothes[k];
//					}
//					index += s;
//					total += mul;
//				}
//				
//			}
			System.out.println(total);
		}

	}

}
