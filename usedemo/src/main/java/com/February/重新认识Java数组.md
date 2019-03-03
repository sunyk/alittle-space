# 重新认识 Java 数组

* 声明数组

~~~java
double[] myDouble;  //首选
double myDouble2[]; //效果相同，风格来自C/C++语言

/**
* 1.使用double[size] 创建一个数组。
* 2.把新创建的数组引用赋值给变量 myDoubleVal。
*/
myDoubleVal = new double[size]
/**
*数组变量的声明，和创建数组可以用一条语句完成
*/
double[] myDoubleDef = new double[size]
/**
* 写法二 数组的元素是通过索引访问的。数组索引从0开始，所以索引值从0 到 length-1
*/
double[] myDoubleDef = {value0, value1, ..., valuek};

~~~

