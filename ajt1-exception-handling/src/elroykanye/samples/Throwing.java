package elroykanye.samples;

public class Throwing {
    public void testThrow() {
        try {
            throw new Exception("Test");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
