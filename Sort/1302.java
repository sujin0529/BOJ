import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// [백준 1302] 베스트셀러

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int num = Integer.parseInt(br.readLine());
			Map<String, Integer> book = new HashMap<>();
			
			for(int i=0; i<num; i++) {
				String title = br.readLine();
				if(book.containsKey(title)) {
					book.put(title, book.get(title)+1);
				}
				else {
					book.put(title, 1);
				}
			}
			
			ArrayList<String> bestSeller = new ArrayList<>();
			int max = 0;
			Iterator iter = book.keySet().iterator();
			
			while(iter.hasNext()) {
				String key = (String) iter.next();
				if(max < book.get(key)) {
					bestSeller = new ArrayList<>();
					bestSeller.add(key);
					max = book.get(key);
				}
				else if(max == book.get(key)) {
					bestSeller.add(key);
				}
			}
			Collections.sort(bestSeller);
			bw.write(bestSeller.get(0)+"\n"); // 가장 앞서는 것 하나만 출력
			
			bw.close();
			br.close();
			
		} catch(Exception e) {
			
		}
	}
}
