package io.tool.tia;

@FunctionalInterface
public interface RunIF<T> {
    boolean run(T e);
}
