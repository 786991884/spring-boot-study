package com.xubh.amqp.test2;

import java.util.concurrent.CountDownLatch;

/**
 * @author xubh
 * @date 2016-07-14
 * @mondify
 * @copyright
 */
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}