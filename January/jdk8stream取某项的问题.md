# jdk8 Stream map 取对象中某项的值

### map 取对象中某项的值 问题

~~~java
	...
   
    List<ScreenWiperResponse> screenWiperList=  screenWiperResponseList.stream().map(CarAdapterForScreenWiperResponse::getPartData).collect(Collectors.toList());
        List<String> productModelList = new LinkedList<>();
        log.info("screenWiperList: {}", screenWiperList);
        screenWiperList.forEach(screenWiperResponse -> {
            if (CollectionUtil.isNotNullOrEmpty(screenWiperResponse.getPartNos())){
                productModelList.addAll(screenWiperResponse.getPartNos());
            }
        });
	
	...

~~~

**分析**：拿到值就做处理，出现空指针，出现的Bug是，根据某项值进行取值后，会出现null对象



![](C:\Users\sunyang\Desktop\QQ截图20190114181347.png)

size等于2是，原数据，通过取某项值后，返回对应位置的数据，第一个对象不符合，为null，第二个对象符合取值条件，就显示有数据。

![](C:\Users\sunyang\Desktop\QQ截图20190114181315.png)

经过上面分析，问题已经找到，需要把null过滤，代码调整

~~~java
	...
        
       List<ScreenWiperResponse> screenWiperList=  screenWiperResponseList.stream().map(CarAdapterForScreenWiperResponse::getPartData).filter(x -> x != null).collect(Collectors.toList());
        List<String> productModelList = new LinkedList<>();
        log.info("screenWiperList: {}", screenWiperList);
        screenWiperList.forEach(screenWiperResponse -> {
            if (CollectionUtil.isNotNullOrEmpty(screenWiperResponse.getPartNos())){
                productModelList.addAll(screenWiperResponse.getPartNos());
            }
        });
	...
~~~

**惯性**：一般用jdk8 stream的map根据某一项取值，取完之后，基本就结束了，如果你继续把这个集合进行循环处理，就会发现bug ，手动过滤下，此处也算是一坑

~~~java
	...
         screenWiperResponseList.stream().map(CarAdapterForScreenWiperResponse::getPartData).filter(x -> x != null).collect(Collectors.toList());
	...
    
~~~
