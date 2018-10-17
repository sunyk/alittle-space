## 场景：使用普通的分组方式进行分组



~~~java
/**
     * 通过for循环逻辑，编程上会麻烦点，但是效率上高很多
     */
    private static void groupByCountryAndProvince_byNormal() {
        Map<String, Map<String, List<Article>>> result = new HashMap<String, Map<String, List<Article>>>();
        for (Article article : articles) {
            Map<String, List<Article>> pMap = result.get(article.getCountryCode());
            if(pMap==null) {
                pMap = new HashMap<String, List<Article>>();
                result.put(article.getCountryCode(), pMap);
            }
            List<Article> list = pMap.get(article.getProvince());
            if(list==null) {
                list = new ArrayList<Article>();
                pMap.put(article.getProvince(), list);
            }
            list.add(article);
        }
        result.forEach((cc, map) -> {
            System.out.println("Country Code is:" + cc);
            map.forEach((pc, list) -> {
                System.out.println("    Province Code is:" + pc);
                list.forEach((article) -> {
                    System.out.println("        Article titile is:" + article.getTitle() + ",author is:"
                            + article.getAuthor());
                });
            });
        });
    }
~~~

### 使用串行流的方式进行分组

~~~java
/**
     * 以串行流的方式，通过Collectors做多维度的分组，非常方便，但是性能上很差
     */
    private static void groupByCountryAndProvince() {
        Map<String, Map<String, List<Article>>> result = articles.stream()
                .collect(Collectors.groupingBy(Article::getCountryCode,
                        Collectors.groupingBy(Article::getProvince)));
        result.forEach((cc, map) -> {
            System.out.println("Country Code is:" + cc);
            map.forEach((pc, list) -> {
                System.out.println("    Province Code is:" + pc);
                list.forEach((article) -> {
                    System.out.println("        Article titile is:" + article.getTitle() + ",author is:"
                            + article.getAuthor());
                });
            });
        });
    }
~~~

### 使用并行流的方式进行分组

~~~java
/**
     * 以并行流的方式，通过Collectors做多维度的分组，性能上比串行流的效率就高很多了
     * 实现方式也很简单，只需要将stream()修改为parallelStream()实现。
     */
    private static void groupByCountryAndProvinceParallel() {
        Map<String, Map<String, List<Article>>> result = articles.parallelStream()
                .collect(Collectors.groupingBy(Article::getCountryCode,
                        Collectors.groupingBy(Article::getProvince)));
        result.forEach((cc, map) -> {
            System.out.println("Country Code is:" + cc);
            map.forEach((pc, list) -> {
                System.out.println("    Province Code is:" + pc);
                list.forEach((article) -> {
                    System.out.println("        Article titile is:" + article.getTitle() + ",author is:"
                            + article.getAuthor());
                });
            });
        });
    }
~~~

##### 测试demo

~~~java
public static void main(String[] args) {
        long start = System.currentTimeMillis();
        groupByCountryAndProvince();
        long end = System.currentTimeMillis();
        System.out.println("串行流分组使用时长（毫秒）:" + (end - start)+"\n");

        start = System.currentTimeMillis();
        groupByCountryAndProvinceParallel();
        end = System.currentTimeMillis();
        System.out.println("并行流分组使用时长（毫秒）:" + (end - start)+"\n");

        start = System.currentTimeMillis();
        groupByCountryAndProvince_byNormal();
        end = System.currentTimeMillis();
        System.out.println("普通分组使用时长（毫秒）:" + (end - start));
    }
~~~

##### 对比性能结果展示：

~~~javascript
Country Code is:CN
    Province Code is:GX
        Article titile is:Thank you teacher,author is:Bruce
    Province Code is:GD
        Article titile is:Hello wrold,author is:sunyk
        Article titile is:Work is amazing,author is:Tom
Country Code is:US
    Province Code is:OT
        Article titile is:New City,author is:Lucy
串行流分组使用时长（毫秒）:51

Country Code is:CN
    Province Code is:GX
        Article titile is:Thank you teacher,author is:Bruce
    Province Code is:GD
        Article titile is:Hello wrold,author is:sunyk
        Article titile is:Work is amazing,author is:Tom
Country Code is:US
    Province Code is:OT
        Article titile is:New City,author is:Lucy
并行流分组使用时长（毫秒）:4

Country Code is:CN
    Province Code is:GX
        Article titile is:Thank you teacher,author is:Bruce
    Province Code is:GD
        Article titile is:Hello wrold,author is:sunyk
        Article titile is:Work is amazing,author is:Tom
Country Code is:US
    Province Code is:OT
        Article titile is:New City,author is:Lucy
普通分组使用时长（毫秒）:1
~~~

### 实操中使用

~~~java
/**
     * 通过对应的阶段类型id，进行数据合并处理
     *
     * @param trainingPlanSectionList
     * @param sectionTypeInfoList
     * @return
     */
    private List<TrainingPlanSection> getTrainingPlanSections(List<TrainingPlanSection> trainingPlanSectionList, List<SectionTypeInfo> sectionTypeInfoList) {
        List<TrainingPlanSection> tempList = new ArrayList<>();
        for (int i = 0; i < trainingPlanSectionList.size(); i++) {
            TrainingPlanSection trainingPlanSection = trainingPlanSectionList.get(i);
            int sectionTypeId = trainingPlanSection.getSectionTypeId();
            for (int j = 0; j < sectionTypeInfoList.size(); j++) {
                SectionTypeInfo sectionTypeInfo = sectionTypeInfoList.get(j);
                int sectionTypeInfoId = sectionTypeInfo.getId();
                if (sectionTypeId == sectionTypeInfoId){
                    trainingPlanSection  = new TrainingPlanSection.TrainingPlanSectionBuilder()
                            .setType(sectionTypeInfo.getType())
                            .setSectionTypeId(sectionTypeInfo.getId())
                            .setId(trainingPlanSection.getId())
                            .setTrainingPlanId(trainingPlanSection.getTrainingPlanId())
                            .build();
                }
            }
            tempList.add(trainingPlanSection);
        }
        return tempList;
    }
~~~

