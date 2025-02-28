package com.yishui.example.provider;

import com.yishui.example.common.model.User;
import com.yishui.example.common.service.UserService;
import com.yishui.yishuirpc.registry.LocalRegistry;
import com.yishui.yishuirpc.server.HttpServer;
import com.yishui.yishuirpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);
        System.out.print("UserService.class.getName()");
        System.out.println(UserService.class.getName());

        // 提供服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8888);
    }
}
