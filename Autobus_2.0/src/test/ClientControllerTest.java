package test;

import autoBus.Autobus;
import autoBus.Tour;
import client.controller.ClientController;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 5/1/2017.
 */
public class ClientControllerTest {

    private ClientController clientController;
    private ArrayList<Tour> toursFromMainApplication;

    @org.junit.Before
    public void setUp() throws Exception {
        clientController = ClientController.getInstance();
        Autobus.main(null);
        toursFromMainApplication = Autobus.toursArchive.getToursArchive();

    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.exit(0);
    }

    @org.junit.Test
    public void getToursTest() throws Exception {
        List<Tour> tours = clientController.getTours();
        //Assert.assertEquals();
    }

    @org.junit.Test
    public void getToursFromServerTest() throws Exception {

    }

    @org.junit.Test
    public void loginTest() throws Exception {

    }

    @org.junit.Test
    public void logoutTest() throws Exception {

    }

    @org.junit.Test
    public void updateTest() throws Exception {

    }

}