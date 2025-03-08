package com.yishui.example.consumer;

import com.yishui.example.common.model.User;
import com.yishui.example.common.service.UserService;
import com.yishui.yishuirpc.bootstrap.ConsumerBootstrap;
import com.yishui.yishuirpc.config.RpcConfig;
import com.yishui.yishuirpc.proxy.ServiceProxyFactory;
import com.yishui.yishuirpc.utils.ConfigUtils;


/**
 * 简易服务消费者示例
 *

 */
public class ConsumerExample {

    public static void main(String[] args) {
        // 服务提供者初始化
        ConsumerBootstrap.init();

        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("yishui");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
