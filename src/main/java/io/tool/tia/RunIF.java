package io.tool.tia;

/**
 * 返回 boolean 的泛型函数接口
 * return boolean of Generic FunctionalInterface
 *
 * @param <T> 类型:Type
 */
@FunctionalInterface
public interface RunIF<T> {
    /**
     * awa
     * @param t 传入的对象
     * @return boolean
     */
    boolean run(T t);
}
