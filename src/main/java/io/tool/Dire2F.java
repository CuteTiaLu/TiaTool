package io.tool;

public class Dire2F {

    public float x, y;

    public Dire2F(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float dot(Dire2F other) {
        return (this.x * other.x) + (this.y * other.y);
    }

    public float distanceTo(Dire2F other) {
        float xt = x - other.x, yt = y - other.y;
        return (float) Math.sqrt((xt * xt) + (yt * yt));
    }
}
