# jdk8 foreach创建对象优化

### lambda foreach 创建对象

~~~java
@Async
    public void asyncFullEsDoc() {
        List<Integer> docIdList = Arrays.asList(913,914);
        if (CollectionUtil.isNotNullOrEmpty(docIdList)){
            List<Document> documents = new ArrayList<>(500);
            docIdList.forEach(docId ->{
                QueryKnowledgeDocResponse doc = synchronizeRedisBaseDoc(docId);
                if (!StringUtils.isBlank(doc)){
                    Map<String, Object> docMap = BeanToMap.objectToMap(doc);
                    Document document = new Document();
                    document.setDocumentId(docId.toString()).setDocument(docMap);
                    documents.add(document);
                }
            });

            ...
        }
    }
~~~

分析，对象释放优化

~~~java
	...
    
        List<Document> documents = new ArrayList<>(500);
            Document document = new Document();
            docIdList.forEach(docId ->{
                //用于对象释放
                document.setDocumentId(null);
                document.setDocument(null);
                QueryKnowledgeDocResponse doc = synchronizeRedisBaseDoc(docId);
                if (!StringUtils.isBlank(doc)){
                    Map<String, Object> docMap = BeanToMap.objectToMap(doc);
                    document.setDocumentId(docId.toString()).setDocument(docMap);
                    documents.add(document);
                }
            });

    ...
~~~

出现的bug，最后在addList时最后一个值覆盖了前面所有值，但是foreach中对象的每个对象值都是不同的。

![1547200334981](C:\Users\sunyang\AppData\Local\Temp\1547200334981.png)

分析，代码继续优化

~~~java
	...
        
    List<Document> documents = new ArrayList<>(500);
            Document document = null;
            for (Integer docId: docIdList) {
                document = new Document();
                QueryKnowledgeDocResponse doc = synchronizeRedisBaseDoc(docId);
                if (!StringUtils.isBlank(doc)){
                    Map<String, Object> docMap = BeanToMap.objectToMap(doc);
                    document.setDocumentId(docId.toString()).setDocument(docMap);
                    documents.add(document);
                }
            }
	...
~~~

如果我还是想用lambda foreach 创建对象

~~~java
	...
        List<Document> documents = new ArrayList<>(800);
            final Document[] document = new Document[1];
            docIdList.forEach(docId ->{
                QueryKnowledgeDocResponse doc = synchronizeRedisBaseDoc(docId);
                if (!StringUtils.isBlank(doc)){
                    Map<String, Object> docMap = BeanToMap.objectToMap(doc);
                    document[0] = new Document();
                    document[0].setDocumentId(docId.toString()).setDocument(docMap);
                    documents.add(document[0]);
                }
            });
	...
    
~~~

### 分析

~~~java
Object object= new Object();
~~~

写在100个循环内等于你有100个引用对应了100个对象，所以100个对象在一段时间都占用内存，知道内存不足GC主动回收。

~~~java
object = new Object();
~~~

写在100个循环内等于你使用1个引用分别100次调用了100个对象，所以当后一个对象init后，前一个对象已经是“无引用状态”，会很快的被GC自动回收（在你的循环还没结束时，可能已经进行了多次GC回收，这点重要）

需要更好管理内存。