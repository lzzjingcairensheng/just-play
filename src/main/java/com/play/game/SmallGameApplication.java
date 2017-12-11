package com.play.game;

import com.play.game.config.PersistenceConfig;
import com.play.game.service.impl.GameInfoServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Configuration
@RestController
/**
 * @SpringBootApplication 相当于 @Configuration + @EnableAutoConfiguration + @ComponentScan
 */
//@SpringBootApplication
@Import(value = {PersistenceConfig.class})
@ComponentScan(basePackages = {"com.play.game.service"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan
public class SmallGameApplication extends SpringBootServletInitializer {
    @Resource
    private GameInfoServiceImpl gameInfoService;

    public static void main(String[] args) {
        SpringApplication.run(SmallGameApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SmallGameApplication.class);
    }

    @GetMapping("/")
    String home(){
        return "hello world!";
    }

}
