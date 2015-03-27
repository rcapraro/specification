package com.capraro;

/**
 * Specification interface with default methods.
 * Created by Richard on 15/07/2014.
 */
public interface Specification<T> {

    /**
     * Returns true if the specification is satisfied by the target t.
     *
     * @param t the specification target
     * @return true if the specification is satisfied by t, false otherwise
     */
    boolean isSatisfiedBy(T t);

    /**
     * And specification.
     *
     * @param other the other specification target
     * @return true if the specification is satisfied by t, false otherwise
     */
    default Specification<T> and(Specification<T> other) {
        assert other != null;
        return s -> this.isSatisfiedBy(s) && other.isSatisfiedBy(s);
    }

    /**
     * Or specification.
     *
     * @param other the other specification target
     * @return true if the specification is satisfied by t, false otherwise
     */
    default Specification<T> or(Specification<T> other) {
        assert other != null;
        return s -> this.isSatisfiedBy(s) || other.isSatisfiedBy(s);
    }

    /**
     * Not specification.
     *
     * @return true if the specification is satisfied by t, false otherwise
     */
    default Specification<T> not() {
        return s -> !isSatisfiedBy(s);
    }
}
