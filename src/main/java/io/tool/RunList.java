/**
 * 运行列表类
 * <p>
 * 专门用来运行节点或者其他的东西的特殊列表
 * 对比 列表类 增加了更多对实现 io.tool.RunInt 接口的对象的运行
 * 但是因为是专门为 io.tool.RunInt 接口制作所以只支持实现 io.tool.RunInt 的对象
 *
 * @author 天禄是小狗
 * @since 2026-10-31
 */

package io.tool;

public class RunList<T extends RunInt> extends TiaList<T> implements RunInt {

    /**
     * 根据 size 创建初始大小为 size 的列表
     * @param size 初始大小
     */
    public RunList(int size) {
        super(size);
    }

    /**
     * 默认的构造函数
     * 创建一个大小为 defaultSize 的列表
     */
    public RunList() {
        super();
    }

    /**
     * 复制传入的列表而不是引用
     * @param tiaList 要复制的列表
     */
    public RunList(TiaList<T> tiaList) {
        super(tiaList);
    }

    @Override
    public void _draw() {
        forEach((r) -> {
            r._draw();
            drawHook(r);
        });
    }

    @Override
    public void _update(double delta) {
        forEach((r) -> {
            r._update(delta);
            updHook(r, delta);
        });
    }

    /**
     * 渲染回调
     * 每一个对象渲染时的回调
     * @param run 对象
     */
    public void drawHook(T run) {}

    /**
     * 更新回调
     * 每一个对象运行时的回调
     * @param run 对象
     * @param delta 时间
     */
    public void updHook(T run, double delta) {}
}
