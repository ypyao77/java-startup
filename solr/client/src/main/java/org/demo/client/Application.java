package org.demo.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        /*
        System.setProperty("java.security.auth.login.config", "fhc.dev/jaac.conf");
        System.setProperty("java.security.krb5.conf", "fhc.dev/krb5.conf");
        System.setProperty("sun.security.krb5.debug", "true");
        */
        SpringApplication.run(Application.class, args);
    }
}
