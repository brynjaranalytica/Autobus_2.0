package common.remote_interfaces;

import autoBus.Tour;
import utility.observer.RemoteSubject;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by lenovo on 4/20/2017.
 */
public interface RemoteToursArchive extends RemoteSubject<ArrayList<Tour>> {
    ArrayList<Tour> getTours() throws RemoteException;
}
