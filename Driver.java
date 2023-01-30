
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

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	 /*******************************************************************************************************************************************
    	  * TODO : implement all the operations of main class   																					*
    	  ******************************************************************************************************************************************/
        System.out.println(Thread.currentThread().getPriority());
    	Network objNetwork = new Network("network");            /* Activate the network */
        objNetwork.start();
        //objNetwork.setPriority(5);
        Server objServer = new Server(); 
        objServer.start(); 
        Client objClientSend = new Client("sending");
        Client objClientReceive = new Client("receiving");
        //objServer.setPriority(3);
        objClientSend.start();
        //objClientSend.setPriority(4);
        objClientReceive.start();
        //objClientReceive.setPriority(2);

        System.out.println(objNetwork.getPriority());
        System.out.println(objServer.getPriority());
        System.out.println(objClientSend.getPriority());
        System.out.println(objClientReceive.getPriority());

        while(objNetwork.isAlive()){
            if(objNetwork.getInBufferStatus() == "full"){
                objClientSend.yield();
                System.out.println("Yielding");
            }
            if(objNetwork.getOutBufferStatus() == "full"){
                objServer.yield();
            }
        }
        /* Complete here the code for the main method ...*/
    }
}
