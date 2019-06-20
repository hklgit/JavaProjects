package com.hklbigdata.多线程;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
 * <p>
 * 实际的使用一下线程池来感受下
 * 不错的链接：
 * https://www.cnblogs.com/dolphin0520/p/3932921.html
 *
 * 我这里有个话题讨论：
 * 我们到底设置多少thread数据合适？
 *
 * 文章的末尾处说道如何的去创建线程池：不过在java doc中，并不提倡我们直接使用ThreadPoolExecutor，而是使用Executors类中提供的几个静态方法来创建线程池
 * 这个和阿里的开发手册里说的真好使相反的，元芳你怎么看？
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {

        //LinkedBlockingQueue这个队列如果不指定的话默认值就是Integer.MAX_VALUE，这个值如果说设置的太小但是我们的任务数量有比较多的时候就会使用我们的拒绝策略了
        // 我吧capacity调整为10 的时候，抛出异常
        //java.util.concurrent.RejectedExecutionException: Task com.hklbigdata.多线程.MyTask@73c6c3b2 rejected from java.util.concurrent.ThreadPoolExecutor@48533e64[Running, pool size = 10, active threads = 10, queued tasks = 20, completed tasks = 0]


        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(20));

        for (int i = 0; i < 100; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("the num of the thread in the pool is :" + executor.getPoolSize() +  ", the num of the tasks waiting for in the queue is " + executor.getQueue().size() + " ,the num of the finished tasks is " + executor.getCompletedTaskCount());
        }
        executor.shutdown();

    }

}

//our task must implements runnable because executor.execute(Runnable)
class MyTask implements Runnable {

    // the number of the task
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("the number of the task running now =>" + taskNum);

        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("taks=>" + taskNum + "finished");

    }
}
