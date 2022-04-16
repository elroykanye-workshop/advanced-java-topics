package elroykanye;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class GetNetworkInterface {
    public static void runner() {
        try {
            System.setProperty("java.net.preferIPv4Stack", "true");
            Enumeration<NetworkInterface> intfs = NetworkInterface.getNetworkInterfaces();

            interfaceName(intfs);
            interfaceProperties(intfs);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    private static void interfaceName(Enumeration<NetworkInterface> intfs) {

        while(intfs.hasMoreElements()) {
            NetworkInterface networkInterface = intfs.nextElement();
            System.out.println("Interface: " + networkInterface.getName());
            System.out.println("Display name: " + networkInterface.getDisplayName());
            System.out.println("Addresses: ");
            var addresses = networkInterface.getInetAddresses();
            while(addresses.hasMoreElements()) {
                var address = addresses.nextElement();
                System.out.println("\t" +  address);
            }

            Enumeration<NetworkInterface> subIntfs = networkInterface.getSubInterfaces();
            while(subIntfs.hasMoreElements()) {
                NetworkInterface subIntf = subIntfs.nextElement();
                System.out.println("Sub interface: " + subIntf.getName());
                System.out.println("Sub interface display name: " + subIntf.getDisplayName());
                System.out.println("Sub Addresses: ");
                var subAddresses = networkInterface.getInetAddresses();
                while(subAddresses.hasMoreElements()) {
                    var subAddress = subAddresses.nextElement();
                    System.out.println("\t" +  subAddress);
                }
            } System.out.println("\n");
        }
    }

    private static void interfaceProperties(Enumeration<NetworkInterface> intfs) {
        while (intfs.hasMoreElements()) {
            NetworkInterface intf = intfs.nextElement();

            System.out.println("Name: " + intf.getName());
            System.out.println("Display name: " + intf.getDisplayName());
            try {
                System.out.println("Up: " + intf.isUp());
                System.out.println("Loopback: " + intf.isLoopback());
                System.out.println("PointToPoint: " + intf.isPointToPoint());
                System.out.println("Supports multicast: " + intf.supportsMulticast());
            } catch (SocketException e) {
                e.printStackTrace();
            }
            System.out.println("Virtual: " + intf.isVirtual());

            try {
                byte[] mac1 = intf.getHardwareAddress();
                if(mac1 != null) {
                    System.out.print("Hardware address: ");
                    for(int k = 0; k < mac1.length; k++) {
                        System.out.format("%02X%s", mac1[k], (k < mac1.length - 1) ? "-" : "");
                    }
                    System.out.println();
                    System.out.println("MTU: " + intf.getMTU());
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
