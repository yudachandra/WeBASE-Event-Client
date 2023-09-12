# Interface Description

[TOC]

## 1 Queue management module

### 1.1 Get message queue information

#### 1.1.1 Transmission protocol specification

- Network transmission protocol: Use HTTP protocol
- Request address: **/mqManage/getAllMessageQueueDetail**
- Request method: GET
- Request header: Content-type: application/json
-Return format: JSON

#### 1.1.2 Request parameters

***1) Enter the parameter table***

none

***2) Parameter input example***

```
http://127.0.0.1:5006/WeBASE-Event-Client/mqManage/getAllMessageQueueDetail
```

#### 1.1.3 Return parameters

***1) Output parameter table***

| Serial number | Output parameter | Type | | Remarks |
| ---- | ------------------- | ------- | ---- | ----------- --- |
| 1 | | List | | Queue information object |
| 1.1 | queueName | string | no | chain number |
| 1.2 | containerIdentity | string | No | Listening container identification |
| 1.3 | activeContainer | boolean | No | Whether the monitoring is valid |
| 1.4 | running | boolean | yes | whether listening |
| 1.5 | activeConsumerCount | int | no | Number of active consumers |

***2) Parameter output example***

- success:

```
[
   {
     "queueName": "alice",
     "containerIdentity": "Container@2ce1ee55",
     "activeContainer": true,
     "running": true,
     "activeConsumerCount": 1
   }
]
```

- fail:

```
{
     "code": 102000,
     "message": "system exception",
     "data": {}
}
```

### 1.2 Restart monitoring the message queue

#### 1.2.1 Transmission protocol specification

- Network transmission protocol: Use HTTP protocol
- Request address: **/mqManage/restartMessageListener**
- Request method: GET
- Return format: JSON

#### 1.2.2 Request parameters

***1) Enter the parameter table***

none

***2) Parameter input example***

```
http://127.0.0.1:5006/WeBASE-Event-Client/mqManage/restartMessageListener
```

#### 1.2.3 Return parameters

***1) Output parameter table***

| Serial number | Output parameter | Type | | Remarks |
| ---- | -------- | ------- | ---- | ---- |
| 1 | | boolean | no | result |

***2) Parameter output example***

- success:

```
true
```

- fail:

```
{
    "code": 102000,
    "message": "system exception",
    "data": {}
}
```

### 1.3 Stop monitoring the message queue

#### 1.3.1 Transmission protocol specification

- Network transmission protocol: Use HTTP protocol
- Request address: **/mqManage/stopMessageListener**
- Request method: DELETE
- Request header: Content-type: application/json
-Return format: JSON

#### 1.3.2 Request parameters

***1) Enter the parameter table***

***2) Parameter input example***

```
http://127.0.0.1:5006/WeBASE-Event-Client/mqManage/stopMessageListener
```

#### 1.3.3 Return parameters

***1) Output parameter table***

| Serial number | Output parameter | Type | | Remarks |
| ---- | -------- | ------- | ---- | ---- |
| 1 | | boolean | no | result |

***2) Parameter output example***

- success:

```
true
```

- fail:

```
{
     "code": 102000,
     "message": "system exception",
     "data": {}
}
```

## 2 Pre-module

### 2.1 Register block event listening configuration

Register the block notification listening configuration and return the user's block notification listening configuration list.

#### 2.1.1 Transmission protocol specification

- Network transmission protocol: Use HTTP protocol
- Request address: **/front/newBlockEvent**
- Request method: POST
- Request header: Content-type: application/json
-Return format: JSON

#### 2.1.2 Request parameters

***1) Enter the parameter table***

| Serial number | Input parameters | Type | Can be empty | Remarks |
| ---- | ------------ | ------ | ------ | ------------------ ---------- |
| 1 | appId | string | No | The unique number of the app that registered for event notification |
| 2 | groupId | int | no | group number |
| 3 | exchangeName | string | No | Queue switch name |
| 4 | queueName | string | No | Queue name, use user name as queue name |

***2) Parameter input example***

```
http://127.0.0.1:5006/WeBASE-Event-Client/front/newBlockEvent
```

```
{
   "appId": "appId7",
   "exchangeName": "exchange_group1",
   "groupId": 1,
   "queueName": "alice"
}
```

#### 2.1.3 Return parameters

***1) Output parameter table***

| Serial number | Output parameter | Type | | Remarks |
| ---- | ------------ | ------ | ---- | ------------------- --------------- |
| 1 | code | Int | No | Return code, 0: success, other: failure |
| 2 | message | String | No | Description |
| 3 | | Object | | Node information object |
| 3.1 | id | int | no | event number |
| 3.2 | eventType | int | No | Event type (1: block, 2: contract event) |
| 3.3 | appId | string | No | The unique number of the app that registered for event notification |
| 3.4 | groupId | string | no | group number |
| 3.5 | exchangeName | int | No | The name of the switch to which the queue belongs |
| 3.6 | queueName | string | No | Queue name, use user name as queue name |
| 3.7 | routingKey | string | yes | routing key |

***2) Parameter output example***

- success:

```
{
   "code": 0,
   "message": "success",
   "data": [
     {
       "id": "8aa4a195706058d60170606041e00001",
       "eventType": 1,
       "appId": "appId7",
       "groupId": 1,
       "exchangeName": "exchange_group1",
       "queueName": "alice",
       "routingKey": "alice_block_appId7"
     }
   ]
}
```

- fail:

```
{
     "code": 102000,
     "message": "system exception",
     "data": {}
}
```

### 2.2 Register contract event listening configuration

Register the contract event listening configuration and return the user's contract event listening configuration list.

#### 2.2.1 Transmission protocol specification

- Network transmission protocol: Use HTTP protocol
- Request address: **/front/contractEvent**
- Request method: POST
- Request header: Content-type: application/json
-Return format: JSON

#### 2.2.2 Request parameters

***1) Enter the parameter table***

| Serial number | Input parameters | Type | Can be empty | Remarks |
| ---- | --------------- | ------------ | ------ | -------- -------------------------- |
| 1 | appId | string | No | The unique number of the app that registered for event notification |
| 2 | groupId | int | no | group number |
| 3 | exchangeName | string | No | Queue switch name |
| 4 | queueName | string | No | Queue name, use user name as queue name |
| 5 | contractAddress | string | No | Deployed contract address |
| 6 | contractAbi | string | No | Deployed contract abi |
| 7 | fromBlock | string | No | The starting block height of monitoring |
| 8 | toBlock | string | No | Monitored end block high |
| 9 | topicList | List<String> | Yes | Event name (eg: SetName(string)) |

***2）Input parameter example***

```
http://127.0.0.1:5006/WeBASE-Event-Client/front/contractEvent
```

```
{
  "appId": "appId8",
  "contractAbi": "[{\"constant\":false,\"inputs\":[{\"name\":\"n\",\"type\":\"string\"}],\"name\":\"set\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"get\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"n\",\"type\":\"string\"}],\"name\":\"set2\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"name\",\"type\":\"string\"}],\"name\":\"SetName\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"name\",\"type\":\"string\"}],\"name\":\"SetName2\",\"type\":\"event\"}]",
  "contractAddress": "0x8ec4f530256ad3ee3957b2bdccc6d58252ecf29d",
  "exchangeName": "exchange_group1",
  "fromBlock": "latest",
  "groupId": 1,
  "queueName": "alice",
  "toBlock": "latest",
  "topicList": [
    "SetName(string)"
  ]
}
```

#### 2.2.3 返回参数

***1）出参表***

| 序号 | 输出参数        | 类型         |      | 备注                              |
| ---- | --------------- | ------------ | ---- | --------------------------------- |
| 1    | code            | Int          | 否   | 返回码，0：成功 其它：失败        |
| 2    | message         | String       | 否   | 描述                              |
| 3    |                 | Object       |      | 节点信息对象                      |
| 3.1  | id              | int          | 否   | 事件编号                          |
| 3.2  | eventType       | int          | 否   | 事件类型（1: 出块, 2: 合约event） |
| 3.3  | appId           | string       | 否   | 注册事件通知的应用的唯一编号      |
| 3.4  | groupId         | string       | 否   | 群组编号                          |
| 3.5  | exchangeName    | int          | 否   | 队列所属交换机名字                |
| 3.6  | queueName       | string       | 否   | 队列名称，以用户名作队列名        |
| 3.7  | routingKey      | string       | 是   | 路由键                            |
| 3.8  | contractAddress | string       | 否   | 已部署合约地址                    |
| 3.9  | contractAbi     | string       | 否   | 已部署合约abi                     |
| 3.10 | fromBlock       | string       | 否   | 监听的开始块高                    |
| 3.11 | toBlock         | string       | 否   | 监听的结束块高                    |
| 3.12 | topicList       | List<String> | 是   | 事件名（如：SetName(string)）     |

***2）出参示例***

- 成功：

```
{
  "code": 0,
  "message": "success",
  "data": [
    {
      "id": "8aa4a195706058d60170606b69260002",
      "eventType": 2,
      "appId": "appId8",
      "groupId": 1,
      "exchangeName": "exchange_group1",
      "queueName": "alice",
      "routingKey": "alice_event_appId8",
      "contractAbi": "[{\"constant\":false,\"inputs\":[{\"name\":\"n\",\"type\":\"string\"}],\"name\":\"set\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"get\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"n\",\"type\":\"string\"}],\"name\":\"set2\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"name\",\"type\":\"string\"}],\"name\":\"SetName\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"name\",\"type\":\"string\"}],\"name\":\"SetName2\",\"type\":\"event\"}]",
      "fromBlock": "latest",
      "toBlock": "latest",
      "contractAddress": "0x8ec4f530256ad3ee3957b2bdccc6d58252ecf29d",
      "topicList": "SetName(string)"
    }
  ]
}
```

- 失败：

```
{
    "code": 102000,
    "message": "system exception",
    "data": {}
}
```