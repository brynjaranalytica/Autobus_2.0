package client.model;

import autoBus.Tour;

/**
 * Created by lenovo on 4/21/2017.
 */
public class Model {
    private ProxyArrayList<Tour> tours;

    public Model() {
        this.tours = new ProxyArrayList<>();
    }

    public ProxyArrayList<Tour> getTours() {
        return tours;
    }

}
