package io.tool.tia;

/**
 * 运行列表类
 * Run-List
 * <p>
 * 专门用来运行节点或者其他的东西的特殊列表
 * Run Obj(T) extends RunInt List class
 * 对比 列表类 增加了更多对实现 RunInt 接口的对象的运行
 * ContrastTiaList addRunInt on Run
 * 但是因为是专门为 RunInt 接口制作所以只支持实现 RunInt 的对象
 * but class is RunInt List so No (!extends RunInt)
 *
 * @param <T> 类型:Type
 *
 * @author 天禄是小狗
 * @since 2026-10-31
 */
public class RunList<T extends RunInt> extends TiaList<T> implements RunInt {

    /**
     * 根据 size 创建初始大小为 size 的列表
     * by var size new lists on length
     * @param size 初始大小:lists.length
     */
    public RunList(int size) {
        super(size);
    }

    /**
     * 默认的构造函数
     * Default Constructor
     * 创建一个大小为 defaultSize 的空列表
     * new var defaultSize of List
     */
    public RunList() {
        super();
    }

    /**
     * 复制传入的列表而不是引用
     * copy param tiaList
     * @param tiaList 传入的列表:byCopyList
     */
    public RunList(TiaList<T> tiaList) {
        super(tiaList);
    }

    /**
     * 渲染函数
     * draw func
     */
    @SuppressWarnings("unchecked")
    @Override
    public void _draw() {
        int size = this.size();
        T[] t = (T[]) lists;
        for (int i = 0; i < size; i++) {
            t[i]._draw();
            drawHook(t[i]);
        }
    }

    /**
     * 更新函数
     * update func
     *
     * @param delta 增量时间:deltaTime
     */
    @SuppressWarnings("unchecked")
    @Override
    public void _update(double delta) {
        int size = this.size();
        T[] t = (T[]) lists;
        for (int i = 0; i < size; i++) {
            t[i]._update(delta);
            updHook(t[i], delta);
        }
    }

    /**
     * 渲染回调
     * drawHook
     * 每一个对象渲染时的回调
     * Each Obj Run draw when Run
     * @param run 对象:draw of Obj
     */
    public void drawHook(T run) {}

    /**
     * 更新回调
     * updateHook
     * 每一个对象更新时的回调
     * Each Obj Run update when Run
     * @param run 对象
     * @param delta 时间
     */
    public void updHook(T run, double delta) {}
}
