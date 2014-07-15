package com.capraro;

public class Main {

    public static void main(String[] args) {
        Specification<String> shortString = s -> s.length() < 3;
        Specification<String> startsWithA = s -> s.length() > 0 && s.charAt(0) == 'a';

        System.out.println(shortString.not().isSatisfiedBy("bcdefg"));// true
        System.out.println(shortString.and(startsWithA).isSatisfiedBy("bc"));// false
        System.out.println(shortString.or(startsWithA).isSatisfiedBy("bc"));// true

    }
}
