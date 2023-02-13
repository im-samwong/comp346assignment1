import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class Driver {

    public static boolean printDebug = false;
    public static PrintWriter stream = null;
    /** 
     * main class
     * @param args the command line arguments
     * @throws InterruptedException
     */
    public static void main(String[] args) 
    {
        try
        {
            stream = new PrintWriter(new FileOutputStream("output.txt", true));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    	

        stream.println("Size = 10");
        stream.println("---------");


    	 /*******************************************************************************************************************************************
    	  * TODO : implement all the operations of main class   																					*
    	  ******************************************************************************************************************************************/
        
    	Network objNetwork = new Network("network");            /* Activate the network */
        objNetwork.start();
        Server objServer = new Server();        
        /* Complete here the code for the main method ...*/
        objServer.start();

        Client objClientSend = new Client("sending");
        Client objClientReceive = new Client("receiving");


        objClientSend.start();
        objClientReceive.start();

        try 
        {
            objClientSend.join();
            objClientReceive.join();
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
        
        objNetwork.disconnect(objNetwork.getClientIP());

        try 
        {
            objServer.join();
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }

        objNetwork.disconnect(objNetwork.getServerIP());



        if(stream != null)
            stream.close();
    }
}
