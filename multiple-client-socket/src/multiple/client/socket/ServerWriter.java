/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.client.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class ServerWriter {
    
    private Socket socket;
    public String username;
    public DataOutputStream dos;
    public ServerWriter(Socket s,String username) throws IOException
    {
        this.socket = s;
        this.username=username;
        this.dos=new DataOutputStream(s.getOutputStream());
    }

}
