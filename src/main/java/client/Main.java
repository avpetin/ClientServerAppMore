package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8090;
        String userResp;

        Scanner scanner = new Scanner(System.in);
        while(true) {
            try (Socket clientSocket = new Socket(host, port);
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
            ) {
                while (true) {
                    String resp = in.readLine();
                    if (resp.equals("Write your name")) {
                        System.out.println(resp);
                        userResp = scanner.nextLine();
                        out.println(userResp);
                    } else if (resp.equals("Are you child? (yes/no)")) {
                        System.out.println(resp);
                        userResp = scanner.nextLine();
                        out.println(userResp);
                        break;
                    } else if(resp.startsWith("Welcome")){
                        System.out.println(resp);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
