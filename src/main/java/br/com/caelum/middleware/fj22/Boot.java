package br.com.caelum.middleware.fj22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by matheusbrandino on 6/9/17.
 */
@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Boot {

    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}
