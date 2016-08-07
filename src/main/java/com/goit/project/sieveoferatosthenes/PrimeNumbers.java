package com.goit.project.sieveoferatosthenes;

import java.util.Arrays;

class PrimeNumbers {

    private static final StringBuilder simpleNumbers = new StringBuilder("2");
    private int counterOfSimpleNumbers = 1;

    String[] getSimpleNumbers() {
        return new String[]{"Your prime numbers: " + simpleNumbers,
                "Quantity primes in your range = " + counterOfSimpleNumbers};
    }

    @Override
    public String toString() {
        return "Please enter positive number that is greater the 1: ";
    }

    void sieveOfEratosthenes(int limit) {
        boolean[] sieve = new boolean[limit + 1];
        Arrays.fill(sieve, true);

        for (int i = 3; i <= limit; i+=2) {
            if (sieve[i]) {
                counterOfSimpleNumbers++;
                simpleNumbers.append(" ").append(i);
                int step = i % 2 == 0 ? i : 2 * i;
                for (int k = i * i; k < limit + 1; k += step) {
                    sieve[k] = false;
                }
            }
        }
    }
    void  toOutputPrimeNumbers(){
        for (String line: getSimpleNumbers()) System.out.println(line);
    }

    static int positiveIntGreaterThenOne(String s) throws NumberFormatException, NotPrimeNumberException {
        try {
            int number = Integer.parseInt(s);
            if (number <= 1) {
                throw new NotPrimeNumberException("You entered a number less then two, Try again!!!");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("You enter not number!Try again!!!");
        }
    }
}

