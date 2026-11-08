package io.tool.tia;

@FunctionalInterface
public interface Run<T> {
    void run(T t);
}
