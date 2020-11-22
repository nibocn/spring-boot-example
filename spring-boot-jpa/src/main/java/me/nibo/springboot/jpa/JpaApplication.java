package me.nibo.springboot.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 程序入口类
 *
 * @author NiBo
 */
@SpringBootApplication
@SuppressWarnings({ "PMD.UseUtilityClass" })
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
}
