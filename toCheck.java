import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private static void run() {
        try (
                Scanner in = new Scanner(System.in);
                PrintWriter out = new PrintWriter(System.out);
        ) {
            task3(in, out);
        }
    }
	
	private static void task3(Scanner in, PrintWriter out){
        long n = in.nextLong();
        out.printf("%d", n * n);
    }
}