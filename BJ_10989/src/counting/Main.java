package counting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int number = Integer.parseInt(br.readLine());
			int num[] = new int[10001]; // 10000까지의 숫자에 대한 개수 저장
			int data[] = new int[number]; // 입력받은 데이터
			int sort[] = new int[number]; // 정렬해서 넣을거
			
			for(int i = 0; i<number; i++) {
				int input = Integer.parseInt(br.readLine());
				data[i] = input;
				num[input]++; // 입력 데이터를 인덱스로 하는 곳의 값을 1증가
			}
			
			int count = num[0]; // 이게 0이었어도 상관x
			for(int i = 1; i<num.length; i++) {
				if(num[i] != 0) {
					// 0이 아니면 입력받은 수라는 의미
					num[i] += count; // 카운트 누적
					count = num[i]; // 카운트 갱신
				}	
			}
			
			for(int i=number-1; i>=0; i--) {
				num[data[i]]--; // 입력 데이터가 있는 곳의 값을 1 줄이고
				sort[num[data[i]]] = data[i];
				// 그곳을 인덱스로 하여 데이터 저장 
				
			}
			
			for(int i=0; i<number; i++) {
				bw.write(sort[i]+"\n");
			}			
			bw.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
