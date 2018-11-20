### 工作中 关于json 转换的

接口间doPostCommon调用，躺过的坑,如图

![1542713271041](C:\Users\sunyang\AppData\Local\Temp\1542713271041.png)

直接上代码

~~~java
result = HttpClientUtils.doPostCommon(serviceProperties.getChildDeptUserInfo(), null,
                    JSON.toJSON(param), NameConstant.UTF_8);
JSONObject backData = result.getJSONObject("data");

~~~

`HttpClientUtils#doPostCommon`源码分析

~~~java
public static JSONObject doPostCommon(String url, Map<String, String> header, Object body, String charset) {
        HttpPost httpPost = null;
        JSONObject jsonResult = null;
        CloseableHttpResponse response = null;

        try {
            httpPost = new HttpPost(url);
            if (header != null) {
                Iterator iterator = header.entrySet().iterator();

                while(iterator.hasNext()) {
                    Entry<String, String> elem = (Entry)iterator.next();
                    httpPost.addHeader((String)elem.getKey(), (String)elem.getValue());
                }
            }

            StringEntity sEntity = new StringEntity(JSON.toJSONString(body), charset);
            sEntity.setContentType("application/json");
            sEntity.setContentEncoding(new BasicHeader("Content-Type", "application/json"));
            httpPost.setEntity(sEntity);
            response = HTTP_CLIENT.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    String sResult = EntityUtils.toString(resEntity, charset);
                    if (StringUtils.isNotBlank(sResult)) {
                        jsonResult = JSON.parseObject(sResult);
                        JSONObject var10 = jsonResult;
                        return var10;
                    }
                }
            }
        } catch (Exception var20) {
            logger.error("服务调用异常,URL={}", url, var20);
            throw new BizException(BizErrorCodeEnum.CALLSERVICCE_ERROR, "服务调用异常");
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException var19) {
                logger.error("关闭http连接异常,URL={}", url, var19);
            }

        }

        return null;
    }
~~~



