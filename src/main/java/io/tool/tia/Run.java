package io.tool.tia;

/**
 * 泛型函数接口
 * Generic FunctionalInterface
 * @param <T> 类型:Type
 */
@FunctionalInterface
public interface Run<T> {
    /**
     * awa
     * @param t 传入的对象
     */
    void run(T t);
}
