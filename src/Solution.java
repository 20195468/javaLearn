import java.util.*;

class ListNode {
    ListNode next;
    int val;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class Solution {
    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(4);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(4);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = null;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = null;
//        addTwoNumbers(listNode1, listNode4);
//        int[] arr1 = {4, 9, 5};
//        int[] arr2 = {9, 4, 9, 8, 4};
//        int[] num = intersection(arr1, arr2);
//        for (int i : num) {
//            System.out.println(i);
//        }
//        int[] arr1 = {1, 7, 9, 5, 4, 1, 2};
//        validMountainArray(arr1);
    }

    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        if (recur(A, B)) return true;
        if (isSubStructure(A.left, B)) return true;
        return isSubStructure(A.right, B);
    }

    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int choose = 1;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (choose % 2 == 0) Collections.reverse(temp);
            choose++;
            list.add(temp);
        }
        return list;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;


//        if (root == null || root == q || root == p) return root;
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left == null && right == null) return null;
//        if (left == null) return right;
//        if (right == null) return left;
//        return root;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }


    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;

//        if (root == null) return 0;
//        List<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        List<TreeNode> temp = null;
//        int length = 0;
//        while (!queue.isEmpty()) {
//            temp = new LinkedList<>();
//            for (TreeNode node : queue) {
//                if (node.left != null) temp.add(node.left);
//                if (node.right != null) temp.add(node.right);
//            }
//            queue = temp;
//            length++;
//        }
//        return length;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetry(root.left, root.right);
    }

    public boolean isSymmetry(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isSymmetry(left.right, right.left) && isSymmetry(left.left, right.right);
    }


    public int[] sortArrayByParityII(int[] A) {
        int[] arr = new int[A.length];
        int num = 0, count = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                arr[num] = A[i];
                num = num + 2;
            } else {
                arr[count] = A[i];
                count = count + 2;
            }
        }
        return arr;
    }

    public static boolean validMountainArray(int[] A) {
        int max = 0;
        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                size = i;
            }
        }
        if (size == 0 || size == A.length - 1) return false;
        for (int i = 0; i < size; i++) {
            if (A[i] >= max) return false;
            if (A[i] >= A[i + 1]) return false;
        }
        for (int i = size + 1; i < A.length; i++) {
            if (A[i] >= max) return false;
            if (i < A.length - 1 && A[i + 1] >= A[i]) return false;
        }
        return true;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length > nums2.length) {
            return collection(nums2, nums1);
        } else {
            return collection(nums1, nums2);
        }
    }

    public static int[] collection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (Arrays.binarySearch(nums2, nums1[i]) >= 0) {
                set.add(nums1[i]);
            }
        }
        int[] aimNums = new int[set.size()];
        int num = 0;
        for (int i : set) {
            aimNums[num++] = i;
        }
        return aimNums;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            int addNumber = l1.val + l2.val + carry;
            carry = addNumber / 10;
            ListNode node = new ListNode(addNumber % 10);
            temp.next = node;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
//        if (l1 != null) {
//            l1.val = l1.val + carry;
//            temp.next = l1;
//            carry = 0;
//        }
        while (l1 != null) {
            int addNumber = l1.val + carry;
            carry = addNumber / 10;
            ListNode node = new ListNode(carry % 10);
            temp.next = node;
            temp = temp.next;
            l1 = l1.next;
        }
//        if (l2 != null) {
//            l2.val = l2.val + carry;
//            temp.next = l2;
//            carry = 0;
//        }
        while (l2 != null) {
            int addNumber = l2.val + carry;
            carry = addNumber / 10;
            ListNode node = new ListNode(carry % 10);
            temp.next = node;
            temp = temp.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            temp.next = node;
        }
        return head.next;
    }

    public static int islandPerimeter(int[][] grid) {
        int land = 0;
        int border = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) border++;
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) border++;
                    land++;
                }
            }
        }
        return 4 * land - 2 * border;
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum) {
        if (root == null) return 0;
        int sum = preSum * 10 + root.val;
        //不存在子节点时返回总和
        if (root.left == null && root.right == null) return sum;
        else return dfs(root.left, sum) + dfs(root.right, sum);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //快慢指针法找中间结点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //找到中间结点的下一个结点
        ListNode temp = slow.next;
        //从中间结点断开
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode(0);
        ListNode tempOfHead = h;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        if (left != null) h.next = left;
        else h.next = right;
        return tempOfHead.next;
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        ListNode current = root;
        while (current != null) {
            current = current.next;
            size++;
        }
        int width = size / k;
        int rem = size % k;
        ListNode[] listNodes = new ListNode[k];
        current = root;
        for (int i = 0; i < k; i++) {
            //记录分割后的头结点
            ListNode head = current;
            //找到分割后每个链表的最后一个结点
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; j++) {
                if (current != null) current = current.next;
            }
            if (current != null) {
                //记录当前节点
                ListNode previous = current;
                current = current.next;
                //断开分割后链表的联系
                previous.next = null;
            }
            listNodes[i] = head;
        }
        return null;
    }

    public static int numComponents(ListNode head, int[] G) {
        ListNode current = head;
        Set<Integer> set = new HashSet<>();
        int number = 0;
        for (int i : G) set.add(i);
        while (current != null) {
            if (set.contains(current.val) && (current.next == null || !set.contains(current.next.val))) number++;
            current = current.next;
        }
        return number;
    }
}

class MyLinkedList {
    int size;
    ListNode head;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode current = head;
        for (int i = 0; i < index + 1; i++) {
            current = current.next;
        }
        return current.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        ListNode current = head;
        if (index > size) return;
        if (index < 0) index = 0;
        size++;
        for (int i = 0; i < index; i++) current = current.next;
        ListNode add = new ListNode(val);
        add.next = current.next;
        current.next = add;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        ListNode previous = head;
        for (int i = 0; i < index; i++) previous = previous.next;
        previous.next = previous.next.next;
    }
}