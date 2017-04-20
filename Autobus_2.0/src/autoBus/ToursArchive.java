package autoBus;

import common.remote_interfaces.RemoteToursArchive;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubjectDelegate;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ToursArchive implements Serializable, RemoteToursArchive{

	private static final long serialVersionUID = 1L;
	private ArrayList<Tour> toursArchive;
	private transient RemoteSubjectDelegate<ArrayList<Tour>> remoteSubjectDelegate;
	
	/**
	 * This is a constructor for this ToursArchive
	 */
	public ToursArchive() throws RemoteException{
		toursArchive=new ArrayList<Tour>();
		remoteSubjectDelegate = new RemoteSubjectDelegate<>(this);
		try {
			UnicastRemoteObject.exportObject(this, 0);
			@SuppressWarnings("unused")
			Registry registry = LocateRegistry.createRegistry(1099);
			Naming.rebind("toursArchive", this);
		} catch (RemoteException | MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This returns int with size of this ToursArchive ArrayList
	 * @return size of this Tours Archive
	 */
	public int size(){
		return toursArchive.size();
	}
	
	/**
	 * This returns a specified Tour from this ToursArchive with Tour type
	 * @param index - index of Tour
	 * @return specified Tour from this Tours Archive
	 */
	public Tour get(int index){
		return toursArchive.get(index);
	}
	
	/**
	 * This returns this toursArchive ArrayList<Tour>
	 * @return this toursArchive
	 */
	/*public ArrayList<Tour> getTours(){
		return toursArchive;
	}
	*/
	/**
	 * This returns String with: dateInterval of specified Tour from this ToursArchive ArrayList<Tour>
	 * @param index - index of Tour
	 * @return date interval String for specified Tour from this ToursArchive
	 */
	public String getDateInterval(int index){
		return toursArchive.get(index).getDateIntervalString();
	}
	
	/**
	 * This returns String with: pickUpPlaces of specified Tour from this ToursArchive ArrayList<Tour>
	 * @param index - index of Tour
	 * @return pick up places for specified Tour from this ToursArchive
	 */
	public String getPickUpPlaces(int index){
		return toursArchive.get(index).getPickUpPlacesString();
	}
	
	/**
	 * This returns String with: Services of specified Tour from this ToursArchive ArrayList<Tour>
	 * @param index - index of Tour
	 * @return Services for specified Tour from this ToursArchive
	 */
	public String getServices(int index){
		return toursArchive.get(index).getServicesString();
	}
	
	/**
	 * This returns String with: pricePerPassengerString() for specified Tour from this ToursArchive ArrayList<Tour>
	 * @param index - index of Tour
	 * @return price per passenger String for specified Tour from this ToursArchive
	 */
	public String getPricePerPassengerString(int index){
		return toursArchive.get(index).getPricePerPassengerString();
	}
	
	/**
	 * This returns String with: busIdAndType for specified Tour from this ToursArchive ArrayList<Tour>
	 * @param index - index of Tour
	 * @return bus ID and type String for specified Tour from this ToursArchive
	 */
	public String getBusIdAndType(int index){
		return toursArchive.get(index).getBusAndType();
	}
	
	/**
	 * This returns String with: Chauffeur for specified Tour from this ToursArchive ArrayList<Tour>
	 * @param index - index of Tour
	 * @return Chauffeur for specified Tour from this ToursArchive
	 */
	public String getChauffeur(int index){
		return toursArchive.get(index).getChauffeur();
	}
	
	/**
	 * This adds a Tour to this toursArchive ArrayList<Tour>
	 * @param tour - Tour to be added
	 */
	public void addTour(Tour tour){
		toursArchive.add(tour);
		this.remoteSubjectDelegate.notifyObservers(toursArchive);
	}
	
	/**
	 * This removes specified tour from toursArchive
	 * @param index - index of  Tour
	 */
	public void removeTour(int index){
		toursArchive.remove(index);
		this.remoteSubjectDelegate.notifyObservers(toursArchive);
	}
	
	/**
    * This returns a boolean if the file exists
    * @return path of this file
    */
	public boolean isFileFound(){
		Path path = Paths.get("C:\\Autobus\\ToursArchive.dat");
		return (Files.exists(path));
	}
	
	/**
    * This creates a new file
    * @throws Exception
    */
	public void createFile() throws Exception{
		addTour(new Tour(""));
		saveToursArchive();
		toursArchive.remove(0);
		saveToursArchive();
	}
	
	/**
    * This saves toursArchive after changes have been made
    * @throws Exception
    */
	public void saveToursArchive() throws Exception{
		Path path = Paths.get("C:\\Autobus");
		if (!Files.exists(path)){
			try {
				Files.createDirectory(path);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error: Unable to create directory!");
			}		
		}
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Autobus\\ToursArchive.dat");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		try {
			objectOutputStream.writeObject(toursArchive);
		} finally {
			objectOutputStream.close();
		}
	}
	
	/**
    * This loads already existing toursArchive 
    * @throws Exception
    */
	@SuppressWarnings("unchecked")
	public void loadToursArchive() throws Exception{
		FileInputStream fileInputStream = new FileInputStream("C:\\Autobus\\ToursArchive.dat");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		try {
			this.toursArchive= (ArrayList<Tour>)objectInputStream.readObject();
			for (int i = 0; i < this.toursArchive.size(); i++) {
				Bus oldBus = this.toursArchive.get(i).getBus();
				Chauffeur oldChauffeur = this.toursArchive.get(i).getChauffeursObject();
				for (int j = 0; j < Autobus.busesArchive.size(); j++) {
					if(oldBus.getVehicleID().equals(Autobus.busesArchive.get(j).getVehicleID())
							&& oldBus.getModelString().equals(Autobus.busesArchive.get(j).getModelString())) {
						toursArchive.get(i).setBus(Autobus.busesArchive.get(j));
						break;
					}
				}
				for (int j = 0; j < Autobus.chauffeursArchive.size(); j++) {
					if(oldChauffeur.getName().equals(Autobus.chauffeursArchive.get(j).getName())
							&& oldChauffeur.getPhonenumber().equals(Autobus.chauffeursArchive.get(j).getPhonenumber())){
						toursArchive.get(i).setChauffeur(Autobus.chauffeursArchive.get(j));
						break;
					}
				}
			}
		} finally {
			objectInputStream.close();
		}
	}


	/**
	 * This returns this ToursArchive ArrayList<Tour>
	 * @return this Tours Archive
	 */
	public ArrayList<Tour> getToursArchive() {
		return toursArchive;
	}

	@Override
	public void addObserver(RemoteObserver<ArrayList<Tour>> remoteObserver) throws RemoteException {
		this.remoteSubjectDelegate.addObserver(remoteObserver);
	}

	@Override
	public void deleteObserver(RemoteObserver<ArrayList<Tour>> remoteObserver) throws RemoteException {
		this.remoteSubjectDelegate.deleteObserver(remoteObserver);
	}

	@Override
	public ArrayList<Tour> getTours() throws RemoteException {
		return toursArchive;
	}
}
