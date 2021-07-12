import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// [백준 1431] 시리얼 번호

class GuitarSort implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		// return value > 0 : 자리바꿈
		if(arg0.length() > arg1.length()) {
			// 길이가 짧을 때는 짧은 순서대로
			return 1;
		}
		else if(arg0.length() < arg1.length()) {
			return -1;
		}
		else {
			int value1 = 0;
			int value2 = 0;
			for(int i=0; i<arg0.length(); i++) {
				char tmp1 = arg0.charAt(i);
				char tmp2 = arg1.charAt(i);
				if('0' <= tmp1 && tmp1 <= '9') {
					value1 += Integer.parseInt(tmp1+"");
				}
				if('0' <= tmp2 && tmp2 <= '9') {
					value2 += Integer.parseInt(tmp2+"");
				}
			}
			if(value1 > value2) {
				return 1;
			}
			else if(value1 < value2) {
				return -1;
			}
			else {
				// 사전순으로 정렬해야 함
				// string1 > string2 이면 양수
				return arg0.compareTo(arg1);
			}
		}
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int guitarNum = Integer.parseInt(br.readLine());
			List<String> guitar = new ArrayList<>();
			for(int i=0; i<guitarNum; i++) {
				guitar.add(br.readLine());
			}
			
			Collections.sort(guitar, new GuitarSort());
			
			for(int i=0; i<guitarNum; i++) {
				bw.write(guitar.get(i)+"\n");
			}
			bw.close();
			br.close();
			
		}catch(Exception e) {
			
		}
	}
}
