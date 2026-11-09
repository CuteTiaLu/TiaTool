package io.tool.tia;

/**
 * 3D位置存储
 * 3D Pos Container
 *
 * @author 天禄是小狗
 * @since 2026-10-30
 */
public class Dire3R extends Dire3 {

    /**
     * 对比 Dire3 多的旋转数值
     * Dire3 Extra r Data
     */
    public double xr, yr, zr;

    /**
     * 默认的构造函数
     * Default Constructor
     * @param x 初始X值:Initial X value
     * @param y 初始Y值:Initial Y value
     * @param z 初始Y值:Initial Z value
     * @param xr 初始XR值:Initial XR value
     * @param yr 初始YR值:Initial YR value
     * @param zr 初始YR值:Initial ZR value
     */
    public Dire3R(double x, double y, double z, double xr, double yr, double zr) {
        super(x, y, z);
        this.xr = xr;
        this.yr = yr;
        this.zr = zr;
    }

    /**
     * 没有旋转的构造函数
     * not Rotate of Constructor
     * @param x 初始X值:Initial X value
     * @param y 初始Y值:Initial Y value
     * @param z 初始Y值:Initial Z value
     */
    public Dire3R(double x, double y, double z) {
        this(x, y, z, 0.0, 0.0, 0.0);
    }

    /**
     * 增加方法
     * add Method
     * @param x 增加的X值:add x value
     * @param y 增加的Y值:add y value
     * @param z 增加的Y值:add z value
     * @param xr 增加的XR值:add XR value
     * @param yr 增加的YR值:add YR value
     * @param zr 增加的YR值:add ZR value
     */
    public void add(double x, double y, double z, double xr, double yr, double zr) {
        super.add(x, y, z);
        this.xr = (this.xr + xr) % 360;
        this.yr = (this.yr + yr) % 360;
        this.zr = (this.zr + zr) % 360;
    }

    /**
     * 设置方法
     * set Method
     * @param x 设置的X值:set x value
     * @param y 设置的Y值:set y value
     * @param z 设置的Y值:set z value
     * @param xr 设置的XR值:set XR value
     * @param yr 设置的YR值:set YR value
     * @param zr 设置的YR值:set ZR value
     */
    public void set(double x, double y, double z, double xr, double yr, double zr) {
        super.set(x, y, z);
        this.xr = xr % 360;
        this.yr = yr % 360;
        this.zr = zr % 360;
    }
}
