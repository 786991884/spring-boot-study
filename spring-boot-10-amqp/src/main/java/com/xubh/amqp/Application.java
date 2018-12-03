package com.xubh.amqp;

import com.xubh.amqp.test.Bar;
import com.xubh.amqp.test.Foo;
import com.xubh.amqp.test.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Random;
import java.util.UUID;

/**
 * @author xubh
 * @date 2016-07-14
 * @mondify
 * @copyright
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.xubh.amqp")
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        // SpringApplication application = new SpringApplication(Application.class);
        // application.setWebEnvironment(false);
        //application.run(args);
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    SenderService senderService;

    @Override
    public void run(String... strings) throws Exception {
        Random random = new Random();
        while (true) {
            senderService.sendBar2Rabbitmq(new Bar(random.nextInt()));
            senderService.sendFoo2Rabbitmq(new Foo(UUID.randomUUID().toString()));
        }
    }
}