package acmp.task6;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainClass {

    private static Scanner scan;
    private static PrintWriter pw;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        String input = scan.nextLine();

        Pattern ptr = Pattern.compile("[A-H][1-8]-[A-H][1-8]");

        int vDelta, hDelta;

        if (input.matches(ptr.pattern())){
            vDelta = Math.abs(input.charAt(1) - input.charAt(4));
            hDelta = Math.abs(input.charAt(0) - input.charAt(3));

            pw.printf((vDelta == 1 && hDelta == 2) || (vDelta == 2 && hDelta == 1) ? "YES" : "NO");
        } else{
            System.out.println("ERROR");
        }

        pw.flush();
    }
}