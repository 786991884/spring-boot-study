package com.xubh.amqp.test;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xubh
 * @date 2016-07-14
 * @mondify
 * @copyright
 */
@Component
public class ReceiverService{

    @RabbitListener(queues = "queue.foo")
    public void receiveFooQueue(Foo foo) {
        System.out.println("Received Foo<" + foo.getName() + ">");
    }

    @RabbitListener(queues = "queue.bar")
    public void receiveBarQueue(Bar bar) {
        System.out.println("Received Bar<" + bar.getAge() + ">");
    }

   /* @Override
    public void onMessage(Message message) {
       System.out.println(message.getBody());
    }*/
}
