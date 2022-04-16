package elroykanye;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KFile {
    static final String A_FILE = "/home/kanye/IdeaProjects/Java/advanced-java-topics/ajt11-javaio/src/elroykanye/aFile.txt";

    private static void checkExistence() {
        Path p = Paths.get(A_FILE);
        System.out.println("File exists? " + Files.exists(p));
    }

    private static void createDel() {
        Path p = Paths.get(JavaIO.REPO.concat("sample"));
        try {

            if(Files.exists(p))
                System.out.println("File already exists");
            else{
                Files.createFile(p);
                System.out.println("File has been created. Press y to delete:");
            }
            Reader in = new BufferedReader(new InputStreamReader(System.in));
            do {

                int c = in.read();
                if((char) c == 'q') {
                    System.out.println("Existing!");
                    break;
                }
                else if((char)c == 'n') break;
                else if((char)c == 'y') {
                    Files.delete(p);
                    System.out.println("File deleted");
                    break;
                } else {
                    System.out.println("Wrong entry. Try again!");
                }

            } while (true);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runner() {
        createDel();
    }
}
