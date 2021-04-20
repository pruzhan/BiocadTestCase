package ru.pruzhan.biocad;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Fibonacci.print();
        JSONTable.printTable(args[0]);
    }
}
