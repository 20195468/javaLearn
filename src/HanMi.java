import java.nio.file.Path;
import java.util.Scanner;

public class HanMi {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        char [] Aim={'A','B','C','D','E','F'};//存储节点
        double[][] road={ { 0, 1.1, 3.8, 4.6, 5.3, 4.1 }, { 1.1, 0, 3.4, 5.1, 4.1, 4.8 },
                { 3.8, 3.4, 0, 1.6, 3.3, 1.1 }, { 4.6, 5.1, 1.6, 0, 2.8, 0.49 }, { 5.3, 4.1, 3.3, 2.8, 0, 0.79 },
                { 4.1, 4.8, 1.1, 0.49, 0.79, 0 }  };//存储节点间路径关系
        int length=Aim.length;
        int [] isAvailable= new int[length];//判断节点是否已经走过，是：1，否：0
        System.out.println("请输入你想开始的起点");
        int Startchoice=in.nextInt();
        String Passpath=""+Aim[Startchoice];//设置起始路径
        isAvailable[Startchoice]=1;//将开始节点设置为已走
        Passpath=Path(Aim,isAvailable,Startchoice,length,Passpath);
        System.out.println(Passpath);


    }
    private static String Path(char[] Aim,int[] isAvailable,int choice,int length,String Passpath){
        for(int i=0;i<length;i++){
            if(isAvailable[i]!=1){
                Passpath=Passpath+"-->"+Aim[i];//所经过的路径
                isAvailable[i]=1;//将已走过的节点设置为已走
                choice=i;//重新设置开始节点
                Passpath=Path(Aim,isAvailable,choice,length,Passpath);
            }
        }
        return Passpath;
    }
}
