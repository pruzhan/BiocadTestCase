package ru.pruzhan.biocad;

public class Fibonacci {
    public static void print() {
        int prev = 0, next = 1, a;
        System.out.print("Fibonacci numbers: " + prev + " " + next);
        while (next<1000000) {
            a = prev;
            prev = next;
            next = a+next;
            System.out.print(" " + next);
        }
        System.out.println();
    }
}
