package wzs.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wangzhs
 * @since 18/11/2020
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderOpenFeignHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignHystrixMain80.class, args);
    }
}
