package com.hxhnzmb.example;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述: 自定义线程池
 * 公司信息: 星辰科技有限公司 研发部
 * 作者QQ：1952500855
 *
 * @author hxhxnzmb
 * @version v1.0
 * @date 2019/7/17 15:07
 */
public class CustomThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3));

        threadPoolExecutor.execute(new TaskThread("任务一"));
        threadPoolExecutor.execute(new TaskThread("任务二"));
        threadPoolExecutor.execute(new TaskThread("任务3"));
        threadPoolExecutor.execute(new TaskThread("任务4"));
        threadPoolExecutor.execute(new TaskThread("任务5"));
        //threadPoolExecutor.execute(new TaskThread("任务6"));
    }
}

class TaskThread implements Runnable {

    private String threadName;

    public TaskThread(String threadName){
        this.threadName = threadName;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + ", " + threadName);

    }
}
