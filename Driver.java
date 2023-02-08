
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

    public static boolean debugging = true;
    /** 
     * main class
     * @param args the command line arguments
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
    	
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


        // objServer.join();

        objClientSend.start();
        objClientReceive.start();

        long millis = System.currentTimeMillis();
        while(true)
        {
            if(System.currentTimeMillis() - millis > 5)
                System.exit(0);
        }


        // try {
        //     objServer.join();
        //     objNetwork.join();
        //     objSend.join();
        //     objReceive.join();
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        //network
        //network receive transaction from client (incomingpacket)
        //network send transaction to client (outgoingpacket)

        //client
        //send
        //client transfer to network, yield if buffer full (incoming)
        //receive
        //client receive from network, yield if buffer empty (outgoing)

        //server
        //transferin
        //server receive from network, yield if buffer empty
        //transferout
        //server send to network, yield if buffer full


    }
}
