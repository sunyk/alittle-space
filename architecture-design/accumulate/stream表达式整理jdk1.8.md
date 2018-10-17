#### 1.8JDK 中 Stream 整理

* filter 

~~~java
         Optional<Integer> sectionTypeId = sectionTypeInfoList.stream().map(SectionTypeInfo::getId).sorted().findFirst();
~~~

~~~java
        Map<Integer, List<TrainingPlanSection>> trainMap = trainingPlanSectionList.stream().collect(Collectors.groupingBy(TrainingPlanSection::getSectionTypeId));
        Optional<SectionTypeInfo> courseSection = sectionTypeInfoList.stream().filter(SectionTypeInfo ->SectionTypeInfo.getType().equals("0")).findAny();
        Optional<SectionTypeInfo> trainSection = sectionTypeInfoList.stream().filter(SectionTypeInfo ->SectionTypeInfo.getType().equals("1")).findAny();
        Optional<SectionTypeInfo> examSection = sectionTypeInfoList.stream().filter(SectionTypeInfo ->SectionTypeInfo.getType().equals("2")).findAny();
~~~

~~~java
List<Integer> idList = trainingPlanSectionList.stream().map(TrainingPlanSection::getSectionTypeId).collect(Collectors.toList());
~~~



### 分组统计

~~~java
public class FunctionX {
    public static void main(String[] args) {
        //1.分组计数
        List<Student> list1= Arrays.asList(
                new Student(1,"one","zhao"),new Student(2,"one","qian"),new Student(3,"two","sun"));
        //1.1根据某个属性分组计数
        Map<String,Long> result1=list1.stream().collect(Collectors.groupingBy(Student::getGroupId,Collectors.counting()));
        System.out.println(result1);
        //1.2根据整个实体对象分组计数,当其为String时常使用
        Map<Student,Long> result2=list1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(result2);
        //1.3根据分组的key值对结果进行排序、放进另一个map中并输出
        Map<String,Long> xMap=new HashMap<>();
        result1.entrySet().stream().sorted(Map.Entry.<String,Long>comparingByKey().reversed()) //reversed不生效
                .forEachOrdered(x->xMap.put(x.getKey(),x.getValue()));
        System.out.println(xMap);

        //2.分组，并统计其中一个属性值得sum或者avg:id总和
        Map<String,Integer> result3=list1.stream().collect(
                Collectors.groupingBy(Student::getGroupId,Collectors.summingInt(Student::getId))
        );
        System.out.println(result3);

    }
}
~~~

