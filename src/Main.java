public class Main{
    public static void main(String[] args) {
        fu fu1=new fu();
        System.out.println(fu1.i);
        fu fu2=new fu();
        System.out.println(fu2.i);
        
    }
}
class fu{
    int i;
    private int num;
    void print(){
        System.out.println("这是父类");
    }
}
class zi extends fu{
    void print(){
        System.out.println(super.i);
    }
}