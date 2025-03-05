package com.yishui.example.consumer;

import com.yishui.yishuirpc.config.RpcConfig;
import com.yishui.yishuirpc.utils.ConfigUtils;


/**
 * 简易服务消费者示例
 *

 */
public class ConsumerExample {

    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
    }
}
