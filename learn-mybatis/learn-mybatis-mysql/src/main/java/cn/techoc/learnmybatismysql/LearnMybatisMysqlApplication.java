package cn.techoc.learnmybatismysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.techoc.learnmybatismysql.mapper")
public class LearnMybatisMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnMybatisMysqlApplication.class, args);
    }

}
