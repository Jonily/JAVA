package 二叉树遍历;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    //定义节点类
    static class Node {
        char val; //数据域
        public Node left;  // 左孩子的引用，常常代表左孩子为根的整棵左子树
        public Node right;  // 右孩子的引用，常常代表右孩子为根的整棵右子树

        public Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }
    static Node build(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        B.left = D;
        B.right = E;
        E.left = G;
        A.right = C;
        C.right = F;
        return A;
    }
    //递归
    public static void preOrder(Node root){
        //先访问根节点,先递归访问左子树再递归访问右子树
        //如果是空树，不进行操作
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    //迭代
    public static void preOrder1(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node top = stack.pop();
            System.out.print(top.val+" ");
            if(top.right != null){
                stack.push(top.right);
            }
            if(top.left != null){
                stack.push(top.left);
            }
        }
    }
    //递归
    public static void inOrder(Node root){
        //先递归访问左子树,再访问根节点,再递归访问右子树
        //如果是空树，不进行操作
        if(root == null){
            return;
        }
        //访问根的左节点
        inOrder(root.left);
        //访问根节点
        System.out.print(root.val+" ");
        //访问根的右节点
        inOrder(root.right);
    }
    //迭代
    public static void inOrder1(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (true){
            while (cur != null){
                //1、cur一直往左走循环入栈直到cur为空
                stack.push(cur);
                cur = cur.left;
            }
            //2、取栈顶元素访问，如果空栈访问结束
            if(stack.empty()){
                break;
            }
            Node top = stack.pop();
            System.out.print(top.val+" ");
            //3、cur从top右子树出发重复之前步骤
            cur = top.right;
        }
    }
    //递归
    public static void posOrder(Node root){
        //先递归访问左子树,再递归访问右子树,最后访问根节点
        //如果是空树，不进行操作
        if(root == null){
            return;
        }
        //访问根的左节点
        posOrder(root.left);
        //访问根的右节点
        posOrder(root.right);
        //访问根节点
        System.out.print(root.val+" ");
    }
    //迭代
    public static void posOrder1(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node prev = null;//用来记录上个被访问过的节点
        while (true){
            //1、cur一直往左走循环入栈直到cur为空
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //2、取栈顶元素，判断是否能访问

            if(stack.empty()){
                //遍历结束
                break;
            }

            Node top = stack.peek();//取栈顶元素进行判断并没有出栈，只有节点被访问过才会出栈
            //满足下面两个条件可以访问
            //a）如果栈顶元素右子树为null，则可以访问
            //b）栈顶元素已经被访问过了，则可以访问
            if(top.right == null || top.right == prev){
                //可以访问top
                System.out.print(top.val+" ");
                stack.pop();//出栈
                prev = top;//将上一个被访问过的元素放入prev
            }else {
                //3、cur从top右子树出发重复之前步骤
                cur = top.right;
            }
        }
    }
    public static void leveOrder(Node root){
        //如果是空树，不进行操作
        if(root == null){
            return;
        }
        //创建一个队列,初始情况把根节点加入到队列
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        //2、进入循环，当队列为空时结束循环
        while (!queue.isEmpty()){
            //取出队首元素
            Node cur = queue.poll();
            //访问当前元素
            System.out.print(cur.val+" ");
            //把当前节点左右子树放入队列
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = build();
        System.out.println("先序遍历：");
        System.out.print("递归：");
        preOrder(root);
        System.out.print("迭代：");
        preOrder1(root);
        System.out.println();
        System.out.println("中序遍历：");
        System.out.print("递归：");
        inOrder(root);
        System.out.print("迭代：");
        inOrder1(root);
        System.out.println();
        System.out.println("后序遍历：");
        System.out.print("递归：");
        posOrder(root);
        System.out.print("迭代：");
        posOrder1(root);
        System.out.println();
        System.out.println("层序遍历：");
        leveOrder(root);
    }
}
