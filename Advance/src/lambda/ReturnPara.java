package lambda;

/**
 * @program: OJhomework
 * @description
 * @author: 李星泽
 * @create: 2021-01-17 17:56
 **/

//声明可以使用Lambda表达式
@FunctionalInterface
public interface ReturnPara {
    int showMessage(int age);
    default int sub(int a,int b){
        return 0;
    }
}
