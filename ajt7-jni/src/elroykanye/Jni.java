package elroykanye;

public class Jni {
    public native void print();

    static {
        System.loadLibrary("test");

    }


    public static void main(String[] args) {
        new Jni().print();
    }

}
