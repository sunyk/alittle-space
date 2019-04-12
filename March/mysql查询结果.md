### MySQL 中多个Left join 子查询

> 好久没写sql了，今天突然接到产品的需求，要拉取线上数据一个文章的统计，我心里就万马奔腾...TM，不是有前端埋点和事件埋点。。。

### 简单的联表查询

~~~mysql
SELECT
	a.id,
	a.thumbNail,
	a. NAME,
	a.marketPrice,
	a.memberPrice,
	a.personName,
	a. STATUS,
	a.recieveOrderDate,
	a.trackNumber,
	a.contact,
	a.reportSendDate,
	b.trackNumber,
	a.reportDownloadPath
FROM
	(
		SELECT
			od.id,
			ps.thumbNail,
			ps. NAME,
			od.marketPrice,
			od.memberPrice,
			od.personName,
			od. STATUS,
			od.recieveOrderDate,
			ol.trackNumber,
			ol.contact,
			od.reportSendDate,
			od.reportSendOrderLogisticId,
			od.reportDownloadPath
		FROM
			orders.order_detail od
		LEFT JOIN orders.order_logistics ol ON od.recieveOrderLogisticId = ol.id
		LEFT JOIN orders.product_snapshot ps ON od.productSnapShotId = ps.id
		WHERE
			od.valid = TRUE
		AND ol.valid = TRUE
		AND od.orderId =?
	) a
LEFT JOIN (
	SELECT
		ol.trackNumber,
		od.id
	FROM
		orders.order_detail od
	LEFT JOIN orders.order_logistics ol ON od.reportSendOrderLogisticId = ol.id
	WHERE
		od.valid = TRUE
	AND ol.valid = TRUE
	AND od.orderId =?
) b ON a.id = b.id
~~~

### 多表查询结果中，有一列值是另外一张表多行结果合并，多个嵌套查询

~~~mysql
SELECT DISTINCT
	a.doc_id AS '文档ID',
	a.title AS '标题',
	e.labels AS '标签',
	a.show_num AS '浏览人次',
	g.used_type AS '有用',
	h.unused_type AS '无用',
	a.doc_status AS '是否上线0:下线1:上线',
	d.link_value AS '相关汽车结构',
	b.car_model AS '相关车型',
	c.pid_name AS '相关产品pid',
	f.attachment_name AS '是否有附件',
	a.created_time AS '创建时间',
	a.updated_time AS '更新时间'
FROM
	(
		SELECT
			d.doc_id,
			d.title,
			d.doc_status,
			d.created_time,
			d.updated_time,
			s.show_num AS show_num
		FROM
			knowledge_doc d
		LEFT JOIN doc_statistics s ON d.doc_id = s.doc_id
		WHERE
			d.is_deleted = 0
		AND s.is_deleted = 0
	) a
LEFT JOIN (
	SELECT
		doc_id,
		GROUP_CONCAT(t.link_value) AS car_model
	FROM
		doc_items t
	WHERE
		t.link_type = 6
	AND t.is_deleted = 0
	GROUP BY
		doc_id
) b ON a.doc_id = b.doc_id
LEFT JOIN (
	SELECT
		doc_id,
		GROUP_CONCAT(t.link_value) AS pid_name
	FROM
		doc_items t
	WHERE
		t.link_type = 4
	AND t.is_deleted = 0
	GROUP BY
		doc_id
) c ON a.doc_id = c.doc_id
LEFT JOIN (
	SELECT
		doc_id,
		GROUP_CONCAT(t.link_value) AS link_value
	FROM
		doc_items t
	WHERE
		t.link_type = 7
	AND t.is_deleted = 0
	GROUP BY
		doc_id
) d ON a.doc_id = d.doc_id
LEFT JOIN (
	SELECT
		doc_id,
		GROUP_CONCAT(t.link_value) AS labels
	FROM
		doc_items t
	WHERE
		t.link_type = 3
	AND t.is_deleted = 0
	GROUP BY
		doc_id
) e ON a.doc_id = e.doc_id
LEFT JOIN (
	SELECT
		biz_id,
		attachment_name
	FROM
		attachment_info
	WHERE
		biz_type = 3
	AND is_deleted = 0
) f ON a.doc_id = f.biz_id
LEFT JOIN (
	SELECT
		doc_id,
		evaluation_type AS used_type
	FROM
		doc_evaluation
	WHERE
		evaluation_type = 1
	AND is_deleted = 0
) g ON a.doc_id = g.doc_id
LEFT JOIN (
	SELECT
		doc_id,
		evaluation_type AS unused_type
	FROM
		doc_evaluation
	WHERE
		evaluation_type = 0
	AND is_deleted = 0
) h ON a.doc_id = h.doc_id
ORDER BY
	a.doc_id DESC
~~~

执行结果：

![1551860940581](C:\Users\sunyang\AppData\Local\Temp\1551860940581.png)

