package elroykanye.examples;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

public class Finally {
    public void readFile() throws IOException {

        String dir = "/home/kanye/Development/Learning/advanced-java-topics/ajt1-exception-handling/src/elroykanye/examples/aFile.txt";
        try (FileInputStream fis = new FileInputStream(dir)) {
            System.out.println("In try");
            int k = fis.read();

            FileDescriptor fd = fis.getFD();
            System.out.println(k);
            System.out.println(fd.valid());
        } catch (IOException e) {
            System.out.println("In catch");
            System.out.println("File not found");
        } finally {
            System.out.println("In finally");
        }
    }
}
