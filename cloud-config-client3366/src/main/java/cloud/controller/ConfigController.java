package cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangzhs
 * @since 25/11/2020
 */
@RestController
@RefreshScope /*刷新需要 curl -XPOST "http://config-3355.com:3355/actuator/refresh"*/
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/get/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}
