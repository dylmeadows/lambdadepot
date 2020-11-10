/*
 * Copyright 2020 The Home Depot
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.lambdadepot.collection;

import io.lambdadepot.function.Function1;
import io.lambdadepot.util.ArrayIterator;
import java.util.Iterator;
import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * A tuple with four components.
 *
 * @param <T1> the type of {@code t1}
 * @param <T2> the type of {@code t2}
 * @param <T3> the type of {@code t3}
 * @param <T4> the type of {@code t4}
 */
@ToString
@EqualsAndHashCode
@SuppressWarnings({"unused", "WeakerAccess"})
public final class Tuple4<T1, T2, T3, T4> implements Iterable<Object> {
    /**
     * The number of components this tuple contains.
     */
    public static final int SIZE = 4;
    /**
     * The first component.
     */
    private final T1 t1;
    /**
     * The second component.
     */
    private final T2 t2;
    /**
     * The third component.
     */
    private final T3 t3;
    /**
     * The fourth component.
     */
    private final T4 t4;

    private Tuple4(T1 t1, T2 t2, T3 t3, T4 t4) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
    }

    /**
     * Factory method for creating a {@link Tuple4} containing
     * {@code t1} as the first component, {@code t2} as the
     * second component, {@code t3} as the third component
     * and {@code t4} as the fourth component.
     *
     * @param t1   the first component
     * @param t2   the second component
     * @param t3   the third component
     * @param t4   the fourth component
     * @param <T1> the type of {@code t1}
     * @param <T2> the type of {@code t2}
     * @param <T3> the type of {@code t3}
     * @param <T4> the type of {@code t4}
     * @return a new {@link Tuple4} instance containing {@code t1}
     * as the first component, {@code t2} as the second component,
     * {@code t3} as the third component and {@code t4} as the
     * fourth component.
     */
    public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(T1 t1, T2 t2, T3 t3, T4 t4) {
        return new Tuple4<>(t1, t2, t3, t4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<Object> iterator() {
        return ArrayIterator.of(t1, t2, t3, t4);
    }

    /**
     * Applies {@code mapper} to {@link #t1} and returns a new {@link Tuple4}
     * instance with the output from {@code mapper} as the {@code t1} component.
     *
     * @param mapper the mapping function to apply to {@link #t1}
     * @param <O>    the output type
     * @return a new {@link Tuple4} with the output of {@code mapper}
     * as the {@code t1} component
     * @throws NullPointerException if {@code mapper} is null
     */
    public <O> Tuple4<O, T2, T3, T4> mapT1(Function1<T1, O> mapper) {
        Objects.requireNonNull(mapper, "mapper");
        return new Tuple4<>(mapper.apply(t1), t2, t3, t4);
    }

    /**
     * Applies {@code mapper} to {@link #t2} and returns a new {@link Tuple4}
     * instance with the output from {@code mapper} as the {@code t2} component.
     *
     * @param mapper the mapping function to apply to {@link #t2}
     * @param <O>    the output type
     * @return a new {@link Tuple4} with the output of {@code mapper}
     * as the {@code t2} component
     * @throws NullPointerException if {@code mapper} is null
     */
    public <O> Tuple4<T1, O, T3, T4> mapT2(Function1<T2, O> mapper) {
        Objects.requireNonNull(mapper, "mapper");
        return new Tuple4<>(t1, mapper.apply(t2), t3, t4);
    }

    /**
     * Applies {@code mapper} to {@link #t3} and returns a new {@link Tuple4}
     * instance with the output from {@code mapper} as the {@code t3} component.
     *
     * @param mapper the mapping function to apply to {@link #t3}
     * @param <O>    the output type
     * @return a new {@link Tuple4} with the output of {@code mapper}
     * as the {@code t3} component
     * @throws NullPointerException if {@code mapper} is null
     */
    public <O> Tuple4<T1, T2, O, T4> mapT3(Function1<T3, O> mapper) {
        Objects.requireNonNull(mapper, "mapper");
        return new Tuple4<>(t1, t2, mapper.apply(t3), t4);
    }

    /**
     * Applies {@code mapper} to {@link #t4} and returns a new {@link Tuple4}
     * instance with the output from {@code mapper} as the {@code t4} component.
     *
     * @param mapper the mapping function to apply to {@link #t4}
     * @param <O>    the output type
     * @return a new {@link Tuple4} with the output of {@code mapper}
     * as the {@code t4} component
     * @throws NullPointerException if {@code mapper} is null
     */
    public <O> Tuple4<T1, T2, T3, O> mapT4(Function1<T4, O> mapper) {
        Objects.requireNonNull(mapper, "mapper");
        return new Tuple4<>(t1, t2, t3, mapper.apply(t4));
    }

    /**
     * Applies {@code transformer} to {@code this} and returns the output
     * of {@code transformer}.
     *
     * @param transformer the transformation function to apply to {@code this}
     * @param <O>         the output type
     * @return the output of {@code transformer}
     * @throws NullPointerException if {@code transformer} is null
     */
    public <O> O transform(Function1<Tuple4<T1, T2, T3, T4>, O> transformer) {
        Objects.requireNonNull(transformer, "transformer");
        return transformer.apply(this);
    }

    /**
     * Returns a {@link Tuple4} with the components reversed.
     *
     * @return a new {@link Tuple4} with the components reversed
     */
    public Tuple4<T4, T3, T2, T1> reversed() {
        return new Tuple4<>(t4, t3, t2, t1);
    }

    /**
     * Returns the number of components this tuple can contain.
     *
     * @return {@link #SIZE}
     */
    public int getSize() {
        return SIZE;
    }

    /**
     * Returns the first component.
     *
     * @return {@link #t1}
     */
    public T1 getT1() {
        return t1;
    }

    /**
     * Returns the second component.
     *
     * @return {@link #t2}
     */
    public T2 getT2() {
        return t2;
    }

    /**
     * Returns the third component.
     *
     * @return {@link #t3}
     */
    public T3 getT3() {
        return t3;
    }

    /**
     * Returns the fourth component.
     *
     * @return {@link #t4}
     */
    public T4 getT4() {
        return t4;
    }
}
