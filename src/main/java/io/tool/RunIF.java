package io.tool;

@FunctionalInterface
public interface RunIF<T> {
    boolean run(T e);
}
