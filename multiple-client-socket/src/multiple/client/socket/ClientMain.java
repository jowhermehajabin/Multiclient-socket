/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.client.socket;

import java.net.Socket;

/**
 *
 * @author HP
 */
public class ClientMain {
    
    public static void main(String[] args) {
        try{
            
            Socket socket = new Socket("localhost",1210);
            System.out.println("Connected to server");
            new Thread(new ClientReader(socket)).start();
            new Thread(new ClientWriter(socket)).start();
            while(true){
                
            }
            
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
}
