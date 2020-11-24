package acmp.task5;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    private static Scanner scan;
    private static PrintWriter pw;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        byte n = scan.nextByte();
        scan.nextLine();
        String[] days = scan.nextLine().trim().split(" ");

        ArrayList<Byte> chet = new ArrayList();
        ArrayList<Byte> nechet = new ArrayList();

        for (byte i = 0; i < days.length; i++)
        {
            if (Byte.parseByte(days[i]) % 2 == 0)
            {
                chet.add(Byte.parseByte(days[i]));
            }
            else
            {
                nechet.add(Byte.parseByte(days[i]));
            }
        }

        String outputnch = "";
        String outputch = "";

        for (byte item : nechet)
        {
            outputnch += item + " ";
        }
        for (byte item : chet)
        {
            outputch += item + " ";
        }
        outputnch = outputnch.trim();
        outputch = outputch.trim();

        pw.printf("%s\n%s\n%s", outputnch, outputch, chet.size() >= nechet.size() ? "YES" : "NO");

        pw.flush();
    }
}