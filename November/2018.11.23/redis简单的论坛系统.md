### redis关于文档系统分析

涉及功能点如下：

- 可以发布文章
- 可以对文章进行点赞
- 在首页可以按文章的发布时间或者文章的点赞数进行排序显示



1.redis中新建文章

~~~properties
hset article:92617 title thisisarticle92617
hset article:92617 link http://SunAd.document.cn/article?docid=92617
hset article:92617 poster user:83271
hset article:92617 votes 100
~~~

![1542969636767](C:\Users\sunyang\AppData\Local\Temp\1542969636767.png)

2.对文章进行点赞：对该文章的votes字段进行加1操作，还必须记录该用户已经对该文章进行了点点赞，防止用户点赞次数超过1.需要建立文章的已投票用户集合来进行记录。

~~~properties
incr votes //点赞加1
sadd voted:92617 user:83271 //保存记录
~~~

