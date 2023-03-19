package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8090;
        String name = null;
        String isChild;
        int step = 0;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    System.out.println("New connection accepted");
                    switch (step){
                        case 0:
                            out.println("Write your name");
                            step++;
                            break;
                        case 1:
                            name = in.readLine();
                            if(name != null){
                                out.println("Are you child? (yes/no)");
                                step++;
                            }
                            break;
                        case 2:
                            isChild = in.readLine();
                            if(isChild != null){
                                if(isChild.equals("yes")) {
                                    out.println("Welcome to the kids area, " + name + "! Let's play!");
                                }
                                else if(isChild.equals("no")) {
                                    out.println(String.format("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!"));
                                }
                                step++;
                            }
                            break;
                    }

                }
            }
        }
    }
}