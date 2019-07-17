package com.hxhnzmb.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述: 使用 BlockingQueue 模拟生产者和消费者模型
 * 公司信息: 星辰科技有限公司 研发部
 * 作者QQ：1952500855
 *
 * @author hxhxnzmb
 * @version v1.0
 * @date 2019/7/15 17:24
 */
public class Test002 {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(10);
        ProducerThread producerThread = new ProducerThread(blockingQueue);
        ConsumerThread consumerThread = new ConsumerThread(blockingQueue);
        Thread p1 = new Thread(producerThread);
        p1.start();
        Thread c1 = new Thread(consumerThread);
        c1.start();

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producerThread.stop();
    }
}

/**
 * 生产者 添加队列
 */
class ProducerThread implements Runnable {

    public BlockingQueue<String> blockingQueue;
    public volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public ProducerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        System.out.println("###生产者线程已经启动###");
        try {
            while (flag) {
                String data = atomicInteger.incrementAndGet() + " ";
                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (!offer) {
                    System.out.println("生产者存入队列失败！！data：" + data);
                } else {
                    System.out.println("生产者存入队列成功！！data：" + data);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("###生产者线程已经结束###");
        }
    }

    public void stop() {
        this.flag = false;
    }
}

/**
 * 消费者队列 获取队列
 */
class ConsumerThread implements Runnable{
    public BlockingQueue<String> blockingQueue;
    public volatile boolean FLAG = true;
    AtomicInteger atomicInteger = new AtomicInteger();

    public ConsumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        System.out.println("###消费者线程已经启动###");

        try {
            while (FLAG) {
                String data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (data==null){
                    System.out.println("超过2秒时间，没有获取队列信息");
                    FLAG = false;
                    return;
                }
                System.out.println("消费者获取到 data:" + data);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("###消费者线程已经停止###");
        }

    }
}