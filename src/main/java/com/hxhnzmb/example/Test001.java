package com.hxhnzmb.example;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 描述:
 * 公司信息: 星辰科技有限公司 研发部
 * 作者QQ：1952500855
 *
 * @author hxhxnzmb
 * @version v1.0
 * @date 2019/7/15 16:58
 */
public class Test001 {

    /**
     * 阻塞式队列最大的好处是能够防止队列容器溢出，防止丢失数据
     * @param args
     */
    public static void main(String[] args) {

        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();
        concurrentLinkedQueue.offer("哈哈");
        concurrentLinkedQueue.offer("百度");
        concurrentLinkedQueue.offer("瓜皮");
        //获取队列: 只能获取一个队列元素
        //获取并删除该元素
        System.out.println(concurrentLinkedQueue.poll());
        //只获取该元素
        System.out.println(concurrentLinkedQueue.peek());
        //获取队列个数
        System.out.println(concurrentLinkedQueue.size());
    }
}
