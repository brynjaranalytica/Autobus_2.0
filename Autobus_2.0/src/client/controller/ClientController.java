package client.controller;

import autoBus.Tour;
import common.remote_interfaces.RemoteToursArchive;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by lenovo on 4/20/2017.
 */
public class ClientController implements RemoteObserver<ArrayList<Tour>> {
    private RemoteToursArchive toursArchive;
    //YET TO BE IMPLEMENTED
    //private static View view;

    public static void main(String[] args) {
        ClientController controller = ClientController.getInstance();
        ArrayList<Tour> tours = controller.getToursFromServer();
        for(Tour tour: tours)
            System.out.println(tour);
    }

    private ClientController() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        try {
            toursArchive = (RemoteToursArchive) Naming.lookup("rmi://localhost:1099/toursArchive");
            toursArchive.addObserver(this);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Tour> getToursFromServer(){
        try {
            return toursArchive.getTours();
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("Could not get tours info from server");
        }
        return null;
    }

    @Override
    public void update(RemoteSubject<ArrayList<Tour>> remoteSubject, ArrayList<Tour> tours) throws RemoteException {
        //YET TO BE IMPLEMENTED
        //view.loadData(tours);
        for(Tour tour: tours){
            System.out.println(tour);
        }
    }

    private static class Wrapper{ //Instance placed in inner class
        static ClientController instance;
        static{
            try {
                new ClientController();
            } catch (RemoteException e) {
                e.printStackTrace();
                System.out.println("Could not connect to server");
            }
        }//Created in memory when called
    }


    public static ClientController getInstance(){
        return Wrapper.instance; //Instantiates the instance when called
    }

}
