package elroykanye.tcpfact;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFactServerIterative {
    private final static String NAME = "TCPFact SERVER ::::::::::::::: ";
    private final static Integer PORT = 6789;
    private ServerSocket serverSocket = null;
    private Socket serverEndSocket = null;

    public static void runner() {
        TCPFactServerIterative serverIterative = new TCPFactServerIterative();
        serverIterative.init();
        serverIterative.launch();
    }

    public static void main(String[] args) {
        runner();
    }

    public void init() {
        try {
            this.serverSocket = new ServerSocket(PORT);
            System.out.println(NAME.concat("Server is listening on PORT: " + PORT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launch() {

        Thread factorialThread = new Thread(() -> {
            System.out.println("Server started");
            BufferedReader fromClient = null;
            PrintWriter toClient = null;
            try {
                while (true) {
                    serverEndSocket = serverSocket.accept();

                    fromClient = new BufferedReader(new InputStreamReader(serverEndSocket.getInputStream()));
                    toClient = new PrintWriter(new OutputStreamWriter(serverEndSocket.getOutputStream()), true);

                    String inputFromClient;
                    while(true) {
                        inputFromClient = fromClient.readLine();
                        // System.out.println(NAME.concat("Received from client: " + inputFromClient));
                        try {
                            double f = fact(Integer.parseInt(inputFromClient));
                            toClient.println(f);
                            System.out.println(NAME.concat("Sent to client: " + f));
                        } catch (NumberFormatException e) {
                            if(inputFromClient.equals("quit")) {
                                System.out.println(NAME.concat("Shutting down server!"));
                                break;
                            } else {
                                toClient.println("Try again!");
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(fromClient != null) {
                    try {
                        fromClient.close();
                        if(toClient != null) toClient.close();
                        serverEndSocket.close();
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        factorialThread.start();
    }

    public static double fact(int num) {
        if(num <= 0) return 1;
        int fact = 1, i = 1;
        while(i <= num) {
            fact = fact * i;
            i++;
        }
        return fact;
    }
}
