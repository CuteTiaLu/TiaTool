package io.tool;

@FunctionalInterface
public interface Run<T> {
    void run(T t);
}
