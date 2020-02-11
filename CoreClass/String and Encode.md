# String and Encode
## String 字符串
#### 1.字符串内部是通过char[]数组表示的. 所以可以这样写:
```java
String s2 = new String(new char[] {'H', 'e', '!'});
```
#### 2.==比较的是引用, 注意以下例子:
```java
String s1 = "hello";
String s2 = "hello";
String s3 = "HELLO".toLowerCase();
// s1 == s2  true
// s1 == s3  false
```
#### 3.字符串几个常用的方法:大小写转换与忽略, 包含, 搜索, 提取, 去除, 替换, 分割, 拼接:
```java
String s1 = "hh".toLowerCase(); // 转小写
String s2 = "hh".toUpperCase(); // 转大写
boolean r1 = s1.equalsIgnoreCase(s2);  // 忽略大小写的比较
```
contains() : 包含子序列,需要是连续的. CharSequence 是 String 的父类.
```java
public boolean contains(CharSequence s);
CharSequence cs1 = "int";
String s1 = "point"; String s2 = "poinot";
// s1.contains(cs1)  true
// s2.contains(cs1)  false
```
一些常用搜索方法:
```java
"Hello".indexOf("l"); // 2 从前面数的
"Hello".lastIndexOf("l"); // 3 倒着数的
"Hello".startsWith("He"); // true
"Hello".endsWith("lo"); // true
```
提取子串, 去除首尾空白字符 \t \r \n, 替换子串:
```java
"Hello".substring(2); // "llo" [beginIndex, endIndex) 前闭后开
"  \tHello\r\n  ".trim();  // "Hello"
String s1 = "hello";
s1.replace('l', 'w'); // hewwo
s1.replace("ll", "qq"); // heqqo
```
分割字符串常用正则表达式, 拼接方法用的是静态方法:
```java
String s = "A,B,C";
String[] s1 = s.split("\\,");   // {"A", "B", "C"}
String s2 = String.join("---", s1); // "A---B---C"
```
#### 4.类型转换
任意基本类型或者引用类型 转换成 字符串, 特别注意,引用类型转换成什么了:
```java
String.valueOf(123); // "123"  int -> string
String.valueOf(new Object()); // 类似 java.lang.Object@636be97c
```
字符串 转 其他类型:
```java
int n1 = Integer.parseInt("123"); // 123 特别注意一个特例:
Integer.getInteger("java.version");  // 这里指的是系统变量转化成Integer
boolean b1 = Boolean.parseBoolean("TRUE"); // true
```
字符串 转 char[] 以及 char[] 转 字符串:
```java
char[] cs = "Hello".toCharArray();  // String -> char[]
String s = new String(cs);  // char[] 作为初始化参数, 并且cs是复制的,两者不会干扰
// 也能说明 不可变的String, 传入可变对象, 我们是复制一份而不是直接引用
Arrays.toString(cs);
```
## Encode编码
#### 1. ASCII GB2312 Unicode UTF-8
ASCII 一个字节; GB2312 两个字节; Unicode 2个或者更多
UTF-8 变长编码1~4个字节. 其中高字节位确定一个字符占多少字节,容错能力强, 常作传输编码.
```java
byte[] b1 = "Hello".getBytes("UTF-8");
String s1 = new String(b1, "GBK");
```
1)这里的String构造器重载机制是怎么样的?

2)Java的 String 和 char 在内存中总是以Unicode编码表示. 区别新旧版本中String内部的实现机制. 原来是char[]实现,较新的版本是byte[]实现, 这样做的意义是, String在存储ASCII是仅需要一个byte, 从而可以节省内存空间.
