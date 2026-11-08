/**
 * XYZ float 存储
 * XYZ float Container
 *
 * @author 天禄是小狗
 * @since 2026-11-08
 */

package io.tool;

public class Dire3F {

    public float x, y, z;

    public Dire3F(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void add(float x, float y, float z) {
        this.x += x;
        this.y += y;
    }

    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
    }
}
