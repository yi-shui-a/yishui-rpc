package com.yishui.example.provider;

import com.yishui.example.common.service.UserService;
import com.yishui.yishuirpc.RpcApplication;
import com.yishui.yishuirpc.config.RegistryConfig;
import com.yishui.yishuirpc.config.RpcConfig;
import com.yishui.yishuirpc.model.ServiceMetaInfo;
import com.yishui.yishuirpc.registry.LocalRegistry;
import com.yishui.yishuirpc.registry.Registry;
import com.yishui.yishuirpc.registry.RegistryFactory;
import com.yishui.yishuirpc.server.HttpServer;
import com.yishui.yishuirpc.server.VertxHttpServer;
import com.yishui.yishuirpc.server.tcp.VertxTcpServer;

import java.util.ArrayList;


/**
 * 服务提供者示例
 *
 */
public class ProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 TCP 服务
        VertxTcpServer vertxTcpServer = new VertxTcpServer();
        vertxTcpServer.doStart(8080);
    }
}
