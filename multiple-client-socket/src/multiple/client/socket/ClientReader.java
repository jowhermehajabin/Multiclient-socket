/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.client.socket;

import java.io.DataInputStream;
import java.net.Socket;

/**
 *
 * @author HP
 */
public class ClientReader implements Runnable {

    private Socket socket;

    public ClientReader(Socket s) {
        this.socket = s;
    }

    @Override
    public void run() {

        DataInputStream dis = null;
        try {
            dis = new DataInputStream(socket.getInputStream());
            while (true) {
               String msgin = dis.readUTF();
               System.out.println("Server: " + msgin);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
