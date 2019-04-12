# MySQL 多字段组合唯一索引中，有一列字段可能会出现空值

### 业务场景：

**用户行为记录表，**防止用户数据重复插入表中。也防止尴尬。。。

### 直接上SQL，已优化

~~~java
CREATE TABLE `user_behavior` (
  `behavior_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '行为ID',
  `channel` smallint(5) NOT NULL DEFAULT '0' COMMENT '渠道：0,蓝虎APP订单详情',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `shop_user_id` binary(16) NOT NULL COMMENT '用户id',
  `doc_id` bigint(20) NOT NULL COMMENT '文档ID',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户行为状态：0，主动 1：强制',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`behavior_id`),
  UNIQUE KEY `index_shop_user_doc_id` (`channel`,`shop_user_id`,`doc_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='用户行为记录';
~~~

![1551952123894](C:\Users\sunyang\AppData\Local\Temp\1551952123894.png)



### 组合唯一索引，其中有一个字段会出现空值或NULL值

直接上SQL,其中order_id会出现NULL情况。

~~~mysql
CREATE TABLE `user_behavior` (
  `behavior_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '行为ID',
  `channel` smallint(5) NOT NULL DEFAULT '0' COMMENT '渠道：0,蓝虎APP订单详情',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `shop_user_id` binary(16) NOT NULL COMMENT '用户id',
  `doc_id` bigint(20) NOT NULL COMMENT '文档ID',
  `state` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户行为状态：0，主动 1：强制',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`behavior_id`),
  UNIQUE KEY `index_shop_user_doc_id` (`order_id`,`shop_user_id`,`doc_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='用户行为记录';
~~~

![1551955538809](C:\Users\sunyang\AppData\Local\Temp\1551955538809.png)

### 结论

组合唯一索引，其中有一个字段会出现NULL值，做防重复数据，是有问题的，所以组合唯一索引中不能出现NULL值存在。NOT NULL

