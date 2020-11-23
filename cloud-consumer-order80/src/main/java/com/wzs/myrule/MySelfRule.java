package com.wzs.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangzhs
 * @since 23/11/2020
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        return new WeightedResponseTimeRule();
    }
}
