package toyHammer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Heap{
	int[] arr;
	int size;
	
	public Heap(int length) {
		this.arr = new int[length+1];
		this.size = 0;
	}
	
	public void add(int value) {
		this.size++;
		int index = this.size;
		while(index != 1 && arr[index/2] < value) {
			arr[index] = arr[index/2];
			index /= 2;
		}
		arr[index] = value;
	}
	
	public int delete() {
		int result = arr[1];
		int parent = 1;
		int child = 2;
		int tmp = arr[this.size];
		
		while(child < this.size) {
			if(child < this.size+1 && arr[child] < arr[child+1]) {
				child++;
			}
			if(arr[child] < tmp) {
				break;
			}
			
			arr[parent] = arr[child];
			parent = child;
			child *= 2;
		}
		
		arr[parent] = tmp;
		this.size--;
		return result;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int people = Integer.parseInt(token[0]); // 거인나라 인구수
			int centi = Integer.parseInt(token[1]); // 센티의 키
			int count = Integer.parseInt(token[2]); // 뿅망치 사용 제한 횟수
			
			Heap height = new Heap(people);
			for(int i=0; i<people; i++) {
				height.add(Integer.parseInt(br.readLine()));

			}
			
			boolean check = false; // 센티의 키보다 모두 작다면 true
			int result = 0;
			int max = 0;
			
			while(result <= count) {
				max = height.delete();
				if(max < centi) {
					check = true;
					break;
				}
				else {
					result++;
					if(max == 1) {
						break;
					}
					height.add(max/2);
				}
			}
			
			if(check) {
				bw.write("YES\n");
				bw.write(result+"\n");
			}
			else {
				bw.write("NO\n");
				bw.write(max+"\n");
			}
			
			br.close();
			bw.close();
		}catch(Exception e) {
			
		}
	}
}