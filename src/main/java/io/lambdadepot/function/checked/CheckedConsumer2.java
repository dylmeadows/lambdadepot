package io.lambdadepot.function.checked;

public interface CheckedConsumer2<T1, T2> {
    void accept(T1 t1, T2 t2) throws Throwable;
}
