import java.io.PrintWriter;

/**
 * class for making binary trees, uses nodes with left and right pointers
 * @param <T>
 */
class BinaryTreeManager<T extends Comparable>{
    protected TreeNode<T> root;
    protected int number;
    public BinaryTreeManager(){
        root = null;
        int number = 0;
    }
    //returns number of nodes in the tree
    public int getnumber(){return number;}
    //internal class for creating tree nodes with left and right pointers
    private static class TreeNode<T extends Comparable>{
        protected T nodevalue;
        protected TreeNode<T> left;
        protected TreeNode<T> right;
        //constructor for private class
        public TreeNode(T x){
            nodevalue = x;
            left = null;
            right = null;
        }
    }
    // for creating nodes
    protected TreeNode<T> CreateNode(T x){
        return new TreeNode(x);
    }
    // function for inserting nodes into the binary tree
    public int insertnode(T x){
        // if root is null, create the root
        if(root==null){
            root = CreateNode(x);
            number = 1;
            return number;
        } //end of if
        else{
            TreeNode<T> parent = null;
            TreeNode<T> current = root;
            while(current!=null) {
                if (x.compareTo(current.nodevalue) < 0) {
                    parent = current;
                    current = current.left;
                } else if (x.compareTo(current.nodevalue) > 0) {
                    parent = current;
                    current = current.right;
                } else return -99;
            } //end of while
            if(x.compareTo(parent.nodevalue)<0)
                parent.left = CreateNode(x);
            else
                parent.right = CreateNode(x);
        } //end of else after if root null
        number++;
        return number;
    } //end of insertnode
    //printing for inorder scanning
    public void inorder(PrintWriter outp){
        inorder(root,outp);
    }
    //traverses the tree inorder when called and prints
    protected void inorder(TreeNode<T> root, PrintWriter outp){
        if (root==null) return;
        inorder(root.left,outp);
        System.out.println(root.nodevalue);
        outp.println(root.nodevalue);
        inorder(root.right,outp);
    }
    //printing for preorder scanning
    public void preorder(PrintWriter outp){
        preorder(root,outp);
    }
    //traverses the tree preorder when called and prints
    protected void preorder(TreeNode<T> root, PrintWriter outp){
        if (root==null) return;
        System.out.println(root.nodevalue);
        outp.println(root.nodevalue);
        preorder(root.left,outp);
        preorder(root.right,outp);
    }
    //printing for postorder scanning
    public void postorder(PrintWriter outp){
        postorder(root,outp);
    }
    //traverses the tree postorder when called and prints
    protected void postorder(TreeNode<T> root, PrintWriter outp){
        if (root==null) return;
        postorder(root.left,outp);
        postorder(root.right,outp);
        System.out.println(root.nodevalue);
        outp.println(root.nodevalue);
    }
}