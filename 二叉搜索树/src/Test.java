public class Test {
    private static void preOrder(BinarySearTree.Node root){
        if(root == null){
            return;
        }
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private static void inOrder(BinarySearTree.Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinarySearTree tree = new BinarySearTree();
        int[] array = {1,9,5,2,7,4,6,8};
        for (int i: array) {
            tree.insert(i,32);
        }
        preOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        System.out.println();
        System.out.println(tree.find(5));
        System.out.println(tree.find(778));
        preOrder(tree.root);
        System.out.println();
        inOrder(tree.root);
        tree.remove(5);
        System.out.println();
        inOrder(tree.root);
        tree.remove(9);
        System.out.println();
        inOrder(tree.root);
        tree.remove(8);
        System.out.println();
        preOrder(tree.root);
        System.out.println();
        inOrder(tree.root);

    }
}
