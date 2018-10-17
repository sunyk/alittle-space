###  @Transactional事务

> 一个方法调用另外一个开启事务过程的方法，在同一个类中是不会生效的
>
> >  必须在把这个开启事务的方法，放到接口的类中，才可以正确的使用事务

~~~java
public BizBaseResponse<Boolean> addTrainingPlan(BizBaseRequest<TrainingPlanDetailRequest> trainDetailRequest) throws Exception {
        BizBaseResponse<Boolean> resultBizBaseResponse = new BizBaseResponse<Boolean>();
        boolean success = false;
        List<CourseListRequest> courseList = trainDetailRequest.postData.getCourseList();
        List<TrainingListRequest> trainingList = trainDetailRequest.postData.getTrainingList();
        List<ExamListRequest> examList = trainDetailRequest.postData.getExamList();
        Map<Integer, Object> resultMap = new TreeMap<>();
/**
* @link TrainingPlanTransactionService 接口
* saveTransactionForTrainingPlanDetail 方法开启事务的
*/
trainingPlanTransactionService.saveTransactionForTrainingPlanDetail(trainDetailRequest, resultMap);
}
~~~



# 猜想结果

@Transactional 是基于jdk动态代理方式，由于jdk动态代理是必须要有接口的类。

至于为什么JDK动态代理为什么必须使用接口呢，需要看JDK的Proxy源码。