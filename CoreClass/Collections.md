[参考demo](https://github.com/ShuaiMou/java_SE/tree/master/src/main/java/cn/saul/collections)
## 1、集合框架的概述
### 1.1  作用
- 在实际开发中，我们经常会对一组相同类型的数据进行统一管理操作。到目前为止，我们可以使用数组结构，链表结构，二叉树结构来实现。
- 数组的最大问题在于数组中的元素个数是固定的，要实现动态数组，必竟还是比较麻烦，自己实现链表或二叉树结构来管理对象更是不方便。
- 在JDK1.2版本后，JAVA完整的提供了类集合的概念，封装了一组强大的、非常方便的集合框架API，让我们在开发中大大的提高了效率。

- 集合中分为三大接口：
Collection、Map、Iterator
集合框架的接口和类在java.util包中

### 1.2 集合框架结构图
![集合框架结构图](https://img-blog.csdnimg.cn/20190722094755841.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1NhdWxfTQ==,size_16,color_FFFFFF,t_70)
### 1.3 Collection 接口
	public interface Collection<E> extends Iterable<E>

Collection 层次结构 中的 **根接口**。Collection 表示一组对象，这些对象也称为 collection 的**元素**。一些 collection 允许有重复的元素，而另一些则不允许。一些 collection 是有序的，而另一些则是无序的。JDK 不提供此接口的任何直接 实现：它提供更具体的子接口（如 Set 和 List）实现。此接口通常用来传递 collection，并在需要最大普遍性的地方操作这些 collection。

#### 1.3.1 List 接口
	public interface List<E> extends Collection<E>

**有序**的 collection（也称为**序列**）。此接口的用户可以对列表中每个元素的插入位置进行精确地控制。用户可以根据元素的整数索引（在列表中的位置）访问元素，并搜索列表中的元素。

- 1.有序的，可以重复
- 2.允许多个null元素
- 3.具体实现有 ArrayList， Vector， LinkedList
- 4.在实际开发中，如何选择 List 的具体实现？
--  1）安全性问题（线程同步，Vector）
-- 2）是否频繁插入，删除操作（LinkedList）
-- 3）是否存储后遍历

##### 1.3.1.1 ArrayList
	public class ArrayList<E> extends AbstractList<E>
	implements List<E>, RandomAccess, Cloneable, Serializable

List 接口的**大小可变数组**的实现。实现了所有可选列表操作，并允许包括 null 在内的所有元素。除了实现 List 接口外，此类还提供一些方法来操作内部用来存储列表的数组的大小

- 1.实现原理，采用动态对象数组实现，默认构造方法创建了一个空数组。
- 2.第一次添加元素，扩展容量为10，之后的扩充算法：原来数组大小 + 原来大小一半
- 3.不适合进行删除或插入操作
- 4.为了防止数组动态扩充次数过多，建议创建ArrayList时，给定初始容量。
- 5.线程不安全，适合单线程访问时使用，效率较高。

##### 1.3.1.2 Vector
	public class Vector<E> extends AbstractList<E>
	implements List<E>, RandomAccess, Cloneable, Serializable

Vector 类可以实现可增长的对象数组。与数组一样，它包含可以使用整数索引进行访问的组件。但是，Vector 的大小可以根据需要增大或缩小，以适应创建 Vector 后进行添加或移除项的操作。

- 1.实现原理，采用动态对象数组实现，默认构造方法创建了一个大小为10的对象数组。
- 2.扩充算法： 当增量为0时，扩充为原来大小的2倍，当增量大于0时，扩充为原数组大小 + 增量
- 3.不适合删除或者插入操作。
- 4.为了防止数组动态扩充次数过多，建议创建Vector时，给定初始容量。
- 5.线程安全，适合多线程访问时使用，在单线程下使用效率较低

##### 1.3.1.3 LinkedList
	public class LinkedList<E> extends AbstractSequentialList<E>
	implements List<E>, Deque<E>, Cloneable, Serializable

List 接口的**链接列表**实现。实现所有可选的列表操作，并且允许所有元素（包括 null）。除了实现 List 接口外，LinkedList 类还为在列表的开头及结尾 get、remove 和 insert 元素提供了统一的命名方法。

- 1.实现原理，采用双向链表结构实现
- 2.适合插入，删除操作，性能高

#### 1.3.2 Set 接口
	public interface Set<E> extends Collection<E>

一个**不包含重复元素**的 collection。更确切地讲，set 不包含满足 e1.equals(e2) 的元素对 e1 和 e2，并且最多包含一个 null 元素.

- 1.无序的（不保证顺序）
- 2.不允许重复元素
- 3.具体实现有 HashSet, TreeSet, LinkedHashSet
- 4.如何选择 set 的具体实现？
--1）如果需要排序，选择 TreeSet
--2）如果不要排序，也不用保证顺序选择 HashSet
--3）如果不要排序，要保证顺序，选择 LinkedHashSet

##### 1.3.2.1 HashSet
	public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable

类实现 Set 接口，由哈希表（实际上是一个 HashMap 实例）支持。它不保证 set 的迭代顺序；特别是它不保证该顺序恒久不变。此类允许使用 null 元素。

hashcode() 方法，在object类中定义如下：

	public native int hashCode();

hashCode是本地方法，它的实现是根据本地机器相关，当然我们可以在自己写的类中覆盖hashcode()方法，比如String、Integer、Double。。。。等等这些类都是覆盖了hashcode()方法的。

在java的集合中，判断两个对象是否相等的规则是：
（1）判断两个对象的hashCode是否相等
      如果不相等，认为两个对象也不相等，结束
      如果相等，转入2
（2）判断两个对象用equals运算是否相等
      如果不相等，认为两个对象也不相等
      如果相等，认为两个对象相等
（equals()是判断两个对象是否相等的关键）

- 1.实现原理，基于哈希表（HashMap）实现
- 2.不允许重复，可以有一个NULL元素
- 3.不保证顺序恒久不变
- 4.添加元素时，把元素作为HashMap的key存储， HashMap的value使用一个固定的object对象。
- 5.排除重复元素是通过 equals 来检查对象是否相同。
- 6.判断两个对象是否相同，先判断两个对象的hashcode是否相同（如果两个对象hashcode相同，不一定是同一个对象；如果hashcode不同，肯定不是同一个对象）。如果不同，则两个对象不是同一个对象；如果相同，还要进行equals判断，equals相同则是同一个对象，不同则不是同一个对象。
- 7.自定义对象要认为属性值都相同时为同一个对象，有这种需求时，那么我们要重写对象所在类的 hashCode 和 equals 方法

##### 1.3.2.2 TreeSet
	public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable

基于 TreeMap 的 NavigableSet 实现。使用元素的自然顺序**对元素进行排序**，或者根据创建 set 时提供的 Comparator 进行排序，具体取决于使用的构造方法。

- 有序的，基于TreeMap（二叉树数据结构），对象需要比较大小，通过对象比较器来实现。对象比较器还可以用来去除重复元素，如果自定义的数据类，没有实现比较器接口，将无法添加到TreeSet集合中。

##### 1.3.2.3 LinkedHashSet
	public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable

具有可预知迭代顺序的 Set 接口的哈希表和链接列表实现。此实现与 HashSet 的不同之外在于，后者维护着一个运行于所有条目的**双重链接**列表。此链接列表定义了**迭代顺序**，即按照将元素插入到 set 中的顺序（插入顺序）进行迭代。注意，插入顺序不 受在 set 中重新插入的 元素的影响。（如果在 s.contains(e) 返回 true 后立即调用 s.add(e)，则元素 e 会被重新插入到 set s 中。）

### 1.4 Iterator 接口
#### 1.4.1 集合输出
遍历集合的方式有以下几种：
1、 **Iterator**
2、 ListIterator
3、 Enumeration
4、 **foreach**
其中Iterator的使用率最高，在JDK1.5后新增的foreach也被大量使用。

#### 1.4.2 Iterator
public interface Iterator<E>
对 collection 进行迭代的迭代器。迭代器取代了 Java Collections Framework 中的 Enumeration
|boolean hasNext()|如果仍有元素可以迭代，则返回 true。|
|--|--|
| E next() | 返回迭代的下一个元素 |
| void remove() | 从迭代器指向的 collection 中移除迭代器返回的最后一个元素。 |

```
public static void iterator(Collection<Cat> c) {
		Iterator<Cat> iterator = c.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
```

#### 1.4.3 ListIterator
public interface ListIterator<E>
extends Iterator<E>
系列表迭代器，允许程序员按任一方向遍历列表、迭代期间修改列表，并获得迭代器在列表中的当前位置。
|void add(E e)| 增加元素 |
|--|--|
| boolean hasPrevious() |判断是否有前一个元素  |
|E previous()|  取出前一个元素|
|void set(E e)|修改元素的内容|
|  int nextIndex()|下一个索引位置  |

#### 1.4.4 Enumeration
public interface Enumeration<E>
实现 Enumeration 接口的对象，它生成一系列元素，一次生成一个。连续调用 nextElement 方法将返回一系列的连续元素。
注：此接口的功能与 Iterator 接口的功能是重复的。此外，Iterator 接口添加了一个可选的移除操作，并使用较短的方法名。新的实现应该优先考虑使用 Iterator 接口而不是 Enumeration 接口。

|boolean hasMoreElements()|  判断是否有下一个元素|
|--|--|
| E nextElement() | 取出当前元素 |

```
		Vector<String> list = new Vector<String>();
		list.add("xiaolin");
		list.add("dazhuang");
		list.add("huanqiang");
		Enumeration<String> enumeration = list.elements();
		while(enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
```

#### 1.4.4 foreach
在前面的知识讲解中，我们使用foreach来输出数组的内容，那么也可以输出集合中的内容。在使用foreach输出的时候一定要注意的是，创建集合时要指定操作泛型的类型。
List<Integer> numbers = new ArrayList<>();
JDK1.8新特性：
//no.1
numbers.forEach((Integer integer) -> {System.out.println(integer);});
//no.2
numbers.forEach(integer -> {System.out.println(integer);});
//no.3
numbers.forEach(integer -> System.out.println(integer));
//no.4
numbers.forEach(System.out::println);
//no.5
numbers.forEach(new MyConsumer());

#### 1.4.5 JDK1.8新特性
- Consumer<T>接口	消费者接口 @forEach

```
 default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
```

- Function<T,R> 接口	表示接受一个参数并产生结果的函数。

```
public static void functionTest() {
		String str = toUppercaseString("xiaoxiao", new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		});
		System.out.println(str);
	}

	public static String toUppercaseString(String str, Function<String, String> f) {
		return f.apply(str);
	}
```

- Supplier<T>接口	代表结果供应商。

```
	public static void supplierTest() {
		List<Integer> list = getNums(10, ()->(int)(Math.random()*100));
		list.forEach(System.out::println);
	}

	public static List<Integer> getNums(int num, Supplier<Integer> supplier){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < num; i++) {
			list.add(supplier.get());
		}
		return list;
	}
```

- Predicate<T>接口	断言接口

```
public static void predicateTest() {
		String[] strs = {"hello", "hi","jach", "mike"};
		List<String> input = Arrays.asList(strs);
		List<String> result = test(input, (String s)->s.contains("h"));
		result.forEach(System.out::println);

	}

	public static List<String> test(List<String> list, Predicate<String> p){
		List<String> results = new ArrayList<String>();
		for (String string : list) {
			if(p.test(string))
				results.add(string);
		}
		return results;
	}
```
-  Stream
Stream是元素的集合，这点让Stream看起来用些类似Iterator；可以支持顺序和并行的对原Stream进行汇聚的操作；我们可以把Stream当成一个高级版本的Iterator。原始版本的Iterator，用户只能一个一个的遍历元素并对其执行某些操作；高级版本的Stream，用户只要给出需要对其包含的元素执行什么操作，比如“过滤掉长度大于10的字符串”、“获取每个字符串的首字母”等，具体这些操作如何应用到每个元素上，就给Stream就好了！

常见操作方法：
|    <R> Stream<R> map(Function<? super T,? extends R> mapper)| 返回由给定函数应用于此流的元素的结果组成的流。 |
|--|--|
|<R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)  | 返回由通过将提供的映射函数应用于每个元素而产生的映射流的内容来替换该流的每个元素的结果的流。 |
|  Stream<T> filter(Predicate<? super T> predicate) | 返回由与此给定谓词匹配的此流的元素组成的流 |
|  void forEach(Consumer<? super T> action) | 对此流的每个元素执行操作。   |
|  Optional<T> findFirst() | 返回描述此流的第一个元素的Optional如果流为空，则返回一个空的Optional 。 |
|Optional<T> reduce(BinaryOperator<T> accumulator)   | 使用 associative累积函数对此流的元素执行 reduction ，并返回描述减小值的 Optional （如果有）。  |
| Stream<T> peek(Consumer<? super T> action) | 返回由该流的元素组成的流，另外在从生成的流中消耗元素时对每个元素执行提供的操作。  |
|  Stream<T> sorted() |  返回由此流的元素组成的流，根据自然顺序排序。 |

```
public static void main(String[] args) {
		Stream<String> stream = Stream.of("good", "good", "study", "day", "day","up");

		//1.foreach
		//stream.forEach((String str)->{System.out.println(str);});

		//2.filter
		//stream.filter((String str)-> str.length() > 3).forEach(System.out::println);

		//3.distincct
		//stream.distinct().forEach(System.out::println);

		//4.map
		//stream.map(s->s.toUpperCase()).forEach(System.out::println);

		//5.flatMap
		//Stream<List<Integer>> ss = Stream.of(Arrays.asList(1,2,3),Arrays.asList(4,5));
		//ss.flatMap(list -> list.stream()).forEach(System.out::println);

		//6.reduce
		//Optional< String> optional = stream.reduce((s1,s2)->s1.length() > s2.length() ? s1:s2);
		//System.out.println(optional.get());

		//7.Collect

		List<String> list = stream.collect(Collectors.toList());
		list.forEach(System.out::println);
	}
```

### 1.5 Map接口
	public interface Map<K,V>

将键映射到值的对象，一个映射不能包含重复的键；每个键最多只能映射到一个值。
|void clear()  | 清空Map集合中的内容 |
|--|--|
|boolean containsKey(Object key)  |  判断集合中是否存在指定的key|
| boolean containsValue(Object value) | 判断集合中是否存在指定的value |
|Set<Map.Entry<K,V>> entrySet()|将Map接口变为Set集合|
|V get(Object key)  | 根据key找到其对应的value |
| boolean isEmpty() | 判断是否为空 |
|Set<K> keySet() | 将全部的key变为Set集合|
| Collection<V> values() |  将全部的value变为Collection集合 |
|V put(K key,V value)|向集合中增加内容|
|  void putAll(Map<? extends K,? extends V> m)| 增加一组集合 |
|  V remove(Object key)| 根据key删除内容 |

- 1.键值对存储一组对象
- 2.key不能重复（唯一），value可以重复。
- 3.具体的实现类：HashMap，TreeMap，Hashtable， LinkedHashMap
- 4.HashMap 和 Hashtable 的区别？

#### 1.5.1 HashMap
	public class HashMap<K,V> extends AbstractMap<K,V>
	implements Map<K,V>, Cloneable, Serializable

基于哈希表的 Map 接口的实现。此实现提供所有可选的映射操作，并允许使用 **null 值和 null 键**。（除了**非同步**和**允许使用 null** 之外，HashMap 类与 Hashtable 大致相同。）此类不保证映射的顺序，特别是它不保证该顺序恒久不变。

```
public static void hashMap（）{
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "xiaolin");
		map.put(2,"saul");
		map.put(3,"alex");
		map.put(4, "joey");

		//遍历key 和 value
		System.out.println("----------遍历key 和 value----------------");
		Set<Entry<Integer, String>> set = map.entrySet();
		set.forEach((entry)-> System.out.println(entry.getKey() + "->" +entry.getValue()));

		System.out.println("----------遍历key----------------");
		Set<Integer> keySet = map.keySet();
		for (Integer i : keySet) {
			System.out.println( i + "->" + map.get(i));
		}

		System.out.println("----------遍历value----------------");
		Collection<String> list = map.values();
		for (String str : list) {
			System.out.println(str);
		}

		System.out.println("----------forEach----------------");
		map.forEach((key, value) -> System.out.println(key + "->" + value));
	}
```
 * 1）基于哈希表（数组，链表，红黑树）JDK 1.8
 * 2）默认加载因子为0.75， 默认数组大小是16.
  * 3）把对象存储到哈希表中，如何存储：
	 * 	把 key 对象通过 hash() 方法计算 hash 值，然后用这个 hash 值对数组长度取余（默认16），来决定对该 key  对象在数组中对存储位置， 当这个位置有多个对象时，以链表结构存储， JDK1.8后， 当链表长度大于8时，链表将 转换为红黑树结构存储。

  * 4）  扩充原理： 当数组的容量超过来75%，那么该数组需要扩容：当前数组容量 << 1，扩大1倍。扩充次数过多会影响性能。每次扩充哈希表重新散列（重新计算每个对象的存储位置）。在实际开发中尽量要减少扩充次数
 带来的性能问题。
 *  5）线程不安全，适合在单线程中使用。

#### 1.5.2 Hashtable
	public class Hashtable<K,V> extends Dictionary<K,V>
	implements Map<K,V>, Cloneable, Serializable
此类实现一个哈希表，该哈希表将键映射到相应的值。任何**非 null 对象**都可以用作键或值。
为了成功地在哈希表中存储和获取对象，用**作键的对象必须实现 hashCode 方法和 equals 方法。**

```
		Map<String, String> table = new Hashtable<String, String>();
		table.put("one", "xialin");
		table.put("two", "saul");
		table.put("three", "xiaoqiang");
		table.forEach((key, value)->System.out.println(key + "->" + value));
```

* JDK 1.0
* 基于哈希表实现（数组，链表）
 * 默认数组大小为11， 负载因子0.75
 * 扩充方式： 原数组大小 << 1 + 1
 * 线程安全，用在多线程访问时。

#### 1.5.3 LinkedHashMap
	public class LinkedHashMap<K,V>
	extends HashMap<K,V> implements Map<K,V>
Map 接口的哈希表和链接列表实现，具有**可预知的迭代顺序**。此实现与 HashMap 的不同之处在于，后者维护着一个运行于所有条目的**双重链接列表**。

```
		Map<String, String> table = new LinkedHashMap<String, String>();
		table.put("one", "xialin");
		table.put("two", "saul");
		table.put("three", "xiaoqiang");
		table.forEach((key, value)->System.out.println(key + "->" + value));
```

 * 是hashMap的子类，由于hashMap不能保证顺序恒久不变，此类使用一个双重链表来维护元素的添加顺序。

#### 1.5.4TreeMap
	public class TreeMap<K,V> extends AbstractMap<K,V>
	implements NavigableMap<K,V>, Cloneable, Serializable
**基于红黑树**（Red-Black tree）的 NavigableMap 实现。该映射根据其键的自然顺序进行排序，或者根据创建映射时提供的 Comparator 进行排序，具体取决于使用的构造方法。

```
		Map<Cat, String> treeMap = new TreeMap<Cat, String>(new MyComparator());
		treeMap.put(new Cat("huhu", 1, 12), "cat1");
		treeMap.put(new Cat("niuniu", 2, 13), "cat2");
		treeMap.put(new Cat("jojo", 3, 14), "cat3");
		treeMap.put(new Cat("lolo", 1, 15), "cat4");
		treeMap.forEach((key, value)->System.out.println(key + "->" + value));
```

#### 1.5.5  JDK1.8 Map新特性
```
Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "xiaolin");
		map.put(2,"saul");
		map.put(3,"jojo");


//		String value = map.getOrDefault(4, "null");
//		System.out.println(value);

//		map.putIfAbsent(3, "alex");
//		map.forEach((k,v) -> System.out.println(k+ "->" + v));

//		map.compute(1, (k,v)-> v+"1");
//		map.forEach((k,v) -> System.out.println(k+ "->" + v));

		map.merge(1, "888", (oldv, newv)-> oldv.concat(newv));
		map.forEach((k,v) -> System.out.println(k+ "->" + v));
```
### 1.6 Collections 工具类
Collections类
Collections工具类提供了大量针对Collection/Map的操作，总体可分为四类，都为静态（static）方法：

#### 1.6.1 排序操作（主要针对List接口相关）
reverse(List list)：反转指定List集合中元素的顺序
shuffle(List list)：对List中的元素进行随机排序（洗牌）
sort(List list)：对List里的元素根据自然升序排序
sort(List list, Comparator c)：自定义比较器进行排序
swap(List list, int i, int j)：将指定List集合中i处元素和j出元素进行交换
rotate(List list, int distance)：将所有元素向右移位指定长度，如果distance等于size那么结果不变

#### 1.6.2. 查找和替换（主要针对Collection接口相关）
binarySearch(List list, Object key)：使用二分搜索法，以获得指定对象在List中的索引，前提是集合已经排序
max(Collection coll)：返回最大元素
max(Collection coll, Comparator comp)：根据自定义比较器，返回最大元素
min(Collection coll)：返回最小元素
min(Collection coll, Comparator comp)：根据自定义比较器，返回最小元素
fill(List list, Object obj)：使用指定对象填充
frequency(Collection Coll, Object o)：返回指定集合中指定对象出现的次数
replaceAll(List list, Object old, Object new)：替换
#### 1.6.3. 同步控制
Collections工具类中提供了多个synchronizedXxx方法，该方法返回指定集合对象对应的同步对象，从而解决多线程并发访问集合时线程的安全问题。HashSet、ArrayList、HashMap都是线程不安全的，如果需要考虑同步，则使用这些方法。这些方法主要有：synchronizedSet、synchronizedSortedSet、synchronizedList、synchronizedMap、synchronizedSortedMap。

特别需要指出的是，**在使用迭代方法遍历集合时需要手工同步返回的集合。**
#### 1.6.4. 设置不可变集合
Collections有三类方法可返回一个不可变集合：
emptyXxx()：返回一个空的不可变的集合对象(可以用来预防空指针)
singletonXxx()：返回一个只包含指定对象的，不可变的集合对象。
unmodifiableXxx()：返回指定集合对象的不可变视图
#### 1.6.5. 其它
disjoint(Collection<?> c1, Collection<?> c2) - 如果两个指定 collection 中没有相同的元素，则返回 true。
addAll(Collection<? super T> c, T... a) - 一种方便的方式，将所有指定元素添加到指定 collection 中。
Comparator<T> reverseOrder(Comparator<T> cmp) - 返回一个比较器，它强行反转指定比较器的顺序。如果指定比较器为 null，则此方法等同于 reverseOrder()（换句话说，它返回一个比较器，该比较器将强行反转实现 Comparable 接口那些对象 collection 上的自然顺序）。
