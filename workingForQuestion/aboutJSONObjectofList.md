### 关于JSONObject取到List数组

代码示例

~~~java
public void getChildDeptUserInfo() throws Exception {
        JSONObject object = pullAllDeptInfo();
        if (StringUtils.isBlank(object)){
            return;
        }
        
    object.getJSONArray("userDeptList");
//此处 object.get("userDeptList") 取到的是一个List数组，需要转成对应的自定义的response
        List<DeptUserInfoResponse> deptUserInfo = JsonConvertUtils.jsonToList(object.get("userDeptList"), DeptUserInfoResponse.class);

        log.info(deptUserInfo.toString());

    }
~~~

`JsonConvertUtils#jsonToList`代码如下：

~~~java
import com.fasterxml.jackson.databind.ObjectMapper;

public static final ObjectMapper mapper = new ObjectMapper();

public static <T> List<T> jsonToList(Object jsonData, Class<T> beanType) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, new Class[]{beanType});

        try {
            List<T> list = (List)mapper.readValue(objectToJson(jsonData), javaType);
            return list;
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }
~~~





