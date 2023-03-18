package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8090;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {

            String resp = in.readLine();
            if(resp.equals("Write your name")) {
                out.println("Netology");
            }
            else if(resp.equals("Are you child? (yes/no)")){
                out.println("no");
            }
            System.out.println(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
