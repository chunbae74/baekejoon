import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 참고 : https://readerr.tistory.com/35
 * https://dy-coding.tistory.com/entry/%EB%B0%B1%EC%A4%80-1991%EB%B2%88-%ED%8A%B8%EB%A6%AC-%EC%88%9C%ED%9A%8C-java
 */
class Node_1991 {
	char data;
	Node_1991 left;
	Node_1991 right;
	
	Node_1991(char data) {
		this.data = data;
	}
}

/*
 * 전위 순회(pre-order) : 루트 노드를 먼저 순회한 이후, '왼쪽 하위 -> 오른쪽 하위' 순으로 순회하는 방법
 * 중위 순회(in-order) : 왼쪽 가장 하위 노드를 먼저 순회한 이후, '바로 상위 노드 -> 오른쪽 하위' 순으로 순회하는 방법.
 * 후위 순회(post-order) : 왼쪽 가장 하위 노드를 먼저 순회한 이후, '오른쪽 하위 노드 -> 바로 상위 노드' 순으로 순회하는 방법
 */
class Tree_1991 {
	Node_1991 root = new Node_1991('A');
	
	void createNode(char mid, char left, char right) {
		// 루트 노드라면 (mid가 A라면)
		if (root.data == mid) {
			root.left = (left == '.') ? null : new Node_1991(left);
			root.right = (right == '.') ? null : new Node_1991(right);
		}
		else {
			findNode(root, mid, left, right);
		}
	}
	
	void findNode(Node_1991 node, char mid, char left, char right) {
		// 노드 값이 없으면 재귀 탈출
		if (node == null) return;
		
		// 찾는 노드 값이라면
		else if (node.data == mid) {
			node.left = (left == '.') ? null : new Node_1991(left);
			node.right = (right == '.') ? null : new Node_1991(right);				
		}

		findNode(node.left, mid, left, right);
		findNode(node.right, mid, left, right);
	}
	
	void preOrder(Node_1991 node) {
		// 노드 값이 없으면 재귀 탈출
		if (node == null) return;
		System.out.print(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	void inOrder(Node_1991 node) {
		// 노드 값이 없으면 재귀 탈출
		if (node == null) return;
		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
	}
	
	void postOrder(Node_1991 node) {
		// 노드 값이 없으면 재귀 탈출
		if (node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data);
	}
}

public class _1991 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Tree_1991 tree = new Tree_1991();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char mid = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			tree.createNode(mid, left, right);
		}
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}
	
}
