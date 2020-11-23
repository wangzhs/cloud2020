package com.wzs.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangzhs
 * @since 23/11/2020
 */
public class MySelfRule extends AbstractLoadBalancerRule {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private Integer next = 0;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(this.getLoadBalancer().getAllServers(), key);
    }

    private Server choose(List<Server> servers, Object key) {
        int current, next;

        do {
            // 轮询
            current = atomicInteger.get();
            next = current + 1;
        } while (!atomicInteger.compareAndSet(current, next)); // 修改成功返回true，不对继续循环

        return servers.get(next / servers.size());
    }
}
