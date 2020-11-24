package acmp.task9;

import java.io.PrintWriter;
import java.util.Scanner;

public class MainClass {

    private static Scanner scan;
    private static PrintWriter pw;

    public static void main(String[] args) {

        scan = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        int count = scan.nextInt();
        scan.nextLine();
        String[] input = scan.nextLine().trim().split(" ");

        int minIndex = 0;
        int maxIndex = 0;
        int sumPositive = 0;
        int sumAll = 1;
        int min = Integer.parseInt(input[0]);
        int max = Integer.parseInt(input[0]);

        if (count == input.length)
        {
            for (int i = 0; i < input.length; i++)
            {
                if (Integer.parseInt(input[i]) > max)
                {
                    max = Integer.parseInt(input[i]);
                    maxIndex = i;
                }
                if (Integer.parseInt(input[i]) < min)
                {
                    min = Integer.parseInt(input[i]);
                    minIndex = i;
                }
                if (Integer.parseInt(input[i]) >= 0)
                {
                    sumPositive += Integer.parseInt(input[i]);
                }
            }
            if (minIndex < maxIndex)
            {
                for (int i = minIndex + 1; i < maxIndex; i++)
                {
                    sumAll = sumAll * Integer.parseInt(input[i]);
                }
            }
            else
            {
                for (int i = maxIndex + 1; i < minIndex; i++)
                {
                    sumAll = sumAll * Integer.parseInt(input[i]);
                }
            }
        }

        pw.printf("%d %d", sumPositive, sumAll);

        pw.flush();
    }
}