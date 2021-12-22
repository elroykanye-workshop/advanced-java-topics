package elroykanye.methods;

import java.util.Scanner;

public class TryCatch {
    // single
    public void divisionByZero() {
        int d = 0, result;
        try {
            result = 100/d;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception occurred");
            result = 100;
        }

        /*
         * When this program is executed, it no longer terminates abruptly.
         */
    }

    // multiple
    public void divisionByZeroAndIndexOutOfBounds() {
        String name = "";
        String a = null;
        try {
            System.out.println("Enter a word longer than 3 characters");
            name = new Scanner(System.in).nextLine();
            a = String.valueOf(name.toCharArray()[3]);
            int b = 2/0;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            System.out.println("Enter a value longer than 3 characters next time.");
        } catch (ArithmeticException e) {
            System.out.println(e);
            System.out.println(" Do not divide by zero.");
        } finally {
            System.out.println("The name you entered is " + name);
        }

        /*
         * Let it be known that the JVM always picks the first catch block that matches the current exception, hence
         * multiple catch blocks should handle exceptions in descending order of specificity.
         */
    }
}
