package io.tool.tia;

/**
 * XY double 容器
 * XY double Container
 *
 * @author 天禄是小狗
 * @since 2026-10-30
 */
public class Dire2 {

    /**
     * 存储的XY数据
     * Storage of XY Data
     */
    public double x, y;

    /**
     * 默认的构造函数
     * Default Constructor
     * @param x 初始X值:Initial X value
     * @param y 初始Y值:Initial Y value
     */
    public Dire2(double x, double y) {
        set(x, y);
    }

    /**
     * 增加方法
     * add Method
     * @param x 增加的X值:add x value
     * @param y 增加的Y值:add y value
     */
    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    /**
     * 增加方法
     * add Method
     * @param dire2 增加的 Dire2 :add Dire2
     * @param delta 增加的 Dire2 的倍率:add Dire2 of Magnification
     */
    public void add(Dire2 dire2, double delta) {
        this.x += dire2.x * delta;
        this.y += dire2.y * delta;
    }

    /**
     * 增加方法
     * add Method
     * @param dire2 增加的 Dire2 :add Dire2
     */
    public void add(Dire2 dire2) {
        this.x += dire2.x;
        this.y += dire2.y;
    }

    /**
     * 设置方法
     * set Method
     * @param x 设置的X值:set x value
     * @param y 设置的Y值:set y value
     */
    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 设置方法
     * set Method
     * @param dire2 设置的目标:set Data for dire2 of data
     */
    public void set(Dire2 dire2) {
        this.x = dire2.x;
        this.y = dire2.y;
    }
}
