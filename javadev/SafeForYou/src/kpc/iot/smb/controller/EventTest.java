//package kpc.iot.smb.controller;
//
//import java.io.BufferedReader;
//import java.net.Socket;
//
//public class EventTest {
//	 public static void main(String args[]) {
//
//	      try {
//
//	         Socket skt = new Socket("192.168.0.30", 1234);
//
//	         BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
//
//	         System.out.print("Received string: '");
//
//	         while (!in.ready()) {}
//
//	         System.out.println(in.readLine()); // Read one line and output it
//
//	         System.out.print("'\n");
//	         in.close();
//
//	      }catch(Exception e) {
//	         System.out.print("Connection Failed\n");
//	         e.printStackTrace();
//
//	      }
//
//	   }
//
//	}
