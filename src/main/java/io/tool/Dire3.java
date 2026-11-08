package io.tool;

/**
 * 3D坐标存储
 *
 * @author 天禄是小狗
 * @since 2026-10-30
 */

public class Dire3 {

    public double x, y, z;

    public Dire3(double x, double y, double z) {
    }

    public void add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }

    public void set(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

}
