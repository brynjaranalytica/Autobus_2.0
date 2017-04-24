package client.controller;

import autoBus.Tour;
import client.model.Model;
import client.view.View;
import common.remote_interfaces.RemoteToursArchive;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ClientController implements RemoteObserver<ArrayList<Tour>> {
    private RemoteToursArchive toursArchive;
    private Model model;
    //YET TO BE IMPLEMENTED
    private static View view;

    public static void main(String[] args) {
        ClientController.getInstance().model = new Model();
        view = new View();


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

    //CHECKS WHEREVER THE TOURS ARE AVAILABLE IN MODEL ON CLIENT SIDE.
    // IF NOT - DOWNLOAD TOURS FROM SERVER AND SAVES THEM TO THE MODEL ON CLIENT SIDE.
    public List<Tour> getTours(){
        return model.getTours();
    }

    //DOWNLOADS THE ARRAY LIST OF TOURS FROM SERVER.
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
        model.getTours().setRealList(tours);
        view.loadData();
    }

    private static class Wrapper{ //Instance placed in inner class
        static ClientController instance;
        static{
            try {
                instance = new ClientController();
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
