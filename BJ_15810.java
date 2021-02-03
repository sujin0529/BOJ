import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 15810] 풍선 공장
// https://blog.naver.com/tnwls0529/222230245326

class Heap{
	private long[][] arr;
	private int size;
	public Heap(int size) {
		arr = new long[size+1][2];
		this.size = 0;
	}
	
	public void add(long[] value) {
		this.size++;
		int index = this.size;
		while(index != 1 && arr[index/2][0] > value[0]) {
			arr[index] = arr[index/2];
			index /= 2;
		}
		arr[index] = value;
	}
	
	public long[] delete() {
		long[] min = arr[1];
		long[] tmp = arr[this.size];
		int parent = 1;
		int child = 2;
		
		while(child < this.size) {
			if(child+1 < this.size && arr[child][0] > arr[child+1][0]) {
				child++;
			}
			if(arr[child][0] > tmp[0]) {
				break;
			}
			arr[parent] = arr[child];
			parent = child;
			child *= 2;
		}
		arr[parent] = tmp;
		this.size--;
		return min;
	}
	
	public int getSize() {
		return this.size;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] token = br.readLine().split(" ");
			int staff = Integer.parseInt(token[0]);
			int ballon = Integer.parseInt(token[1]);
			Heap stats = new Heap(staff);
			token = br.readLine().split(" ");
			for(int i=0; i<staff; i++) {
				long[] s = new long[2];
				long tmp = Long.parseLong(token[i]);
				s[0] = tmp;
				s[1] = tmp;
				stats.add(s);
			}
			int goal = 0;
			long time = 0;
			while(goal < ballon) {
				long[] min = stats.delete();
				goal++;
				time = min[0];
				min[0] += min[1];
				stats.add(min);
			}
			bw.write(time+"\n");
			br.close();
			bw.close();
			
		}catch(Exception e) {
			
		}
	}
}
