package 二叉树遍历;

import java.util.Stack;

public class MyTree {
    static class Node{
        public String val;
        public Node left;
        public Node right;

        public Node(String val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static Node Build(){
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
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    //迭代先序
    public void preOrder1(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();//定义一个栈
        stack.push(root);//将根节点放进去
        while (!stack.isEmpty()){
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
    public void midOrder1(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (true){
            while (cur != null ){
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

    //递归后序
    public void posOrder(Node root){
        if(root == null){
            return;
        }

        posOrder(root.left);
        posOrder(root.right);
        System.out.println(root.val);

    }
    //迭代后序
    public void posOrder1(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;
        while (true){
            while (cur != null){
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
            }else {
                cur = cur.right;
            }
        }
    }
    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        Node A = Build();
        myTree.preOrder1(A);
    }

}
