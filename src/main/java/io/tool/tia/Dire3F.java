package io.tool.tia;

/**
 * XYZ float 存储
 * XYZ float Container
 *
 * @author 天禄是小狗
 * @since 2026-11-08
 */
public class Dire3F {

    /**
     * 存储的XYZ数据
     * Storage of XYZ Data
     */
    public float x, y, z;

    /**
     * 默认的构造函数
     * Default Constructor
     * @param x 初始X值:Initial X value
     * @param y 初始Y值:Initial Y value
     * @param z 初始Y值:Initial Z value
     */
    public Dire3F(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * 增加方法
     * add Method
     * @param x 增加的X值:add x value
     * @param y 增加的Y值:add y value
     * @param z 增加的Y值:add z value
     */
    public void add(float x, float y, float z) {
        this.x += x;
        this.y += y;
    }

    /**
     * 设置方法
     * set Method
     * @param x 设置的X值:set x value
     * @param y 设置的Y值:set y value
     * @param z 设置的Y值:set z value
     */
    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
    }
}
