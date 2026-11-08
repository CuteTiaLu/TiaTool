package io.tool;

/**
 * 运行接口(io.tool.RunInt)
 * <p>
 * 功能是对所有有
 * 渲染和单次更新要求的类的接口
 * 作为通用方法接口
 * 一旦实现就默认实现的类是可以运行的
 * @author 天禄是小狗
 * @since 2026-10-31
 */

public interface RunInt {
    /**
     * 渲染使用的函数
     * 所有的渲染指令都放这里
     * 并且这里只能主线程运行
     */
    void _draw();

    /**
     * 更新使用的函数
     * 所有非渲染指令都放这里
     * 可以放在其他线程运行
     * @param delta 时间步长
     */
    void _update(double delta);
}
