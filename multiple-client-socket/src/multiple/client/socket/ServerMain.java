/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.client.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ServerMain {

    static Socket client;
    static ServerSocket serversocket = null;

    public static void main(String[] args) throws IOException {

        ArrayList<ServerReader> reader = new ArrayList<>();
        ArrayList<ServerWriter> writer = new ArrayList<>();

        try {

            serversocket = new ServerSocket(1210);
            System.out.println("Server started");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {

                        try {
                            client = serversocket.accept();
                            DataInputStream dis = new DataInputStream(client.getInputStream());
                            String clientName = dis.readUTF();
                            System.out.println("Connected to "+clientName);
                            ServerReader serverreader = new ServerReader(client, clientName);
                            ServerWriter serverwriter = new ServerWriter(client, clientName);
                            //starting the thread
                            reader.add(serverreader);
                            writer.add(serverwriter);
                            //System.out.println("Client added");
                            new Thread(serverreader).start();
//                serverreader.start();
                        } catch (IOException ex) {
                            Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
            }).start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Scanner scanner = new Scanner(System.in);
        
        while(true)
        {
            String ClientName = scanner.nextLine() ;
            String msgout = scanner.nextLine();
            for(int i=0;i<writer.size();i++)
            {
                ServerWriter user = writer.get(i);
                if(user.username.equals(ClientName))
                {
                    user.dos.writeUTF(msgout);
                    user.dos.flush();
                }
            }
        }

    }

}
