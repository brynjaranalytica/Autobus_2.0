package test;


import autoBus.Autobus;
import autoBus.Tour;
import client.controller.ClientController;
import client.model.Model;
import common.remote_interfaces.RemoteToursArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 5/1/2017.
 */
public class ClientControllerTest {

    private ClientController clientController;
    private ArrayList<Tour> toursFromMainApplication;
    private RemoteToursArchive toursArchive;
    private Autobus autobus;

    @Before
    public void setUp() throws Exception{
        autobus = new Autobus();
        toursFromMainApplication = Autobus.toursArchive.getToursArchive();
        ClientController.getInstance().model = new Model();
        clientController = ClientController.getInstance();

    }

    @Test
    public void getToursTest() throws Exception {


        List<Tour> tours = clientController.getTours();

        Assert.assertEquals(tours.get(0), toursFromMainApplication.get(0));
        Assert.assertEquals(tours.get(1), toursFromMainApplication.get(1));
        Assert.assertEquals(tours.get(2), toursFromMainApplication.get(2));
    }

    @Test
    public void getToursFromServerTest() throws Exception {
        List<Tour> tours = clientController.getToursFromServer();

        Assert.assertEquals(tours.get(0), toursFromMainApplication.get(0));
        Assert.assertEquals(tours.get(1), toursFromMainApplication.get(1));
        Assert.assertEquals(tours.get(2), toursFromMainApplication.get(2));
    }

    @Test
    public void loginTest() throws Exception {
        toursArchive = clientController.getToursArchive();

        boolean loginBoolean1 = toursArchive.login("wrongEmail1", "wrongPassword1");
        Assert.assertFalse(loginBoolean1);
        boolean loginBoolean2 = toursArchive.login("wrongEmail1", "wrongPassword1");
        Assert.assertFalse(loginBoolean2);

        boolean loginBoolean3 = toursArchive.login("mogens@gmail.com", "1234");
        Assert.assertTrue(loginBoolean3);
        boolean loginBoolean4 = toursArchive.login("hazamadra@hotbox.com", "1111");
        Assert.assertTrue(loginBoolean4);
    }


}