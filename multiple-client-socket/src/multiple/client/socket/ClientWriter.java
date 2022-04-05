/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.client.socket;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class ClientWriter implements Runnable {
    
    private Socket socket;
    public ClientWriter(Socket s)
    {
        this.socket = s;
    }

    @Override
    public void run() {
     
        DataOutputStream dos = null;
        Scanner scanner = null;
        
        try{
            dos = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);
            System.out.print("Please enter your name: ");
            String clientName= scanner.nextLine();
            dos.writeUTF(clientName);
            
            while(true)
            {
                String msgout = scanner.nextLine();
                dos.writeUTF(msgout);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage()); 
        }
    }
        
    }