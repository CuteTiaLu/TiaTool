package io.tool;

public class Dire3R extends Dire3 {

    public double xr, yr, zr;

    public Dire3R(double x, double y, double z, double xr, double yr, double zr) {
        super(x, y, z);
        this.xr = xr;
        this.yr = yr;
        this.zr = zr;
    }

    public Dire3R(double x, double y, double z) {
        this(x, y, z, 0.0, 0.0, 0.0);
    }

    public void add(double x, double y, double z, double xr, double yr, double zr) {
        super.add(x, y, z);
        this.xr = (this.xr + xr) % 360;
        this.yr = (this.yr + yr) % 360;
        this.zr = (this.zr + zr) % 360;
    }

    public void set(double x, double y, double z, double xr, double yr, double zr) {
        super.set(x, y, z);
        this.xr = xr % 360;
        this.yr = yr % 360;
        this.zr = zr % 360;
    }

}
