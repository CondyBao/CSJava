package Messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final Socket clientSocket;
        final BufferedReader in;
        final PrintWriter out;
        final Scanner inp = new Scanner(System.in);
        try {
            clientSocket = new Socket("localhost", 6666);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream());
            Thread send = new Thread(new Runnable() {
                String data;
                @Override
                public void run() {
                    while (true) {
                        data = inp.nextLine();
                        out.println(data);
                        out.flush();
                    }
                }
            });
            send.start();
            Thread receive = new Thread(new Runnable() {
                String data;
                @Override
                public void run() {
                    try {
                        data = in.readLine();
                        while (data != null) {
                            System.out.println("Server:" + data);
                            data = in.readLine();
                        }
                        System.out.println("Server Terminated");
                        out.close();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            receive.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
