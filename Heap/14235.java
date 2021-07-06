import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 14235] 크리스마스 선물

class Heap{
	private int size;
	private int[] arr;
	
	public Heap(int size) {
		arr = new int[size+1];
		this.size = 0;
	}
	
	public void add(int value) {
		this.size++;
		int index = this.size;
		
		while(index != 1 && compareTo(this.arr[index/2], value) < 0) {
			this.arr[index] = this.arr[index/2];
			index /= 2;
		}
		this.arr[index] = value;
	}
	
	public int top() {
		return this.arr[1];
	}
	
	public int delete() {
		if(this.size == 0) {
			return -1;
		}
		
		int max = this.arr[1];
		int tmp = this.arr[this.size];
		int parent = 1;
		int child = 2;
		
		while(child < this.size) {
			if(child+1 < this.size && compareTo(this.arr[child], this.arr[child+1])<0) {
				child++;
			}
			if(compareTo(this.arr[child], tmp) < 0) {
				break;
			}
			this.arr[parent] = this.arr[child];
			parent = child;
			child *= 2;
		}
		this.arr[parent] = tmp;
		this.size--;
		
		return max;
	}
	
	public int compareTo(int first, int second) {
		// first가 클 때 1반환
		if(first > second) {
			return 1;
		}
		else if(first < second) {
			return -1;
		}
		return 0;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		
		try {
			int visitNum = Integer.parseInt(br.readLine());
			Heap present = new Heap(visitNum*100);
			
			for(int i=0; i<visitNum; i++) {
				String[] token = br.readLine().split(" ");
				if(token[0].equals("0")) {
					// 만약 아이들을 만났다면
					int max = present.delete();
					result.append(max+"\n");
				}
				else {
					int presentNum = Integer.parseInt(token[0]);
					for(int index=1; index<=presentNum; index++) {
						int presentValue = Integer.parseInt(token[index]);
						present.add(presentValue);
					}
				}
			}
			bw.write(result+"");
			bw.close();
			br.close();
		}catch(Exception e) {
			
		}
	}
}

