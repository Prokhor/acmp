package acmp.task3;

import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {

    private static Scanner scan;
    private static PrintWriter pw;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        long n = scan.nextLong();
        pw.printf("%d", n * n);

        pw.flush();
    }
}