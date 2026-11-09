package io.tool.tia;

/**
 * 2D坐标存储
 * double 2D Pos Container
 *
 * @author 天禄是小狗
 * @since 2026-10-30
 */
public class Dire2R extends Dire2 {

    /**
     * 对比 Dire2 多的旋转数值
     * Dire2 Extra r Data
     */
    public double r;

    /**
     * 默认的构造函数
     * Default Constructor
     * @param x 初始X值:Initial X value
     * @param y 初始Y值:Initial Y value
     * @param r 初始R值:Initial R value
     */
    public Dire2R(double x, double y, double r) {
        super(x, y);
        this.r = r;
    }

    /**
     * 增加方法
     * add Method
     * @param x 增加的X值:add x value
     * @param y 增加的Y值:add y value
     * @param r 增加的Y值:add r value
     */
    public void add(double x, double y, double r) {
        this.x += x;
        this.y += y;
        this.r = (this.r + r) % 360;
    }

    /**
     * 增加方法
     * add Method
     * @param dire2r 增加的 Dire2r : add Dire2r of pos
     * @param delta 增加的 Dire2 的倍率:add Dire2 of Magnification
     */
    public void add(Dire2R dire2r, double delta) {
        this.x += dire2r.x * delta;
        this.y += dire2r.y * delta;
    }

    /**
     * 设置方法
     * set Method
     * @param x 设置的X值:set x value
     * @param y 设置的Y值:set y value
     * @param r 设置的R值:set r value
     */
    public void set(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = (r) % 360;
    }

    /**
     * 设置方法
     * set Method
     * @param pos 设置的目标:set Data for pos of data
     */
    public void set(Dire2R pos) {
        this.x = pos.x;
        this.y = pos.y;
        this.r = pos.r;
    }
}
