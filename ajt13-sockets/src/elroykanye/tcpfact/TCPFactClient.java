package elroykanye.tcpfact;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPFactClient {
    private final static String NAME = "TCPFact CLIENT ::::::::::::::: ";
    private final static String HOST = "127.0.0.1";
    private final static Integer PORT = 6789;
    private Socket clientEndSocket = null;

    public static void runner() {
        TCPFactClient client = new TCPFactClient();
        client.init();
        client.launch();
    }

    public static void main(String[] args) {
        runner();
    }

    private void init() {
        try {
            clientEndSocket = new Socket(HOST, PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void launch() {
        Thread clientThread = new Thread(() -> {
            System.out.println("Client started");
            BufferedReader fromServer = null;
            PrintWriter toServer = null;
            try {
                fromServer = new BufferedReader(new InputStreamReader(clientEndSocket.getInputStream()));
                toServer = new PrintWriter(new OutputStreamWriter(clientEndSocket.getOutputStream()), true);


                while(!fromServer.ready()) {
                    System.out.print(NAME.concat("Enter a number to calculate factorial of: "));
                    String input = new Scanner(System.in).nextLine();
                    System.out.println();

                    toServer.println(input);
                    // System.out.println(NAME.concat("Sent to server: " + input));

                    String receivedFact = fromServer.readLine();
                    if (receivedFact == null) break;
                    System.out.println(NAME.concat("Received from server: " + receivedFact));
                }
                System.out.println(NAME.concat("Server shutdown. Shutting down client!"));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(fromServer != null) {
                    try {
                        fromServer.close();
                        if(toServer != null) toServer.close();
                        clientEndSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        clientThread.start();
    }
}
