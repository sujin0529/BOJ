import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [백준 1991] 트리 순회

class Node{
	String root;
	Node left;
	Node right;
	
	public Node(String root) {
		this.root = root;
		this.left = null;
		this.right = null;
	}
}

class Tree{
	Node root;
	
	void createTree(String root, String leftData, String rightData) {
		if(this.root == null) {
			this.root = new Node(root);
			
			if(!leftData.equals(".")) {
				this.root.left = new Node(leftData);
			}
			if(!rightData.equals(".")) {
				this.root.right = new Node(rightData);
			}
		}
		else {
			findParent(this.root, root, leftData, rightData);
		}
	}
	
	void findParent(Node tree, String root, String leftData, String rightData) {
		if(tree == null) {
			return;
		}
		else if(tree.root.equals(root)) {
			if(!leftData.equals(".")) {
				tree.left = new Node(leftData);
			}
			if(!rightData.equals(".")) {
				tree.right = new Node(rightData);
			}
		}
		else {
			findParent(tree.left, root, leftData, rightData);
			findParent(tree.right, root, leftData, rightData);
		}
	}
	
	String preOrder(Node tree) {
		// 전위 순회
		String result = "";
		if(tree != null) {
			result += tree.root;
			if(tree.left != null) {
				result += preOrder(tree.left);
			}
			if(tree.right != null) {
				result += preOrder(tree.right);
			}
		}
		return result;
	}
	
	String inOrder(Node tree) {
		// 중위 순회
		String result = "";
		if(tree != null) {
			if(tree.left != null) {
				result += inOrder(tree.left);
			}
			result += tree.root;
			if(tree.right != null) {
				result += inOrder(tree.right); 
			}
		}
		return result;
	}
	
	String postOrder(Node tree) {
		// 후위 순회
		String result = "";
		if(tree != null) {
			if(tree.left != null) {
				result += postOrder(tree.left);
			}
			if(tree.right != null) {
				result += postOrder(tree.right); 
			}
			result += tree.root;
		}
		return result;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int size = Integer.parseInt(br.readLine());
			Tree tree = new Tree();
			for(int i=0; i<size; i++) {
				String[] token = br.readLine().split(" ");
				tree.createTree(token[0], token[1], token[2]);
			}
			bw.write(tree.preOrder(tree.root)+"\n");
			bw.write(tree.inOrder(tree.root)+"\n");
			bw.write(tree.postOrder(tree.root)+"\n");
			bw.close();
			br.close();	
		} catch(Exception e) {
			
		}
	}
}
