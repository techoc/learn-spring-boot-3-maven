package cn.techoc.learnsatokendemo;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.techoc.learnsatokendemo.mapper")
public class LearnSaTokenDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSaTokenDemoApplication.class, args);
        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
    }

}
