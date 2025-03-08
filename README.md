# Yishui-RPC 项目文档
## 项目介绍
Yishui-RPC 是一个基于 Java 实现的远程过程调用（RPC）框架，支持多种注册中心（如 Etcd），具备可配置化的服务版本、序列化器、负载均衡器、重试策略和容错策略等功能。该框架使用 Spring Boot 作为启动器，简化了项目的配置和启动过程。

## 项目结构说明
项目采用 Maven 多模块结构，主要模块如下：
```plaintext
yishui-rpc/
├── .git/                   # Git 版本控制目录
├── .idea/                  # IntelliJ IDEA 项目配置目录
├── README.md               # 项目说明文档
├── example-common/         # 示例公共模块
│   ├── pom.xml             # Maven 配置文件
│   ├── src/                # 源代码目录
│   └── target/             # 编译输出目录
├── example-consumer/       # 示例消费者模块
│   ├── pom.xml             # Maven 配置文件
│   ├── src/                # 源代码目录
│   └── target/             # 编译输出目录
├── example-provider/       # 示例提供者模块
│   ├── pom.xml             # Maven 配置文件
│   ├── src/                # 源代码目录
│   └── target/             # 编译输出目录
├── example-springboot-consumer/ # Spring Boot 示例消费者模块
│   ├── .gitignore          # Git 忽略文件
│   ├── pom.xml             # Maven 配置文件
│   └── src/                # 源代码目录
├── example-springboot-provider/ # Spring Boot 示例提供者模块
│   ├── .gitignore          # Git 忽略文件
│   ├── pom.xml             # Maven 配置文件
│   └── src/                # 源代码目录
├── yishui-rpc-core/        # RPC 核心模块
│   ├── pom.xml             # Maven 配置文件
│   ├── src/                # 源代码目录
│   └── target/             # 编译输出目录
└── yishui-rpc-spring-boot-starter/ # Spring Boot 启动器模块
├── .gitignore          # Git 忽略文件
├── pom.xml             # Maven 配置文件
└── src/                # 源代码目录
```
### 主要模块功能
+ yishui-rpc-core：包含 RPC 框架的核心功能，如配置加载、注册中心初始化、服务缓存管理等。
+ yishui-rpc-spring-boot-starter：提供 Spring Boot 集成，简化 RPC 框架的启动和配置。
+ example-*：包含多个示例模块，展示了如何使用 Yishui RPC 框架进行服务的提供和消费。

## 使用教程
1. 环境准备
+ Java 11 或更高版本 
+ Maven 3.0 或更高版本
2. 克隆项目
```bash
git clone https://github.com/your-repo/yishui-rpc.git
cd yishui-rpc
```
3. 编译项目
```bash
mvn clean install
```
4. 配置服务提供者

在 example-provider 模块的 src/main/resources/application.properties 文件中配置服务信息：
```properties
rpc.name=yishuirpc
rpc.version=2.0
rpc.serverPort=8889
rpc.mock = false
rpc.serializer=jdk
```
5. 配置服务消费者

在 example-consumer 模块的 src/main/resources/application.properties 文件中配置服务信息：
```properties
rpc.name=yishuirpc
rpc.version=2.0
rpc.serverPort=8889
rpc.mock = false
rpc.serializer=jdk
```
6. 启动服务提供者

在 example-provider 模块中启动服务提供者应用程序。
7. 启动服务消费者

在 example-consumer 模块中启动服务消费者应用程序，发起 RPC 调用。
8. 自定义配置

可以根据需要修改 RpcConfig 和 RegistryConfig 类中的配置项，以满足不同的业务需求。例如，修改注册中心地址、序列化器、负载均衡器等。
   
## 配置说明
### RpcConfig
+ name：RPC 服务名称，默认值为 yishui-rpc。 
+ version：服务版本号，默认值为 1.0。
+ serverHost：服务器主机名，默认值为 localhost。
+ serverPort：服务器端口号，默认值为 8888。 
+ mock：是否开启模拟调用，默认值为 false。 
+ registryConfig：注册中心配置，默认使用 Etcd 注册中心。 
+ serializer：序列化器，默认使用 JDK 序列化。 
+ loadBalancer：负载均衡器，默认使用轮询策略。 
+ retryStrategy：重试策略，默认不重试。 
+ tolerantStrategy：容错策略，默认快速失败。 

### RegistryConfig
+ registry：注册中心类别，默认值为 etcd。 
+ address：注册中心地址，默认值为 http://localhost:2380。
+ username：注册中心用户名，默认为空。 
+ password：注册中心密码，默认为空。 
+ timeout：超时时间（单位毫秒），默认值为 10000。
   
## 注意事项
+ 确保注册中心（如 Etcd）已正确启动，并配置正确的地址和端口。 
+ 在使用自定义配置时，注意配置项的合法性和兼容性。

以上是 Yishui RPC 项目的详细说明，希望对你有所帮助。如果有任何问题，请随时联系我们。