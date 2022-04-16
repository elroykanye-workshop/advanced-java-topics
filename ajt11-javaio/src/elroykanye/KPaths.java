package elroykanye;

import java.nio.file.Path;
import java.nio.file.Paths;

public class KPaths {
    static final String A_FILE = "/home/kanye/IdeaProjects/Java/advanced-java-topics/ajt11-javaio/src/elroykanye/aFile.txt";

    private static void createPath() {
        Path p = Paths.get(A_FILE);
        System.out.println(p);
    }

    private static void retrievePathInfo() {
        Path p = Paths.get(A_FILE);
        System.out.println("toString: " + p);
        System.out.println("getFileName: " + p.getFileName());
        System.out.println("getNameCount: " + p.getNameCount());
        System.out.println("getRoot: " + p.getRoot());
        System.out.println("getName(0): " + p.getName(0));
        System.out.println("subpath(0, 3): " + p.subpath(0, 3));
    }

    public static void pathOps() {
        Path p = Paths.get(A_FILE);
        Path root = Paths.get("/");

        System.out.println(p.normalize());
        System.out.println(p.toUri());

        System.out.println(root.resolve(p.subpath(0, 3)));

    }

    public static void runner() {
        pathOps();
    }
}
