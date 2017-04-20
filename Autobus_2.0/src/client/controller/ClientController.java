package client.controller;


/**
 * Created by lenovo on 4/20/2017.
 */
public class ClientController {

	private static ClientController instance = new ClientController(); //Created in memory beforehand
	
	private  ClientController() {
		
	}
	
	public static ClientController getInstance(){
		return instance;
	}
}
