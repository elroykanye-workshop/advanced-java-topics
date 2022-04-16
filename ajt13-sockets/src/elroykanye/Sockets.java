package elroykanye;

import elroykanye.tcpfact.TCPFactClient;
import elroykanye.tcpfact.TCPFactServer;

public class Sockets {
    public static void main(String[] args) {
        TCPFactServer.runner();
        TCPFactClient.runner();
    }
}
