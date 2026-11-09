package io.tool.tia;

/**
 * 浮点数XY存储
 * XY float Container
 *
 * @author 天禄是小狗
 * @since 2026-11-8
 */
public class Dire2F {

    /**
     * 存储的XY数据
     * Storage of XY Data
     */
    public float x, y;

    /**
     * 默认的构造函数
     * Default Constructor
     * @param x 初始X值:Initial X value
     * @param y 初始Y值:Initial Y value
     */
    public Dire2F(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 增加方法
     * add Method
     * @param x 增加的X值:add x value
     * @param y 增加的Y值:add y value
     */
    public void add(float x, float y) {
        this.x += x;
        this.y += y;
    }

    /**
     * 增加方法
     * add Method
     * @param dire2f 增加的 Dire2 :add Dire2
     * @param delta 增加的 Dire2 的倍率:add Dire2 of Magnification
     */
    public void add(Dire2F dire2f, float delta) {
        this.x += dire2f.x * delta;
        this.y += dire2f.y * delta;
    }

    /**
     * 增加方法
     * add Method
     * @param dire2f 增加的 Dire2 :add Dire2
     */
    public void add(Dire2F dire2f) {
        this.x += dire2f.x;
        this.y += dire2f.y;
    }

    /**
     * 设置方法
     * set Method
     * @param x 设置的X值:set x value
     * @param y 设置的Y值:set y value
     */
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
