package acmp.task2;

import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {

    private static Scanner scan;
    private static PrintWriter pw;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        int n = scan.nextInt();
        int result = 0;

        if (n == 0) {
            result = 1;
        } else if (n > 0 && n <= 10000) {
            result = ((1 + n) * n) / 2;
        } else if (n < 0 && n >= -10000) {
            for (int i = n; i <= -1; i++) {
                result += i;
            }
            result++;
        }

        pw.printf("%d", result);

        pw.flush();
    }
}