/**
 * 运行列表类
 * Run-List
 * <p>
 * 专门用来运行节点或者其他的东西的特殊列表
 * Run Obj(<T>) extends RunInt List class
 * 对比 列表类 增加了更多对实现 RunInt 接口的对象的运行
 * ContrastTiaList addRunInt on Run
 * 但是因为是专门为 RunInt 接口制作所以只支持实现 RunInt 的对象
 * but class is RunInt List so No (!extends RunInt)
 *
 * @author 天禄是小狗
 * @since 2026-10-31
 */

package io.tool.tia;

public class RunList<T extends RunInt> extends TiaList<T> implements RunInt {

    /**
     * 渲染函数
     * draw func
     */
    @SuppressWarnings("unchecked")
    @Override
    public void _draw() {
        for (int i = 0; i < size; i++) {
            T t = (T) lists[i];
            t._draw();
            drawHook(t);
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
        for (int i = 0; i < size; i++) {
            T t = (T) lists[i];
            t._update(delta);
            updHook(t, delta);
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
