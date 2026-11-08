package io.tool;

public class Dire2R extends Dire2 {

    public double r;

    public Dire2R(double x, double y, double r) {
        super(x, y);
        this.r = r;
    }

    public void add(double x, double y, double r) {
        this.x += x;
        this.y += y;
        this.r = (this.r + r) % 360;
    }

    public void set(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = (r) % 360;
    }

    public void set(Dire2R pos) {
        this.x = pos.x;
        this.y = pos.y;
        this.r = pos.r;
    }

    public void stack(Dire2R parent, Dire2R result) {
        double cos = TiaMath.Function.cos_Fast(parent.r);
        double sin = TiaMath.Function.sin_Fast(parent.r);

        double newX = this.x * cos - this.y * sin;
        double newY = this.x * sin + this.y * cos;

        result.x = parent.x + newX;
        result.y = parent.y + newY;

        result.r = (this.r + parent.r) % 360;
    }

    public Dire2R stack(Dire2R parent) {
        double cos = TiaMath.Function.cos_Fast(parent.r);
        double sin = TiaMath.Function.sin_Fast(parent.r);

        double newX = this.x * cos - this.y * sin;
        double newY = this.x * sin + this.y * cos;

        return new Dire2R(parent.x + newX, parent.y + newY, (this.r + parent.r) % 360);
    }

    public void stack_High(Dire2R parent, Dire2R result) {
        double rad = Math.toRadians(parent.r);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        double newX = this.x * cos - this.y * sin;
        double newY = this.x * sin + this.y * cos;

        result.x = parent.x + newX;
        result.y = parent.y + newY;

        result.r = (this.r + parent.r) % 360;
    }

    public Dire2R stack_High(Dire2R parent) {
        double rad = Math.toRadians(parent.r);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        double newX = this.x * cos - this.y * sin;
        double newY = this.x * sin + this.y * cos;

        return new Dire2R(parent.x + newX, parent.y + newY, (this.r + parent.r) % 360);
    }
}
