

public class HamiltonPath {

    public static void main(String[] args) {
        HamiltonPath obj = new HamiltonPath();

        double[][] x = {
                {0, 23.6, 38, 17.8, 23.6, 17.6},
                {23.6, 0, 3, 24.5, 26.4, 27.9},
                {38, 3, 0, 20.7, 29.5, 26.6},
                {17.8, 24.5, 20.7, 0, 7.84, 29.3},
                {23.6, 26.4, 29.5, 7.84, 0, 25},
                {17.6, 27.9, 26.6, 29.3, 25, 0},
        };
//结点的邻接矩阵

        System.out.println("以下是所有哈密尔顿路：");
        obj.allHamiltonPath(x);

    }

    static int len;
    static int[] path;
    static int count = 0;

    public void allHamiltonPath(double[][] x) { //遍历找出所有哈密尔顿回路

        len = x.length;
        path = new int[len];
        int i = 0;
        path[0] = i + 1;
        findHamiltonpath(x, 0, i, 0);
    }


    private void findHamiltonpath(double[][] M, int x, int y, int l) {

        int i;
        for (i = x; i < len; i++) { // 遍历行

            if (M[i][y] != 0) { // 两个结点连通

                if (detect(path, i + 1))// 如果找到一个已存在路中的结点

                    continue;

                l++; // 增加路径结点数
                path[l] = i + 1; //

                if (l == len - 1) {//已全部遍历

                    double w = 0;
                    display(path);
                    for (int j = 0; j < len - 1; j++) {
                        w += M[path[j] - 1][path[j + 1] - 1];
                    }
                    System.out.println("权重为：" + w);
                    count++;
                    l--;
                    break;
                }

                //M[i][y] = M[y][i] = 0; //移除已经到达的结点
                findHamiltonpath(M, 0, i, l); // 递归寻找新的路径

                l--; // 减少路径的结点数因为没有找到新的结点
                //M[i][y] = M[y][i] = 1; // 转化回初始状态的邻接矩阵

            }
        }
        path[l + 1] = 0;
    }

    public void display(int[] x) {

        System.out.print(count + 1 + " : ");
        for (int i : x) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private boolean detect(int[] x, int target) { // 判断是否已遍历过该结点
        boolean t = false;
        for (int i : x) {
            if (i == target) {
                t = true;
                return t;
            }
        }
        return t;
    }
}
