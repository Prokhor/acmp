import java.io.*;
import java.math.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private static void run() {
        try (
                Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out);
        ) {
            task(in, out);
        }
    }
	
	private static void task(Scanner in, PrintWriter out){
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
}