/**
 * XY double 存储
 * XY double Container
 *
 * @author 天禄是小狗
 * @since 2026-10-30
 */

package io.tool.tia;

public class Dire2 {

    public double x, y;

    public Dire2(double x, double y) {
        addD2(x, y);
    }

    private void addD2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void add(Dire2 dire2, double delta) {
        this.x += dire2.x * delta;
        this.y += dire2.y * delta;
    }

    public void add(Dire2 dire2) {
        this.x += dire2.x;
        this.y += dire2.y;
    }

    public double dot(Dire2 other) {
        return (this.x * other.x) + (this.y * other.y);
    }

    public double distanceTo(Dire2 other) {
        double xt = x - other.x, yt = y - other.y;
        return Math.sqrt((xt * xt) + (yt * yt));
    }
}
