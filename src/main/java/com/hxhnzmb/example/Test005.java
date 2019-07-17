package com.hxhnzmb.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 描述: 线程池的四种创建方式之一：newScheduledThreadPool
 * 公司信息: 星辰科技有限公司 研发部
 * 作者QQ：1952500855
 *
 * @author hxhxnzmb
 * @version v1.0
 * @date 2019/7/17 14:33
 */
public class Test005 {

    public static void main(String[] args) {
        //可固定长度线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 20; i++) {
            final int tmp = i;
            scheduledExecutorService.schedule(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "," + tmp);
                }
            }, 10, TimeUnit.SECONDS);
        }
    }
}
