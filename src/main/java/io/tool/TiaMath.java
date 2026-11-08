/**
 * 数学
 * Math
 *
 * @author deepseek
 * @since 2026-11-08
 */

package io.tool;

public final class TiaMath {

    public static final double PI2 = Math.PI * 2;

    public static final double PI22 = Math.PI * Math.PI;

    public static class Function {

        protected static final float[] CosData = new float[3601];
        protected static final float[] SinData = new float[3601];

        static {
            final float degToRad = (float) (Math.PI / 180.0);
            for (int i = 0; i <= 3600; i++) {
                float rad = (i * 0.1f) * degToRad;
                SinData[i] = (float) Math.sin(rad);
                CosData[i] = (float) Math.cos(rad);
            }
        }

        public static float cos_Fast(double angle) {
            float absAngle = (float) (Math.abs(angle) % 360.0);
            float index = absAngle * 10.0f;
            int i1 = (int) index;
            int i2 = (i1 == 3600) ? 3600 : i1 + 1;
            float fraction = index - i1;
            return CosData[i1] + (CosData[i2] - CosData[i1]) * fraction;
        }

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

        public static float cos_Fast(float angle) {
            return cos_Fast((double) angle);
        }

        public static float sin_Fast(float angle) {
            return sin_Fast((double) angle);
        }
    }
}
