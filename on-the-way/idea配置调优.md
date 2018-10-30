### IntelliJ IDEA调优配置

* idea.exe.vmoptions默认配置

~~~properties
-Xms128m
-Xmx512m
-XX:ReservedCodeCacheSize=240m
-XX:+UseConcMarkSweepGC
~~~

* 均衡配置

~~~properties
-Xms2g
-Xmx2g
-XX:ReservedCodeCacheSize=1024m
-XX:+UseCompressedOops
~~~

* 建议配置

~~~properties
-Xms1024m
-Xmx2048m
-XX:ReservedCodeCacheSize=1024m
-XX:+UseCompressedOops
~~~

