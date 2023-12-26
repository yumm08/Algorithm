import java.io.*;
import java.util.StringTokenizer;

class Node {
	char self;
	Node left, right;

	public Node(char self) {
		this.self = self;
	}

	public Node(char self, Node left, Node right) {
		this.self = self;
		this.left = left;
		this.right = right;
	}
}

public class Main {

	static int N;
	static Node[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			if (tree[parent - 'A'] == null)
				tree[parent - 'A'] = new Node(parent);
			if (left != '.') {
				tree[left - 'A'] = new Node(left);
				tree[parent - 'A'].left = tree[left - 'A'];
			}
			if (right != '.') {
				tree[right - 'A'] = new Node(right);
				tree[parent - 'A'].right = tree[right - 'A'];
			}
		}

		preOrder(tree[0]);
		System.out.println();
		inOrder(tree[0]);
		System.out.println();
		postOrder(tree[0]);
	}

	private static void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.self);
	}

	private static void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.self);
		inOrder(node.right);
	}

	private static void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.self);
		preOrder(node.left);
		preOrder(node.right);
	}
}
