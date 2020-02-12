# Boxing and Deboxing
## 装箱和拆箱--类型的包装

#### 1. 引用类型可以null, 基本类型不可以.
#### 2. 自动装/拆箱发生在编译阶段, 因为会影响效率, 所以在编译后, 就已经严格区分类型了. 还是尽量不要写混淆的代码.
#### 3. 创建对象时, 优先选用静态工厂方法而不是new 操作符. 为什么?
```java
Integer n = new Integer(100);
Integer n = Integer.valueOf(100);
```
优先选择后者的意义在于,减少新实例的创建, Integer内部可能存在优化机制, 尽可能返回缓存的实例, 从而节省内存.
```java
@source
public static Byte valueOf(byte b) {
        final int offset = 128;
        return ByteCache.cache[(int)b + offset];
}
```
#### 4. Integer, Double 这些类自带格式化转字符串的函数.
这里体现了程序设计的一个重要原则: 数据的存储和显示是要分离的.
#### 5. 善于利用包装类型自带的静态字段
```java
// boolean只有两个值true/false，其包装类型只需要引用Boolean提供的静态字段:
Boolean t = Boolean.TRUE;
Boolean f = Boolean.FALSE;
// int可表示的最大/最小值:
int max = Integer.MAX_VALUE; // 2147483647
int min = Integer.MIN_VALUE; // -2147483648
// long类型占用的bit和byte数量:
int sizeOfLong = Long.SIZE; // 64 (bits)
int bytesOfLong = Long.BYTES; // 8 (bytes)
```
#### 6. java 是怎么处理无符号类型的?
借助包装类型的静态方法, 将低级类型向高级转, emmmm扩大范围就涵盖了.
