package io.tool.tia;

/**
 * 数学
 * Math
 *
 * @author deepseek(AI)
 * @since 2026-11-08
 */
public final class TiaMath {

    private TiaMath() {}

    /**
     * PI*2
     */
    public static final double PI2 = Math.PI * 2;

    /**
     * PI*PI
     */
    public static final double PI22 = Math.PI * Math.PI;

    /**
     * Math-Function
     */
    public static class Function {

        private Function() {}

        /**
         * Math-data
         */
        private static final float[] CosData = new float[3601];
        private static final float[] SinData = new float[3601];

        static {
            final float degToRad = (float) (Math.PI / 180.0);
            for (int i = 0; i <= 3600; i++) {
                float rad = (i * 0.1f) * degToRad;
                SinData[i] = (float) Math.sin(rad);
                CosData[i] = (float) Math.cos(rad);
            }
        }

        /**
         * 快速余弦函数 (基于 double 角度)
         * Fast Cosine Function (double angle)
         * <p>
         * 通过查表法 (LUT) 和线性插值，代替原生的 Math.cos。
         * 牺牲极微小的精度，换取极致的 CPU 执行速度。
         * Uses LUT and linear interpolation instead of Math.cos.
         * Sacrifices tiny precision for extreme CPU speed.
         *
         * @param angle 角度 (非弧度): Angle in degrees (not radians)
         * @return 余弦值: Cosine value
         */
        public static float cos_Fast(double angle) {
            float absAngle = (float) (Math.abs(angle) % 360.0);
            float index = absAngle * 10.0f;
            int i1 = (int) index;
            int i2 = (i1 == 3600) ? 3600 : i1 + 1;
            float fraction = index - i1;
            return CosData[i1] + (CosData[i2] - CosData[i1]) * fraction;
        }

        /**
         * 快速正弦函数 (基于 double 角度)
         * Fast Sine Function (double angle)
         * <p>
         * 自动处理负数角度，无需外部取反。
         * Automatically handles negative angles.
         *
         * @param angle 角度 (非弧度): Angle in degrees (not radians)
         * @return 正弦值: Sine value
         */
        public static float sin_Fast(double angle) {
            boolean neg = false;
            if (angle < 0) {
                neg = true;
                angle = -angle;
            }
            float absAngle = (float) (angle % 360.0);
            float index = absAngle * 10.0f;

            int i1 = (int) index;
            int i2 = (i1 == 3600) ? 3600 : i1 + 1;
            float fraction = index - i1;

            float result = SinData[i1] + (SinData[i2] - SinData[i1]) * fraction;
            return neg ? -result : result;
        }

        /**
         * 快速余弦函数 (基于 float 角度)
         * Fast Cosine Function (float angle)
         *
         * @param angle 角度 (非弧度): Angle in degrees (not radians)
         * @return 余弦值: Cosine value
         */
        public static float cos_Fast(float angle) {
            return cos_Fast((double) angle);
        }

        /**
         * 快速正弦函数 (基于 float 角度)
         * Fast Sine Function (float angle)
         *
         * @param angle 角度 (非弧度): Angle in degrees (not radians)
         * @return 正弦值: Sine value
         */
        public static float sin_Fast(float angle) {
            return sin_Fast((double) angle);
        }
    }
}
