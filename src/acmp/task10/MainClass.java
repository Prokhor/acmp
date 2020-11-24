package acmp.task10;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainClass {

    private static Scanner scan;
    private static PrintWriter pw;

    public static void main(String[] args) {

        scan = new Scanner(System.in);
        pw = new PrintWriter(System.out);

        String[] inputStr = scan.nextLine().trim().split(" ");
        int[] inputArr = new int[inputStr.length];
        for (int i = 0; i < inputStr.length; i++) {
            inputArr[i] = Integer.parseInt(inputStr[i]);
        }
        ArrayList<Byte> calc = new ArrayList<>(calculateIt(inputArr));
        Collections.sort(calc);
        String outStr = "";
        for (int counter: calc){
            outStr += String.format("%d ", counter);
        }
        pw.printf("%s", outStr.trim());

        pw.flush();
    }

    private static ArrayList<Byte> calculateIt(int[] arr){

        ArrayList<Byte> answer = new ArrayList<>();

        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = arr[3];

        for (byte i = -100; i <= 100 ; i++) {
            long a1 = (long)a * i * i * i;
            if (a1 + b * i * i + c * i + d == 0) {
                answer.add(i);
            }
        }

        return answer;
    }
}