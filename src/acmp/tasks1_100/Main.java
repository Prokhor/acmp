package acmp.tasks1_100;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

//region SOLVED

    private static void task1(Scanner in, PrintWriter out) {
        String[] inputStr = in.nextLine().trim().split(" ");
        out.printf("%d", Integer.parseInt(inputStr[0]) + Integer.parseInt(inputStr[1]));
    }

    private static void task2(Scanner in, PrintWriter out) {
        int n = in.nextInt();
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

        out.printf("%d", result);
    }

    private static void task3(Scanner in, PrintWriter out) {
        long n = in.nextLong();
        out.printf("%d", n * n);
    }

    private static void task4(Scanner in, PrintWriter out) {
        int i = in.nextInt();
        out.printf("%d%d%d", i, 9, 9 - i);
    }

    private static void task5(Scanner in, PrintWriter out) {
        byte n = in.nextByte();
        in.nextLine();
        String[] days = in.nextLine().trim().split(" ");

        ArrayList<Byte> chet = new ArrayList();
        ArrayList<Byte> nechet = new ArrayList();

        for (byte i = 0; i < days.length; i++) {
            if (Byte.parseByte(days[i]) % 2 == 0) {
                chet.add(Byte.parseByte(days[i]));
            } else {
                nechet.add(Byte.parseByte(days[i]));
            }
        }

        String outputnch = "";
        String outputch = "";

        for (byte item : nechet) {
            outputnch += item + " ";
        }
        for (byte item : chet) {
            outputch += item + " ";
        }
        outputnch = outputnch.trim();
        outputch = outputch.trim();

        out.printf("%s\n%s\n%s", outputnch, outputch, chet.size() >= nechet.size() ? "YES" : "NO");
    }

    private static void task6(Scanner in, PrintWriter out) {
        String input = in.nextLine();
        Pattern ptr = Pattern.compile("[A-H][1-8]-[A-H][1-8]");
        int vDelta, hDelta;
        if (input.matches(ptr.pattern())) {
            vDelta = Math.abs(input.charAt(1) - input.charAt(4));
            hDelta = Math.abs(input.charAt(0) - input.charAt(3));
            out.printf((vDelta == 1 && hDelta == 2) || (vDelta == 2 && hDelta == 1) ? "YES" : "NO");
        } else {
            System.out.println("ERROR");
        }
    }

    private static void task7(Scanner in, PrintWriter out) {
        String[] input = in.nextLine().trim().split(" ");

        BigInteger a = new BigInteger(input[0]);
        BigInteger b = new BigInteger(input[1]);
        BigInteger c = new BigInteger(input[2]);

        if (a.compareTo(b) == 1) {
            if (a.compareTo(c) == 1) {
                out.printf("%s", a);
            } else if (a.compareTo(c) < 1) {
                out.printf("%s", c);
            }
        } else if (a.compareTo(b) < 1) {
            if (b.compareTo(c) == 1) {
                out.printf("%s", b);
            } else if (b.compareTo(c) < 1) {
                out.printf("%s", c);
            }
        }
    }

    private static void task8(Scanner in, PrintWriter out) {
        String[] input = in.nextLine().trim().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        out.printf("%s", a * b == c ? "YES" : "NO");
    }

    private static void task9(Scanner in, PrintWriter out) {
        int count = in.nextInt();
        in.nextLine();
        String[] input = in.nextLine().trim().split(" ");

        int minIndex = 0;
        int maxIndex = 0;
        int sumPositive = 0;
        int sumAll = 1;
        int min = Integer.parseInt(input[0]);
        int max = Integer.parseInt(input[0]);

        if (count == input.length) {
            for (int i = 0; i < input.length; i++) {
                if (Integer.parseInt(input[i]) > max) {
                    max = Integer.parseInt(input[i]);
                    maxIndex = i;
                }
                if (Integer.parseInt(input[i]) < min) {
                    min = Integer.parseInt(input[i]);
                    minIndex = i;
                }
                if (Integer.parseInt(input[i]) >= 0) {
                    sumPositive += Integer.parseInt(input[i]);
                }
            }
            if (minIndex < maxIndex) {
                for (int i = minIndex + 1; i < maxIndex; i++) {
                    sumAll = sumAll * Integer.parseInt(input[i]);
                }
            } else {
                for (int i = maxIndex + 1; i < minIndex; i++) {
                    sumAll = sumAll * Integer.parseInt(input[i]);
                }
            }
        }

        out.printf("%d %d", sumPositive, sumAll);
    }

    private static void task10(Scanner in, PrintWriter out) {
        String[] inputStr = in.nextLine().trim().split(" ");
        int[] inputArr = new int[inputStr.length];
        for (int i = 0; i < inputStr.length; i++) {
            inputArr[i] = Integer.parseInt(inputStr[i]);
        }
        ArrayList<Byte> calc = new ArrayList<>(task10_calculateIt(inputArr));
        Collections.sort(calc);
        String outStr = "";
        for (int counter : calc) {
            outStr += String.format("%d ", counter);
        }
        out.printf("%s", outStr.trim());
    }

    private static ArrayList<Byte> task10_calculateIt(int[] arr) {
        ArrayList<Byte> answer = new ArrayList<>();
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = arr[3];
        for (byte i = -100; i <= 100; i++) {
            long a1 = (long) a * i * i * i;
            if (a1 + b * i * i + c * i + d == 0) {
                answer.add(i);
            }
        }
        return answer;
    }

    private static void task11(Scanner in, PrintWriter out) {
        int maxJump = in.nextInt();
        int n = in.nextInt();
        BigInteger count[] = new BigInteger[n + 1];
        count[0] = BigInteger.ONE;
        count[1] = BigInteger.ONE;
        for (int i = 2; i <= maxJump; i++) {
            count[i] = count[i - 1].shiftLeft(1);
        }
        for (int i = maxJump + 1; i <= n; i++) {
            count[i] = count[i - 1].shiftLeft(1).subtract(count[i - 1 - maxJump]);
        }
        out.println(count[n]);
    }

    private static void task12(Scanner in, PrintWriter out){
        int n = in.nextInt();
        String[][] passengers = new String[n][10];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            passengers[i] = in.nextLine().trim().split(" ");
        }
        int counter = 0;
        long a, b, c, x, y, x1, y1, x2, y2, x3, y3, x4, y4;
        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(passengers[i][0]);
            y = Integer.parseInt(passengers[i][1]);
            x1 = Integer.parseInt(passengers[i][2]);
            y1 = Integer.parseInt(passengers[i][3]);
            x2 = Integer.parseInt(passengers[i][4]);
            y2 = Integer.parseInt(passengers[i][5]);
            x3 = Integer.parseInt(passengers[i][6]);
            y3 = Integer.parseInt(passengers[i][7]);
            x4 = Integer.parseInt(passengers[i][8]);
            y4 = Integer.parseInt(passengers[i][9]);
            a = (x1 - x) * (y2 - y1) - (x2 - x1) * (y1 - y);
            b = (x2 - x) * (y3 - y2) - (x3 - x2) * (y2 - y);
            c = (x3 - x) * (y1 - y3) - (x1 - x3) * (y3 - y);
            if ((a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0)) {
                counter++;
            } else {
                a = (x1 - x) * (y3 - y1) - (x3 - x1) * (y1 - y);
                b = (x3 - x) * (y4 - y3) - (x4 - x3) * (y3 - y);
                c = (x4 - x) * (y1 - y4) - (x1 - x4) * (y4 - y);
                if ((a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0)) {
                    counter++;
                }
            }
        }
        out.println(counter);
    }

    private static void task13(Scanner in, PrintWriter out) {
        String[] input = in.nextLine().trim().split(" ");
        byte cow = 0, bull = 0;
        for (byte i = 0; i < 4; i++) {
            if (input[0].charAt(i) == input[1].charAt(i)) {
                cow++;
            }
            switch (i) {
                case 0:
                    if ((input[0].charAt(i) != input[1].charAt(i)) &&
                            ((input[0].charAt(i) == input[1].charAt(1)) ||
                            (input[0].charAt(i) == input[1].charAt(2)) ||
                            (input[0].charAt(i) == input[1].charAt(3)))
                    ) {
                        bull++;
                        break;
                    }
                case 1:
                    if ((input[0].charAt(i) != input[1].charAt(i)) &&
                            ((input[0].charAt(i) == input[1].charAt(0)) ||
                            (input[0].charAt(i) == input[1].charAt(2)) ||
                            (input[0].charAt(i) == input[1].charAt(3)))
                    ) {
                        bull++;
                        break;
                    }
                case 2:
                    if ((input[0].charAt(i) != input[1].charAt(i)) &&
                            ((input[0].charAt(i) == input[1].charAt(1)) ||
                            (input[0].charAt(i) == input[1].charAt(0)) ||
                            (input[0].charAt(i) == input[1].charAt(3)))
                    ) {
                        bull++;
                        break;
                    }
                case 3:
                    if ((input[0].charAt(i) != input[1].charAt(i)) &&
                            ((input[0].charAt(i) == input[1].charAt(1)) ||
                            (input[0].charAt(i) == input[1].charAt(2)) ||
                            (input[0].charAt(i) == input[1].charAt(0)))
                    ) {
                        bull++;
                        break;
                    }
            }
        }
        out.printf("%d %d", cow, bull);
    }

//endregion
    private static void run() {
        try (
                Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out);
        ) {
            task13(in, out);
        }
    }
}