import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: OJhomework
 * @description 广度优先算法
 * @author: 李星泽
 * @create: 2020-08-16 20:40
 **/
public class Breadth {
    /*
    其过程检验来说是对每一层节点依次访问，访问完一层进入下一层，而且每个节点只能访问一次。
    广度优先遍历树，需要用到队列（Queue）来存储节点对象,队列的特点就是先进先出。
     */
    public static void main(String[] args) {
        //创建二叉树
        TreeNode treeNode = new TreeNode("A");
        TreeNode firstLeft = new TreeNode("B");
        treeNode.left = firstLeft;
        TreeNode firstRight = new TreeNode("C");
        treeNode.right = firstRight;
        firstLeft.left = new TreeNode("D");
        firstLeft.right = new TreeNode("E");
        //存放结点对应的值
        ArrayList<String> arrayList = new ArrayList<>();
        //将投结点放入队列中
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(treeNode);
        //遍历结点
        while (!treeNodeQueue.isEmpty()) {
            TreeNode tree = treeNodeQueue.poll();
            if (tree.left != null) {
                treeNodeQueue.offer(tree.left);
            }
            if (tree.right != null) {
                treeNodeQueue.offer(tree.right);
            }
            arrayList.add(tree.val);
        }
        for (String s : arrayList) {
            System.out.print(s+" ");
        }
    }
}

class TreeNode {
    String val;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(String val) {
        this.val = val;
    }
}
