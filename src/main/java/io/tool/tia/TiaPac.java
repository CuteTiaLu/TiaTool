/**
 * 包装类
 * package Obj
 * 可以包装传入的泛型
 * yes package <T>
 *
 * @author 天禄是小狗
 * @since 2026-11-08
 */
package io.tool.tia;

public class TiaPac<T> {
    public T data;

    public TiaPac(T data) {
        this.data = data;
    }
}
