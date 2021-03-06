package io.lambdadepot.function.checked;

import io.lambdadepot.function.Function3;
import io.lambdadepot.util.Result;

public interface CheckedFunction3<T1, T2, T3, R, X extends Throwable> {
    R apply(T1 t1, T2 t2, T3 t3) throws X;

    default Function3<T1, T2, T3, Result<R>> lift() {
        return (t1, t2, t3) -> {
            try {
                return Result.success(apply(t1, t2, t3));
            } catch (Throwable e) {
                return Result.failure(e);
            }
        };
    }
}
