### 反射修改 - 查询条件默认 -1 为全部

~~~java
/**
     * 查询参数校验
     * 用于条件查询参数中空值过滤和-1默认校验为全部
     *
     * @param object
     */
    public static void checkParamCoverNull(Object object){
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {
                if (StringUtils.isBlank(field.get(object)) || CommonConstant.NEGATIVE_ONE.equals(field.get(object))){
                    Field newField = object.getClass().getDeclaredField(field.getName());
                    newField.setAccessible(true);
                    newField.set(object, null);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
~~~

