# 开发中遇到整理：值传递和方法传递

一个`void`方法接口中参数传递，tid传递进入被赋值，但是在调用的后的操作时用到tid依然是没有值，值并没有发生传递，

~~~java
@Override
    public BizBaseResponse<Boolean> addTrainingPlan(BizBaseRequest<TrainingPlanDetailRequest> trainDetailRequest) throws Exception {
        ...
        int tid;
        saveTransactionForTrainingPlanDetail(trainDetailRequest, tid, resultMap);

        ...
            paramMap.put("trainingPlanId", tid);//此处拿到的值并未被赋值
            paramMap.put("sectionTypeId", sid);
            List<TrainingPlanSectionData> courceSectionData = BeanUtil.copyPropertiesList(courseList, TrainingPlanSectionData.class);
            sectionDataProcess(courceSectionData, paramMap);
        
    }
~~~

void方法参数：

~~~java
public void saveTransactionForTrainingPlanDetail(BizBaseRequest<TrainingPlanDetailRequest> trainDetailRequest, int tid, Map<Integer, Object> resultMap) throws Exception {
        ...
            //对tid进行赋值
            int tid = trainingPlan.getId();
    
           ...
    }
~~~

# 结论

接口方法传递中，把要传的值放到对象里面进行传递和取值使用。