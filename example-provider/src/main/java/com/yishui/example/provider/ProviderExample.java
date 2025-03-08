package com.yishui.example.provider;

import com.yishui.example.common.service.UserService;
import com.yishui.yishuirpc.RpcApplication;
import com.yishui.yishuirpc.bootstrap.ProviderBootstrap;
import com.yishui.yishuirpc.config.RegistryConfig;
import com.yishui.yishuirpc.config.RpcConfig;
import com.yishui.yishuirpc.model.ServiceMetaInfo;
import com.yishui.yishuirpc.model.ServiceRegisterInfo;
import com.yishui.yishuirpc.registry.LocalRegistry;
import com.yishui.yishuirpc.registry.Registry;
import com.yishui.yishuirpc.registry.RegistryFactory;
import com.yishui.yishuirpc.server.HttpServer;
import com.yishui.yishuirpc.server.VertxHttpServer;
import com.yishui.yishuirpc.server.tcp.VertxTcpServer;

import java.util.ArrayList;
import java.util.List;


/**
 * 服务提供者示例
 *
 */
public class ProviderExample {

    public static void main(String[] args) {
        // 要注册的服务
        List<ServiceRegisterInfo<?>> serviceRegisterInfoList = new ArrayList<>();
        ServiceRegisterInfo<UserService> serviceRegisterInfo = new ServiceRegisterInfo<>(UserService.class.getName(), UserServiceImpl.class);
        serviceRegisterInfoList.add(serviceRegisterInfo);

        // 服务提供者初始化
        ProviderBootstrap.init(serviceRegisterInfoList);
    }
}