/**
 * 更容易操作二进制的工具
 * A tool that's easier for handling binary
 *
 * @author deepseek(AI)
 * @since 2026-11-08
 */
package io.tool.tia;

public final class Binary {
    public static boolean get(int value, int index) {
        return ((value >> index) & 1) == 1;
    }

    public static boolean get(long value, int index) {
        return ((value >> (long) index) & 1L) == 1L;
    }

    public static int set(int value, int index, boolean state) {
        if (state) {
            return value | (1 << index);
        } else {
            return value & ~(1 << index);
        }
    }

    public static long set(long value, int index, boolean state) {
        if (state) {
            return value | (1L << index);
        } else {
            return value & ~(1L << index);
        }
    }

    public static int flip(int value, int index) {
        return value ^ (1 << index);
    }
}
