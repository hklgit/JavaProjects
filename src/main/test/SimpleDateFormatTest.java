/**
 * Created by Kerven on 2019/6/20.
 * <p>
 * 　　　　　　　   ┏┓　   ┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ +
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * Don't bibi , show me the code
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


public class SimpleDateFormatTest {

    public static void main(String[] args) {

        for (int i = 0; i < 20 ; i++) {
            new Thread(new SdfThread("2019-06-13")).start();
        }


    }

}


class SdfThread extends Thread{

   /* // 如果这里是static的话，那么这个sdf就是所有对象共享的，因为他只会在加载类的时候初始化一次
    private  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-hh");*/

   //如果去掉static就不存在这个问题了，就会在每个县城里创建一个
    private   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-hh");


    private String dateStr;

    public SdfThread(String dateStr){
       this.dateStr = dateStr;
        System.out.println(" be created ");
    }




    @Override
    public void run() {

        try {
            Date date = sdf.parse(dateStr);
            System.out.println(Thread.currentThread().getName()+" the date is " + date);
            TimeUnit.SECONDS.sleep(4);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}