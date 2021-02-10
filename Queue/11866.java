import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [백준 11866] 요세푸스 문제 0
// https://blog.naver.com/tnwls0529/221847138920

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int number = sc.nextInt();
		int del = sc.nextInt(); // 제거할 순서의 번호
		
		for(int i=1; i<=number; i++) {
			queue.add(i);
		}
		
		System.out.print("<");
		while(queue.size()>1) {
			for(int i=0; i<del-1; i++) {
				int push = queue.remove();
				queue.add(push);
			}
			System.out.print(queue.remove()+", ");
		}
		System.out.println(queue.remove()+">");

	}

}
