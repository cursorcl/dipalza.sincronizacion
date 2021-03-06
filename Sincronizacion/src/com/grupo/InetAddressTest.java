package com.grupo;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class InetAddressTest {
 
    public static void main(String[] args) throws Exception {
        
      Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
      while (en.hasMoreElements()) {
        NetworkInterface networkInterface = (NetworkInterface) en.nextElement();
        System.out.println(networkInterface.getName());
      }
      
      InetAddress ip;
      try {
   
          ip = InetAddress.getLocalHost();
          System.out.println("Current IP address : " + ip.getHostAddress());
   
          NetworkInterface network = NetworkInterface.getByInetAddress(ip);
   
          byte[] mac = network.getHardwareAddress();
   
          System.out.print("Current MAC address : ");
   
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < mac.length; i++) {
              sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));        
          }
          System.out.println(sb.toString());
   
      } catch (UnknownHostException e) {
   
          e.printStackTrace();
   
      } catch (SocketException e){
   
          e.printStackTrace();
   
      }
//        // Get by host name
//        InetAddress javalobby = InetAddress.getByName("trauco");
//        // Get by IP as host name
//        InetAddress byIpAsName = InetAddress.getByName("192.168.0.102");
//        // Get by IP as highest-order byte array
//        InetAddress byIp = InetAddress.getByAddress(new byte[] { (byte)192, (byte)168, (byte)0, (byte)102});
//        // Get Local address
//        InetAddress local = InetAddress.getLocalHost();
//        // Get Local Address by Loopback IP
//        InetAddress localByIp = InetAddress.getByName("127.0.0.1");
//        
//        printAddressInfo("By-Name (Javalobby.org)", javalobby);
//        printAddressInfo("By-Name (Using IP as Host)", byIpAsName);
//        printAddressInfo("By-IP: (192.168.0.102)", byIp);
//        printAddressInfo("Special Local Host", local);
//        printAddressInfo("Local Host By IP", localByIp);
    }
 
    private static void printAddressInfo(String name, InetAddress... hosts) throws Exception {
        System.out.println("===== Printing Info for: '" + name + "' =====");
        for(InetAddress host : hosts) {         
            System.out.println("Host Name: " + host.getHostName());
            System.out.println("Canonical Host Name: " + host.getCanonicalHostName());
            System.out.println("Host Address: " + host.getHostAddress());
            System.out.println("Calculated Host Address: " + getIpAsString(host));
            System.out.print("Is Any Local: " + host.isAnyLocalAddress());
            System.out.print(" - Is Link Local: " + host.isLinkLocalAddress());
            System.out.print(" - Is Loopback: " + host.isLoopbackAddress());
            System.out.print(" - Is Multicast: " + host.isMulticastAddress());
            System.out.println(" - Is Site Local: " + host.isSiteLocalAddress());
            System.out.println("Is Reachable in 2 seconds: " + host.isReachable(2000));
        }
    }
    private static String getIpAsString(InetAddress address) {
        byte[] ipAddress = address.getAddress();
        StringBuffer str = new StringBuffer();
        for(int i=0; i<ipAddress.length; i++) {
            if(i > 0) str.append('.');
            str.append(ipAddress[i] & 0xFF);                
        }
        return str.toString();
    }
}
