package acmp.task1;

import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {

    private static Scanner scan;
    private static PrintWriter pw;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        String[] inputStr = scan.nextLine().trim().split(" ");
        pw.printf("%d", Integer.parseInt(inputStr[0]) + Integer.parseInt(inputStr[1]));

        pw.flush();
    }
}