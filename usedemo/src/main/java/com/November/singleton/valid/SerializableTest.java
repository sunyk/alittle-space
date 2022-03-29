/*
 * Copyright 2018 SunAd.cn All right reserved. This software is the
 * confidential and proprietary information of SunAd.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with SunAd.cn
 */
package com.November.singleton.valid;

import java.io.*;
import java.util.Objects;

/**
 * 测试枚举类是否能防止序列化破坏单例模式
 * 结果：可以防止序列化破坏单例模式
 *
 * @author sunyang
 * @date 2018/11/14 11:52
 */
public class SerializableTest {

    public static void main(String[] args) throws Exception{
        File objectFile = new File("Singleton8.javaObject");
        Singleton8 instance1 = Singleton8.INSTANCE;
        Singleton8 instance2 = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            //序列化到本地
            oos = new ObjectOutputStream(new FileOutputStream(objectFile));
            oos.writeObject(instance1);
            oos.flush();
            //反序列化到内存
            ois = new ObjectInputStream(new FileInputStream(objectFile));
            instance2= (Singleton8) ois.readObject();
        }catch (Exception e){

        }finally {
            oos.close();
            ois.close();
        }

        //true,说明两者引用着同一个对象
        System.out.println(Objects.equals(instance1, instance2));

    }
}

