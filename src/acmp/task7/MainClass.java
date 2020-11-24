package acmp.task7;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class MainClass {

    private static Scanner scan;
    private static PrintWriter pw;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        String[] input = scan.nextLine().trim().split(" ");

        BigInteger a = new BigInteger(input[0]);
        BigInteger b = new BigInteger(input[1]);
        BigInteger c = new BigInteger(input[2]);

        if (a.compareTo(b) == 1)
        {
            if (a.compareTo(c) == 1)
            {
                pw.printf("%s", a);
            }
            else if (a.compareTo(c) < 1)
            {
                pw.printf("%s", c);
            }
        }
        else if (a.compareTo(b) < 1)
        {
            if (b.compareTo(c) == 1)
            {
                pw.printf("%s", b);
            }
            else if (b.compareTo(c) < 1)
            {
                pw.printf("%s", c);
            }
        }

        pw.flush();
    }
}