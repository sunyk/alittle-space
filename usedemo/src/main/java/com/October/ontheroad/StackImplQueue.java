/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.October.ontheroad;

import java.util.Stack;

/**
 * @author sunyang
 * @date 2018/10/25 10:18
 */
public class StackImplQueue {

    /**
     * 定义两个栈来实现队列
     * 栈A 负责插入新元素
     * 栈B 负责移除老元素
     */
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入队操作
     * @Param element
     */
    public void enQueue(int element){
        stackA.push(element);
    }

    /**
     *
     * 出队操作
     */
    public Integer deQueue(){
        if (stackB.isEmpty()){
            if (stackA.isEmpty()){
                return null;
            }
            fetchFormStackA();
        }

        return stackB.pop();
    }

    /**
     * 从stackA栈中拿到出栈元素压入栈B
     */
    private void fetchFormStackA() {
        while (!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackImplQueue stackQueue = new StackImplQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);

        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());

        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());


    }
}

