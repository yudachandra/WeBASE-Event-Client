#WeBASE-Event-Client
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](https://webasedoc.readthedocs.io/zh_CN/latest/docs /WeBASE/CONTRIBUTING.html)
[![CodeFactor](https://www.codefactor.io/repository/github/webankblockchain/WeBASE-Event-Client/badge)](https://www.codefactor.io/repository/github/webankblockchain/WeBASE- Event-Client)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f5be085401f54e7080a654693ac260d4)](https://www.codacy.com/gh/WeBankBlockchain/WeBASE-Event-Client?utm_source=github .com&amp;utm_medium=referral&amp;utm_content=WeBankBlockchain/WeBASE-Event-Client&amp;utm_campaign=Badge_Grade)
[![Code Lines](https://tokei.rs/b1/github/WeBankBlockchain/WeBASE-Event-Client?category=code)](https://github.com/WeBankBlockchain/WeBASE-Event-Client)
[![license](http://img.shields.io/badge/license-Apache%20v2-blue.svg)](http://www.apache.org/licenses/)
[![GitHub (pre-)release](https://img.shields.io/github/release/WeBankBlockchain/WeBASE-Event-Client/all.svg)](https://github.com/WeBankBlockchain/WeBASE -Event-Client/releases)


WeBASE-Event-Client provides client event subscription services. Register event monitoring by calling [WeBASE-Front](https://github.com/WeBankFinTech/WeBASE-Front) front-end service to obtain messages for processing.

- Client development process:

1. The client user applies for an account (user name and password, virtual host) from the mq-server operation and maintenance administrator. The operation and maintenance administrator creates an account and creates a queue named appId, and then assigns the account to read its name. Permissions for exclusive queues (permission-read:queueName).

    The operation and maintenance administrator provides the user name (queue name) and password, virtual host, and message exchange name (exchangeName).

2. The client calls [WeBASE-Front](https://github.com/WeBankFinTech/WeBASE-Front) front-end service interface to register event monitoring.

3. The user connects to the corresponding virtual host with the username and password on the client, monitors the messages of his own queue (the queue name is configured in the `@RabbitListener` annotation in MQClientListener.java), and parses and processes the messages after receiving them.

- [Deployment Instructions](./install.md)

- [Interface Description](./interface.md)

## Contribution instructions
Please read our [Contribution Documentation](<https://webasedoc.readthedocs.io/zh_CN/latest/docs/WeBASE/CONTRIBUTING.html>) to learn how to contribute code and submit your contribution.

I hope that with your participation, [WeBASE](<https://webasedoc.readthedocs.io/zh_CN/latest/index.html>) will get better and better!

## Community
Contact us: webase@webank.com