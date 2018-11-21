### Design Pattern Single Principle 

> 关于设计模式的单一原则，整理部分

#### 实现代码设计优化

单一职责适用于接口、类，同时也适用于方法：

一个方法尽可能做一件事情，比如一个方法`修改用户密码`  ，不要把这个方法放到`修改用户信息`方法中，这个方法的颗粒度很粗，代码展示

##### 一个方法承担多个职责，需设计

~~~java
void changeUser(IUserBO userBO, String changeOptions);
~~~

##### 一个方法承担一个职责，已设计

~~~java
void changeUserName(String newUserName);
void changeHomeAddress(String newHomeAddress);
void changePhone(String newPhone);
~~~

#### 结论

如果对接口，类，方法使用了单一职责原则，那么快乐就是单一的。

对于单一职责原则，接口一定要做到单一职责，类的设计尽量做到只有一个原因引起变化。

