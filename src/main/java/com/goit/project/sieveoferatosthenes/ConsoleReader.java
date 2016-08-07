package com.goit.project.sieveoferatosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() throws IOException {
        return BUFFERED_READER.readLine();
    }
}
