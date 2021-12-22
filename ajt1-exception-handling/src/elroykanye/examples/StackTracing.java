package elroykanye.examples;

public class StackTracing {
    public void arithmetic() {
        try {
            var r = 2/0;
        } catch(Throwable t) {
            t.printStackTrace(); // this prints the stack trace of the throwable object
        }
    }
}
