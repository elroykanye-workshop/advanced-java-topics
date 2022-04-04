package elroykanye;

import java.lang.reflect.Modifier;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class[] classes = new Class[]{
                int.class,
                Float.TYPE,
                "Elroy Kanye".getClass(),
                Enum.class,
                Class.forName("java.io.Serializable"),

        };

        findInheritanceHierarchy(ArithmeticException.class);

    }

    public static void className(Class[] classes) {
        for (Class c: classes) {
            System.out.println(c);
        }
    }

    public static void getClassInfo(Class[] classes) {
        for(Class c : classes) {
            System.out.println("Canonical mame: " + c.getCanonicalName());
            System.out.println("Simple name: " + c.getSimpleName());
            System.out.println("Package name: " + c.getPackageName());
            System.out.println("Is synthetic class: " + c.isSynthetic());
            System.out.println("Protection domain: " + c.getProtectionDomain());
            System.out.println();
        }
    }

    public static void findInheritanceHierarchy(Class c) {
        if (c == null) {
            System.out.println("\nEnd");
        } else {

            System.out.println(c + " <- ");
            findInheritanceHierarchy(c.getSuperclass());
        }
    }
}
