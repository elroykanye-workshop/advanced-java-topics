package elroykanye.methods;

public class TryCatch {
    public void divisionByZero() {
        int d = 0, result;
        try {
            result = 100/d;
        } catch (ArithmeticException e) {
            System.out.println("Diving by zero error occurred");
        }

    }
}
