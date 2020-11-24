package acmp.task8;

import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {

    private static Scanner scan;
    private static PrintWriter pw;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        String[] input = scan.nextLine().trim().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        pw.printf("%s", a * b == c ? "YES" : "NO");

        pw.flush();
    }
}