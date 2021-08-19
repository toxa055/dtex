package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;
import java.util.stream.Collectors;

public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException();
        }

        y.retainAll(x);
        y = (List) y.stream().distinct().collect(Collectors.toList());

        if (y.size() < x.size()) {
            return false;
        }

        boolean result = true;
        for (int i = 0; i < x.size(); i++) {
            if (!x.get(i).equals(y.get(i))) {
                result = false;
                break;
            }
        }

        return result;
    }
}
