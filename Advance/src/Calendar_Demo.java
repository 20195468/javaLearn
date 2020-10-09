import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @program: OJhomework
 * @description 日期类的使用
 * @author: 李星泽
 * @create: 2020-07-05 08:55
 **/
public class Calendar_Demo {
    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.LONG_FORMAT)+1);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");//汉字会转化输出但是字母会转化成数字
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}
