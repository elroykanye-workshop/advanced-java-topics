package elroykanye.tcpfact;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFactClientConcurrent {

    private final static Integer PORT = 6789;
    private ServerSocket serverSocket = null;

    public static void runner() {
        TCPFactClientConcurrent serverConcurrent = new TCPFactClientConcurrent();
        serverConcurrent.init();
        serverConcurrent.launch();
    }

    public static void main(String[] args) {
        runner();
    }

    public void init() {
        try {
            this.serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on PORT: " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launch() {
        while(true) {
            try {
                Socket serverEnd = serverSocket.accept();
                new Thread(new Handler(serverEnd)).start();

            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

class Handler implements Runnable {
    private final static String NAME = "TCPFact SERVER ::::::::::::::: ";
    Socket serverEnd;
    public Handler(Socket s) {
        serverEnd = s;
    }

    @Override
    public void run() {
        System.out.println("Server started");
        BufferedReader fromClient = null;
        PrintWriter toClient = null;
        try {
            fromClient = new BufferedReader(new InputStreamReader(serverEnd.getInputStream()));
            toClient = new PrintWriter(new OutputStreamWriter(serverEnd.getOutputStream()), true);

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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fromClient != null) {
                try {
                    fromClient.close();
                    if(toClient != null) toClient.close();
                    serverEnd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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