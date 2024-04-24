package com.tutorial.networking;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkingDemo {
    public static void main(String[] args) throws UnknownHostException {
        String url = "www.google.ro";
        InetAddress inetAddress = Inet4Address.getByName(url);
        byte[] address =inetAddress.getAddress();
        System.out.println("Address is: " + Arrays.toString(address));
        System.out.println("Host address: "+inetAddress.getHostAddress());

        System.out.println("isAnyLocalAddress :" + inetAddress.isAnyLocalAddress());

        System.out.println("isLinkedLocalAddress :" + inetAddress.isLinkLocalAddress());
        System.out.println("isLoopBackAddress: " + inetAddress.isLoopbackAddress());
        System.out.println("isSiteLocalAddress: " + inetAddress.isSiteLocalAddress());
        System.out.println("hashCode: "+ inetAddress.hashCode());

    }
}
