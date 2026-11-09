package io.tool.tia;

/**
 * XY整数存储
 * XY int Container
 *
 * @author 天禄是小狗
 * @since 2026-10-30
 */
public class Dire2I {

    /**
     * XY数据
     * XY Data
     */
    public int x, y;

    /**
     * 默认的构造函数
     * Default Constructor
     * @param x 初始X值:Initial X value
     * @param y 初始Y值:Initial Y value
     */
    public Dire2I(int x, int y) {
        set(x, y);
    }

    /**
     * 增加方法
     * add Method
     * @param x 增加的X值:add x value
     * @param y 增加的Y值:add y value
     */
    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    /**
     * 增加方法
     * add Method
     * @param dire2 增加的 Dire2 :add Dire2
     */
    public void add(Dire2I dire2) {
        this.x += dire2.x;
        this.y += dire2.y;
    }

    /**
     * 设置方法
     * set Method
     * @param x 设置的X值:set x value
     * @param y 设置的Y值:set y value
     */
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
