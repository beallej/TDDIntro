package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) throws IllegalArgumentException {
        if (i < 0) {
            throw new IllegalArgumentException("Number must be 0 or greater");
        }
        else if (i == 0) {
            return 1;
        }
        else {
            return i * compute(i - 1);
        }

    }
}
