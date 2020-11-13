package com.lagou.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Administrator
 */

@Configuration
@ComponentScan("com.lagou")
@EnableAspectJAutoProxy // 开启AOP 自动代理
public class SpringConfig {
}
