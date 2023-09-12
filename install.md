# Deployment instructions

## 1. Prerequisites

| Serial Number | Software |
| ---- | ------------------- |
| 1 | FISCO-BCOS 2.2.0 |
| 2 | WeBASE-Front v1.2.3 |
| 3 | Java8 or above |
| 4 | RabbitMQ new version |


## 2. Things to note
* It is recommended to use [OpenJDK](https://openjdk.java.net/) for Java. It is recommended to download it from the OpenJDK website (OpenJDK in the yum warehouse of CentOS lacks JCE (Java Cryptography Extension), causing Web3SDK to be unable to connect to the blockchain node normally. )[Download address](https://jdk.java.net/java-se-ri/11) [Installation Guide](https://openjdk.java.net/install/index.html)
* For installation instructions, please refer to [Installation Example](./appendix.md#1-Installation Example)
* If you encounter problems during the service construction process, please check [FAQ](./appendix.md#2-FAQ)
* Security reminder: It is strongly recommended to set a complex database login password and strictly control the permissions and network policies for data operations.


## 3. Pull code
Excuting an order:
```shell
git clone https://github.com/WeBankFinTech/WeBASE-Event-Client.git
```
Enter the directory:

```shell
cd WeBASE-Event-Client
```

## 4. Compile code

Method 1: If the server has Gradle installed and the version is Gradle-4.10 or above

```shell
gradle build -x test
```

Method 2: If Gradle is not installed on the server, or the version is not Gradle-4.10 or above, use gradlew to compile

```shell
chmod +x ./gradlew && ./gradlew build -x test
```

After the build is completed, the compiled code directory dist will be generated under the root directory WeBASE-Event-Client.

## 5. Service configuration and start and stop
### 5.1 Service configuration modification
(1) Return to the dist directory. The dist directory provides a configuration template conf_template:

```
Generate an actual configuration conf based on the configuration template. The initial deployment can be copied directly.
For example: cp conf_template conf -r
```

(2) Modify the service configuration. For complete configuration item description, please see [Configuration Description](./appendix.md#3-applicationyml Configuration Item Description)
```shell
vi conf/application.yml
```

### 5.2 Service start and stop
Execute in the dist directory:
```shell
Start: bash start.sh
Stop: bash stop.sh
Check: bash status.sh
```
**Remarks**: After the service process starts up, you need to confirm whether it starts normally through the log. If the following content appears, it means it is normal; if the service is abnormal, confirm the modification of the configuration and then restart. If it is prompted that the service process is running, execute stop.sh first and then start.sh.

```
...
Application() - main run success...
```

## 6 Visit

You can view the calling interface through swagger:

```
http://{deployIP}:{deployPort}/WeBASE-Event-Client/swagger-ui.html
Example: http://localhost:5006/WeBASE-Event-Client/swagger-ui.html
```

**Remark:** 

- The deployment server IP and service port need to be modified accordingly, and the network policy needs to be enabled

## 7 View log

View in the dist directory:
```shell
Full log: tail -f log/WeBASE-Event-Client.log
Error log: tail -f log/WeBASE-Event-Client-error.log
```