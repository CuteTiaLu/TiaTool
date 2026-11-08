package io.tool; /**
 * 2D坐标存储
 *
 * @author 天禄是小狗
 * @since 2026-10-30
 */

public class Dire2I {

    public int x, y;

    public Dire2I(int x, int y) {
        addD2(x, y);
    }

    private void addD2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Dire2I dire2, int delta) {
        this.x += dire2.x * delta;
        this.y += dire2.y * delta;
    }

    public void add(Dire2I dire2) {
        this.x += dire2.x;
        this.y += dire2.y;
    }
}
