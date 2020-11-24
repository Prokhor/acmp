package acmp.task4;

import java.util.Scanner;

public class MainClass {

    private static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);

        int i = scan.nextInt();

        System.out.printf("%d%d%d", i, 9, 9 - i);
    }
}