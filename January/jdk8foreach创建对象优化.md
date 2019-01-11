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

如果我还是想用lambda