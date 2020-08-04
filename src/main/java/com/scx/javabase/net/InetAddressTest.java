package com.scx.javabase.net;

import java.net.InetAddress;

/**
 * @author scx
 * @date 2020-08-04 15:23
 * @Description
 */
public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        InetAddress inetAddress = InetAddress.getLocalHost();
        String address = inetAddress.getHostAddress();
        String hostName = inetAddress.getHostName();
        byte[] bytes = inetAddress.getAddress();
        String canonicalHostName = inetAddress.getCanonicalHostName();
        System.out.println(address);
        System.out.println(hostName);
        for(Byte b : bytes){
            System.out.println(b);
        }
        System.out.println(canonicalHostName);
    }
}
