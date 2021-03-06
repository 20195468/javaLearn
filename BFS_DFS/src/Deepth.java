import java.util.*;

/**
 * @program: OJhomework
 * @description 深度优先搜索
 * @author: 李星泽
 * @create: 2020-08-17 08:44
 **/
public class Deepth {
    //深度优先搜索是一种不撞南墙不回头的搜索方法，他会把一条路走完之后再回溯到有分叉的节点继续遍历
    //深度优先搜索采用栈的方式进行，而广度优先搜索采用队列的方式进行
    //广度优先搜索是层层的进行访问，而深度优先搜索是纵向进行
    //创建二叉树
    public static void main(String[] args) {
        //创建二叉树
        TreeNode treeNode = new TreeNode("A");
        TreeNode firstLeft = new TreeNode("B");
        treeNode.left = firstLeft;
        TreeNode firstRight = new TreeNode("C");
        treeNode.right = firstRight;
        firstLeft.left = new TreeNode("D");
        firstLeft.right = new TreeNode("E");
        System.out.println("Preorder Traversal");
        PreorderTraversal(treeNode);
        System.out.println("\nInorder Traversal");
        InorderTraversal(treeNode);

    }

    public static void PreorderTraversal(TreeNode treeNode) {
        //存放结点的值
        List<String> list = new ArrayList<>();
        //栈存放结点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        //栈空时结束 这里的深度优先搜索实现的是先序遍历
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            /*
            先将右结点推入栈中再将左结点推入栈中
            先推右结点再推左节点的原因是为了记录路径
             */
            if (tree.right != null) {
                stack.push(tree.right);
            }
            if (tree.left != null) {
                stack.push(tree.left);
            }
            list.add(tree.val);
        }
        for (String s : list) {
            System.out.print(s + " ");
        }
    }

    public static void InorderTraversal(TreeNode root) {
        //存放结点
        Stack<TreeNode> stack = new Stack<>();
        //存放结点的值
        ArrayList<String> strings = new ArrayList<>();
        TreeNode temp = null;
        if (root != null) {
            temp = root;
            while (!stack.isEmpty() || temp != null) {
                //一直找到最左方不存在左孩子的结点
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
                if (!stack.isEmpty()) {
                    temp = stack.pop();
                    strings.add(temp.val);
                    temp = temp.right;
                }
            }
        }
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}


