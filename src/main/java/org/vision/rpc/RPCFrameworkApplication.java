package org.vision.rpc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhiyong.lt
 */
@SpringBootApplication
public class RPCFrameworkApplication implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }

    public static void main(String[] args) {
        SpringApplication.run(RPCFrameworkApplication.class, args);
    }
}
