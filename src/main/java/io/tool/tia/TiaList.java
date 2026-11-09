package io.tool.tia;

import java.util.Arrays;

/**
 * 列表类
 * List-Container
 * <p>
 * 一个通过游标和swap-remove管理内部数组的列表类
 * by Cursor and swap-remove Management List
 * 他不会保持排序
 * Disorderly
 * 用不智能的方式管理一个列表
 * by No Smart(AI) Management List
 * 可以添加或者删除之类的
 * yes add or remove
 * <p>
 * 不建议自己编写各种方法的原理
 * Override may cause bug
 * 除非确认你有能力或者需要
 * but if you yes @Override
 * Let's go
 * 一般不用管
 * <p>
 * PS: java的缓存命中率是个灾难
 * PS: Java's cache hit rate is a disaster.
 *
 * @param <T> 类型:Type
 *
 * @author 天禄是小狗
 * @since 2026-10-31
 */
public class TiaList<T> {

    /**
     * 存储对象的数组
     * ObjContainerArray
     * 所有管理的对象都存储在这里
     * each Obj Management
     */
    protected Object[] lists;

    /**
     * 列表大小
     * ListSize
     * 这是是一个方便操作的游标
     * is Cursor
     * 是一整个列表操作中可以高效的运行的核心
     * Core
     */
    protected int size;

    /**
     * 默认的数组大小
     * Default lists length
     */
    protected static final int defaultSize = 50;

    /**
     * 根据 size 创建初始大小为 size 的列表
     * by var size new lists on length
     * @param size 初始大小:lists.length
     */
    public TiaList(int size) {
        lists = new Object[size];
        this.size = 0;
    }

    /**
     * 默认的构造函数
     * Default Constructor
     * 创建一个大小为 defaultSize 的空列表
     * new var defaultSize of List
     */
    public TiaList() {
        lists = new Object[defaultSize];
        this.size = 0;
    }

    /**
     * 复制传入的列表而不是引用
     * copy param tiaList
     * @param tiaList 传入的列表:byCopyList
     */
    public TiaList(TiaList<T> tiaList) {
        this();
        if (tiaList.size > 0) {
            this.lists = new Object[tiaList.size];
            System.arraycopy(tiaList.lists, 0, this.lists, 0, tiaList.size);
            this.size = tiaList.size;
        }
    }

    /**
     * 在最后面增加一个对象并返回添加位置的索引
     * The last one add Obj param awa
     * 但是不能传null进去
     * no null
     *
     * @param awa 增加的对象:addObj
     * @return 添加的对象的索引:addObj of index
     */
    public int add(T awa) {
        if (awa == null) throw new NullPointerException("add is null");
        if (size >= lists.length) {
            setSize(size + 623);
        }
        lists[size] = null;
        addHook(awa, size);
        lists[size++] = awa;
        return size - 1;
    }

    /**
     * 在最后面增加一个数组
     * The last one add ObjArray
     * 但是不能传null进去
     * no null
     *
     * @param awa 增加的数组:add ObjArray
     */
    public void add(T[] awa) {
        if (awa == null) throw new NullPointerException("add is null");
        for (T aw : awa) {
            add(aw);
        }
    }

    /**
     * 删除 index 位置的节点并且把最后一个放上去
     * remove pos is index of Obj
     *
     * @param index 删除对象的索引:remove Obj index
     */
    @SuppressWarnings("unchecked")
    public void remove(int index) {
        if (size <= 0 || index < 0 || index >= size) return;
        removeHook((T) lists[index], index);
        int last = --size;
        if (index == last) {
            lists[last] = null;
            return;
        }
        lists[index] = lists[last];
        changeHook((T) lists[index], last, index);
        lists[last] = null;
    }

    /**
     * 清理一整个列表
     * clear List
     * 本质上是把 size 设置为 0
     * is size is 0
     * 让你无法访问到被清理的数据
     * no get ClearData
     * 所以不用担心
     * not worry
     *
     * @return 清理之前的大小:clear Before of size
     */
    public int clear() {
        int s = size;
        size = 0;
        return s;
    }

    /**
     * 和clear清理方法差不多但是会在内部列表中彻底清理
     * thoroughly clear Data
     *
     * @return 清理之前的大小:clear Before of size
     */
    public int thoClear() {
        int s = size;
        for (int i = 0; i < s; i++) {
            lists[i] = null;
        }
        size = 0;
        return s;
    }

    /**
     * add钩子方法
     * addHook
     * 这个方法不能调用
     * no Call
     * 使用方式是使用匿名构造函数或者子类来重写
     * by @Override
     *
     * @param awa 增加的对象:addObj
     * @param index 索引:index(Is it necessary?, Translated by a translator.)
     */
    protected void addHook(T awa, int index) {}

    /**
     * remove钩子方法
     * removeHook
     * 这个方法不能调用
     * no Call
     * 使用方式是使用匿名构造函数或者子类来重写
     * by @Override
     *
     * @param awa 删除的对象:removeObj
     * @param index 索引:index(Is it necessary?*2)
     */
    protected void removeHook(T awa, int index) {}

    /**
     * change钩子方法
     * changeHook
     * 在任意一个对象被移动时调用
     * each Move Call
     * 使用方式是使用匿名构造函数或者子类来重写
     * by @Override
     *
     * @param awa 移动位置的对象:Move of Obj
     * @param index 原来位置的索引:old pos index
     * @param destination 对象会被移动到的位置的索引:Goal pos index
     */
    protected void changeHook(T awa, int index, int destination) {}

    /**
     * 容量修改函数
     * setSize
     * 不建议修改
     * no @Override
     *
     * @param v 扩容目标容量:GoalSize
     */
    protected void setSize(int v) {
        int s = Math.max(size, v);
        Object[] t = new Object[s];
        System.arraycopy(lists, 0, t, 0, Math.min(lists.length, s));
        lists = t;
    }

    /**
     * 类似增强for循环的函数
     * similar For-each loop func
     * 功能是一个for循环内部的所有东西
     * Almost For-each loop
     * 设计上的缺陷导致不适合遍历时增删
     * Design flaws make it unsuitable for adding or removing elements while iterating
     * 如果遍历时增删可能需要下一次遍历才能应用
     * If you add or remove items while iterating, it might only take effect on the next iteration.
     *
     * @param run 遍历时执行的函数:Run of func
     */
    @SuppressWarnings("unchecked")
    public void forEach(Run<T> run) {
        if (run == null) throw new NullPointerException("For-Run is null");
        for (int i = 0; i < size; i++) {
            run.run((T) lists[i]);
        }
    }

    /**
     * 类似增强for循环的函数
     * similar For-each loop func
     * 功能是遍历
     * Almost For-each loop
     * <p>
     * 设计上的缺陷导致不适合遍历时增删
     * Design flaws make it unsuitable for adding or removing elements while iterating
     * 如果遍历时增删可能需要下一次遍历才能应用
     * If you add or remove items while iterating, it might only take effect on the next iteration.
     * <p>
     * 中断时返回中断时的对象
     * Return the object at the time of interruption
     * 没中断时返回null
     * Returns null when not interrupted
     *
     * @param run 遍历时执行的函数并且通过返回值决定是否中断:Run of func return if != null Interrupt
     * @return 如果中断那么返回 run 运行的对象:Interrupt when Obj
     */
    @SuppressWarnings("unchecked")
    public T forEach(RunIF<T> run) {
        if (run == null) throw new NullPointerException("For-RunIF is null");
        for (int i = 0; i < size; i++) {
            T l = (T) lists[i];
            if (run.run(l)) return l;
        }
        return null;
    }

    /**
     * 获取 index 位置的对象
     * get param index Obj
     * 如果超出大小那么就是最后一个对象
     * if param index > size return The last one Obj
     * 注意他并不会复制然后传出
     * not copy Obj return
     * 如果内部没有对象而会返回 null
     * not Obj return null
     *
     * @param index 获取目标的索引:index(Is it necessary?*3)
     * @return 获取的对象:getObj
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (this.size <= 0) return null;
        return (T) lists[Math.clamp(index, 0, this.size - 1)];
    }

    /**
     * 获取其中的一部分对象
     * get index to index + length array
     * <p>
     * 会把 index 到 index + length 的部分
     * by index to index + length Package
     * 打包成一个对象数组并输出
     * Package into an array of objects and output
     *
     * @param index 启始索引:index(Is it necessary?*4)
     * @param length 长度:length
     * @return 输出的数组:return Array
     */
    @SuppressWarnings("unchecked")
    public T[] get(int index, int length) {
        if (this.size <= 0) return null;
        Object[] t = new Object[length];
        System.arraycopy(lists, index, t, 0, length);
        return (T[]) t;
    }

    /**
     * 复制传入的列表的所有内容到自己
     * copy param tiaList Data
     *
     * @param tiaList 传入的列表:copy goal
     */
    public void copy(TiaList<T> tiaList) {
        if (tiaList.size <= 0) return;
        this.lists = new Object[tiaList.size];
        System.arraycopy(tiaList.lists, 0, this.lists, 0, tiaList.size);
        this.size = tiaList.size;
    }

    /**
     * 复制传入的数组的所有内容到自己并获取 size
     * copy param array and get size
     *
     * @param array 传入的数组:copy goal
     */
    public void copy(T[] array) {
        if (array.length == 0) return;
        this.lists = new Object[array.length];
        System.arraycopy(array, 0, this.lists, 0, array.length);
        this.size = 0;
        for (T i : array) if (i != null) this.size++;
    }

    /**
     * 返回列表的大小
     * return List size
     * 列表的大小和内部对象的数量是一样的
     * size is ObjQuantity
     *
     * @return 列表大小:ListSize
     */
    public int size() {
        return size;
    }

    /**
     * 返回列表
     * return List of Data Array
     *
     * @return 列表:Data Array
     */
    @SuppressWarnings("unchecked")
    public T[] getList() {
        return (T[]) Arrays.copyOf(this.lists, this.size);
    }
}