public class MyTree{
	static class Node{
	public String val;
	public Node left;
	public Node right;	

	public Node(String val){
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

	static Node Bulid(){
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");

		A.left = B;
        B.left = D;
        B.right = E;
        E.left = G;
        A.right = C;
        C.right = F;
        return A;

	}

//递归先序
	public void prevOrder(Node root){
		if(root == null){
			return;
		}

		System.out.println(root.val);
		prevOrder(root.left);
		prevOrder(root.right);

	}
//迭代先序
	public void prevOrder(Node root){
		if(root == null){
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()){
			Node top = stack.pop();
			System.out.println(top.val);


			if(top.right != null){
				stack.push(top.right);
			}
			if(top.left != null){
				stack.push(top.left);
			}
		}
	}

	//递归中序
	public void midOrder(Node root){
		if(root == null){
			return;
		}

		midOrder(root.left);
		System.out.println(root.val);
		midOrder(root.right);
	}

	//迭代中序
	public void midOrder(Node root){
		if(root == null){
			return;
		}
		Stack<Node> stack = new Stack<>();
		Node cur = root;
		while(true){

			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}

			if(stack.empty()){
				break;
			}

			Node top = stack.pop();
			System.out.println(top.val);

			cur = top.right;
		}
	}

	//迭代后序
	public void posOrder(Node root){
		if(root == null){
			return;
		}

		Stack<Node> stack = new Stack<>();
		Node cur = root;
		Node prev = null;
		while(true){
			while(cur != null){
				stack.push(cur);
				cur = cur.left;

			}

			if(stack.empty()){
				break;
			}

			Node top = stack.peek();
			if(top.right == null || top.right == prev){
				System.out.println(top.val);
				stack.pop();
				prev = top;
			}else{
				cur = top.right;
			}
		}
	}
	//递归后序
	public void posOrder(Node root){
		if(root == null){
			return;
		}

		posOder(root.left);
		posOrder(root.right);
		System.out.pringtln(root.val);
	}

	//层序遍历
	public void leveOrder(Node root){
		if(root == null){
			return;
		}
		Queue<Node> queue = new LinkList<>();
		queue.offer(root);

		while(!queue.isEmpty()){
			Node cur = queue.poll();
			System.out.println(cur.val);
			if(cue.left != null){
				queue.offer(cur.left);
			}
			if(cue.right != null){
				queue.offer(cur.right);
			}
		}
	}

	
}