package org.wangjin.vvserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.wangjin.vvserver.mapper")
public class VvServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VvServerApplication.class, args);
    }

}
