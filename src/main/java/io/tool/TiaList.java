/**
 * 列表类
 * <p>
 * 一个通过游标和swap-remove管理内部数组的列表类
 * 他不会保持排序
 * 用不智能的方式管理一个列表
 * 可以添加或者删除之类的
 * <p>
 * 不建议自己编写各种方法的原理
 * 除非确认你有能力或者需要
 * 否则一般情况下不用管
 * <p>
 * PS: java的缓存命中率是个灾难
 *
 * @author 天禄是小狗
 * @since 2026-10-31
 */

package io.tool;

import java.util.Arrays;

public class TiaList<T> {

    /**
     * 存储对象的数组
     * 所有管理的对象都存储在这里
     */
    protected Object[] lists;

    /**
     * 列表大小
     * 这是是一个方便操作的游标
     * 是一整个列表操作中可以高效的运行的核心
     */
    protected int size;

    /**
     * 默认的数组大小
     */
    protected static final int defaultSize = 50;

    /**
     * 根据 size 创建初始大小为 size 的列表
     * @param size 初始大小
     */
    public TiaList(int size) {
        lists = new Object[size];
        this.size = 0;
    }

    /**
     * 默认的构造函数
     * 创建一个大小为 defaultSize 的空列表
     */
    public TiaList() {
        lists = new Object[defaultSize];
        this.size = 0;
    }

    /**
     * 复制传入的列表而不是引用
     * @param tiaList 传入的列表
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
     * 但是不能传null进去
     * 没有检测
     *
     * @param awa 增加的对象
     * @return 添加的对象的索引
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
     * 但是不能传null进去
     * 没有检测
     *
     * @param awa 增加的数组
     */
    public void add(T[] awa) {
        if (awa == null) throw new NullPointerException("add is null");
        for (T aw : awa) {
            add(aw);
        }
    }

    /**
     * 删除 index 位置的节点并且把最后一个放上去
     *
     * @param index 删除对象的索引
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
     * 本质上是把 size 设置为 0
     * 让你无法访问到被清理的数据
     * 所以不用担心
     * 他和列表全部删除是相同的
     * @return 输出清理之前的大小
     */
    public int clear() {
        int s = size;
        size = 0;
        return s;
    }

    /**
     * 和clear清理方法差不多但是会在内部列表中彻底清理
     * @return 输出清理之前的大小
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
     * 这个方法不能调用
     * 使用方式是使用匿名构造函数或者子类来重写
     *
     * @param awa 增加的对象
     * @param index 索引
     */
    protected void addHook(T awa, int index) {}

    /**
     * remove钩子方法
     * 这个方法不能调用
     * 使用方式是使用匿名构造函数或者子类来重写
     *
     * @param awa 删除的对象
     * @param index 索引
     */
    protected void removeHook(T awa, int index) {}

    /**
     * change钩子方法
     * 在任意一个对象被移动时调用
     * 使用方式是使用匿名构造函数或者子类来重写
     *
     * @param awa 移动位置的对象
     * @param index 用来位置的索引
     * @param destination 对象会被移动到的位置的索引
     */
    protected void changeHook(T awa, int index, int destination) {}

    /**
     * 容量修改函数
     * 不建议修改
     *
     * @param v 扩容目标容量
     */
    protected void setSize(int v) {
        int s = Math.max(size, v);
        Object[] t = new Object[s];
        System.arraycopy(lists, 0, t, 0, Math.min(lists.length, s));
        lists = t;
    }

    /**
     * 类似增强for循环的函数
     * 功能是一个for循环内部的所有东西
     * 设计上的缺陷导致不适合遍历时增删
     * 如果遍历时增删可能需要下一次遍历才能应用
     *
     * @param run 遍历时执行的函数
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
     * 功能是遍历
     * <p>
     * 设计上的缺陷导致不适合遍历时增删
     * 如果遍历时增删可能需要下一次遍历才能应用
     * <p>
     * 中断时返回中断时的对象
     * 没中断时返回null
     *
     * @param run 遍历时执行的函数并且通过返回值决定是否中断
     * @return 如果中断那么返回 run 运行的对象
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
     * 如果超出大小那么就是最后一个对象
     * 注意他并不会复制然后传出
     * 如果内部没有对象而会返回 null
     *
     * @param index 目标位置的索引
     * @return 获取的对象
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (this.size <= 0) return null;
        return (T) lists[Math.clamp(index, 0, this.size - 1)];
    }

    /**
     * 获取其中的一部分对象
     * <p>
     * 会把 index 到 index + length 的部分
     * 打包成一个对象数组并输出
     *
     * @param index 启始索引
     * @param length 长度
     * @return 输出的数组
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
     *
     * @param tiaList 传入的列表
     */
    public void copy(TiaList<T> tiaList) {
        if (tiaList.size <= 0) return;
        this.lists = new Object[tiaList.size];
        System.arraycopy(tiaList.lists, 0, this.lists, 0, tiaList.size);
        this.size = tiaList.size;
    }

    /**
     * 复制传入的数组的所有内容到自己
     * 并获取 size
     *
     * @param list 传入的数组
     */
    public void copy(T[] list) {
        if (list.length == 0) return;
        this.lists = new Object[list.length];
        System.arraycopy(list, 0, this.lists, 0, list.length);
        this.size = 0;
        for (T i : list) if (i != null) this.size++;
    }

    /**
     * 返回列表的大小
     * 列表的大小和内部对象的数量是一样的
     *
     * @return 列表大小
     */
    public int size() {
        return size;
    }

    /**
     * 返回列表
     *
     * @return 列表
     */
    @SuppressWarnings("unchecked")
    public T[] getList() {
        return (T[]) Arrays.copyOf(this.lists, this.size);
    }
}