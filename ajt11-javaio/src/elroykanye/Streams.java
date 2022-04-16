package elroykanye;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Streams {
    private static String fileIn = JavaIO.REPO.concat("file_in.txt");
    private static String fileOut = JavaIO.REPO.concat("file_out.txt");
    public static void fiStream() {
        System.out.println("Yo");
        try {
            InputStream in = new FileInputStream(JavaIO.REPO.concat("aFile.txt"));
            int b;
            while((b = in.read())!= -1) {
                System.out.print((char)b);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cStream() {
        try {
            Reader in = new FileReader(JavaIO.REPO.concat("file_in.txt"));
            Writer out = new FileWriter(JavaIO.REPO.concat("file_out.txt"));
            int c;
            while((c = in.read()) != -1) {
                out.write(c);
            }
            in.close(); out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void brStream() {
        try {
            Reader in = new InputStreamReader(new FileInputStream(JavaIO.REPO.concat("file_in.txt")));
            Writer out = new OutputStreamWriter(new FileOutputStream(JavaIO.REPO.concat("file_out.txt")));
            int c ;

            while((c = in.read()) != -1) {
                out.write(c);
            } in.close(); out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buffByteStream() {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileIn));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileOut));

            int c;
            while((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void buffCharStream() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileIn));
            BufferedWriter out = new BufferedWriter(new FileWriter(fileOut));
            int c;
            while ((c = in.read()) != -1) out.write(c);
            in.close(); out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void keyboardStream() {
        try {
            Reader cin = new InputStreamReader(System.in);
            System.out.println("Enter chars, 'q' to quit.");
            char c;
            do {
                c = (char) cin.read();
                System.out.println(c);
            } while (c != 'q');
            cin.close();
        } catch ( IOException e) {e.printStackTrace();}

    }

    private static void keyboardStream2() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a line of text");
            String line =  br.readLine();
            System.out.println("You wrote: " + line);
            br.close();
        } catch ( IOException e) {e.printStackTrace();}

    }

    private static void objectStream() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("date.txt"));
            out.writeObject(new Date());
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("date.txt"));
            Date date = (Date) in.readObject();
            System.out.println(date);
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void runner() {
        objectStream();
    }

    private static void cbCompare() {
        var start = System.currentTimeMillis();
        cStream();
        var stop = System.currentTimeMillis();
        System.out.println((double) (stop - start) / 1000);

        start = System.currentTimeMillis();
        buffByteStream();
        stop = System.currentTimeMillis();
        System.out.println((double) (stop - start) / 1000);
    }

    private static void bunchGen() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileIn))) {
            for(int i = 1; i < 1000000; i++) {
                bw.write("Elroy Kanye");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
