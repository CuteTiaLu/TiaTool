package io.tool.tia;

/**
 * 包装类
 * package Obj
 * 可以包装传入的泛型
 * yes package (T)
 *
 * @param <T> 类型:Type
 *
 * @author 天禄是小狗
 * @since 2026-11-08
 */
public class TiaPac<T> {
    /**
     * 存储的数据
     * Storage Data
     */
    public T data;

    /**
     * 默认的构造函数
     * Default Constructor
     * @param data 传入的对象:The passed-in object
     */
    public TiaPac(T data) {
        this.data = data;
    }
}
