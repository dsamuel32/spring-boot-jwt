package br.com.springplayground.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
        /*BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode("123");
        System.out.println(result);*/
    }
//http://www.baeldung.com/spring-security-oauth-jwt
}
