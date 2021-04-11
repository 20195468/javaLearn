/**
 * @program: OJhomework
 * @description
 * @author: 李星泽
 * @create: 2021-01-31 08:43
 **/
public class HelloWord {
    public static void main(String[] args) {
        HelloWord helloWord = new HelloWord();
        System.out.println(helloWord.getMaxNumber(20, 30));
    }

    int age = 1;
    public boolean sex = false;
    private double weight = 0.0;

    public void eat() {
        return;
    }

    int run() {
        return 10;
    }

    protected int getMaxNumber(int number1, int number2) {
        return Math.max(number1, number2);
    }
}

