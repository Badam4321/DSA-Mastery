package tree;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        printInorder(root);
        System.out.println();
        printPreorder(root);
        System.out.println();
        printPostorder(root);
    }

    private static void printPostorder(TreeNode root) {
        if(root != null){
            printPreorder(root.left);
            printPostorder(root.right);
            System.out.print(root.val + " ");
        }
    }

    private static void printPreorder(TreeNode root) {
        if(root != null){
            System.out.print(root.val + " ");
            printPreorder(root.left);
            printPostorder(root.right);
        }
    }

    private static void printInorder(TreeNode root) {
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}
