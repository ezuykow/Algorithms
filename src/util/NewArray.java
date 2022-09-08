package util;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class NewArray {
    private static final int ARRAY_SIZE = 100_000;
    private static final int MAX_NUM = 100_000;

    public static void main(String[] args) throws FileNotFoundException {
        newArrayFile();
    }

    public static int getArraySize() {
        return ARRAY_SIZE;
    }

    private static void newArrayFile () throws FileNotFoundException {
        var file = new File("array");
        var printWriter = new PrintWriter(new FileOutputStream(file), true);

        var random = new Random();
        for (int i = 0; i < ARRAY_SIZE; i++) {
            printWriter.println(random.nextInt(MAX_NUM));
        }

        printWriter.close();
    }

    public static void fillArray(int[] array) throws FileNotFoundException {
        var file = new File("array");
        if (!file.exists()) {
            newArrayFile();
        }

        var scanner = new Scanner(new FileInputStream(file));

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
    }
}
