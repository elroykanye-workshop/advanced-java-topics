package elroykanye.examples;

public class ExceptionExample {
    public void divisionByZero() {
        int d = 0, result;
        result = 100/d;
        System.out.println(result);
    }

    public void indexOutOfBounds() {
        int[] a = new int[4];
        a[5] = 6; // index out of bounds
        int[] b = new int[-3]; // negative array size
    }

    public void nullPointer() {
        String name = null;
        int len = name.length(); // null pointer
    }
    /*
     * From the above examples, we see that they are cases when exceptions will occur.
     * What happens with this is that each exception disrupts the normal flow of execution and terminates the program
     * abruptly (default behaviour of JVM).
     */
}
