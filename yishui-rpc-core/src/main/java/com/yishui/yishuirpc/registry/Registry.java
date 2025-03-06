package com.yishui.yishuirpc.registry;

import com.yishui.yishuirpc.config.RegistryConfig;
import com.yishui.yishuirpc.model.ServiceMetaInfo;

import java.util.List;


/**
 * 注册中心
 *
 */
public interface Registry {

    /**
     * 初始化
     *
     * @param registryConfig
     */
    void init(RegistryConfig registryConfig);

    /**
     * 注册服务（服务端）
     *
     * @param serviceMetaInfo
     */
    void register(ServiceMetaInfo serviceMetaInfo) throws Exception;

    /**
     * 注销服务（服务端）
     *
     * @param serviceMetaInfo
     */
    void unRegister(ServiceMetaInfo serviceMetaInfo);

    /**
     * 服务发现（获取某服务的所有节点，消费端）
     *
     * @param serviceKey 服务键名
     * @return
     */
    List<ServiceMetaInfo> serviceDiscovery(String serviceKey);

    /**
     * 监听（消费端）
     */
    void watch(String serviceNodeKey);

    /**
     * 服务销毁
     */
    void destroy();

    /**
     * 心跳检测(服务端)
     */
    void heartBeat();
}
